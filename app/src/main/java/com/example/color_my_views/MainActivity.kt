package com.example.color_my_views

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.color_my_views.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // create binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inflate views/layout
        binding = ActivityMainBinding.inflate(layoutInflater)

        // function for applying view color listeners
        setListener()

        // output content view
        setContentView(binding.mainConstraintLayout)
    }

    // creates a list of available views,
    // sets onClickListeners on each view,
    // as well as color functions to each view
    private fun setListener() {

        binding.apply {

            val list: List<View> = listOf(
                boxOneText, boxTwoText,
                boxThreeText, boxFourText,
                boxFiveText, mainConstraintLayout,
                redButton, yellowButton, greenButton
            )

            list.forEach { view: View ->
                view.setOnClickListener { colorThisView(it) }
            }
        }
    }

    // applies a specific color to the passed view
    private fun colorThisView(view: View) {

        binding.apply {

            when (view) {
                // assign a color provided by the Color class
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)

                // assign a color provided by Android resources
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)

                // reassign colors to boxes 3-5
                redButton -> boxThreeText.setBackgroundResource(R.color.red)
                yellowButton -> boxFourText.setBackgroundResource(R.color.yellow)
                greenButton -> boxFiveText.setBackgroundResource(R.color.green)

                // color assigned to Constraint Layout
                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }
}