package com.learnprogramming.academy.lesson2colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    /**
     *  Widget Initialisation
     */
    // Text Views
    private val _BoxOne: TextView by lazy { findViewById<TextView>(R.id.box_one_text) }
    private val _BoxTwo: TextView by lazy { findViewById<TextView>(R.id.box_two_text) }
    private val _BoxThree: TextView by lazy { findViewById<TextView>(R.id.box_three_text) }
    private val _BoxFour: TextView by lazy { findViewById<TextView>(R.id.box_four_text) }
    private val _BoxFive: TextView by lazy { findViewById<TextView>(R.id.box_five_text) }

    // Background
    private val _BackGround: ConstraintLayout by lazy { findViewById<ConstraintLayout>(R.id.background_constraint_view) }

    // Buttons
    private val _ButtonRed: Button by lazy { findViewById<Button>(R.id.button_red) }
    private val _ButtonBlue:Button by lazy { findViewById<Button>(R.id.button_blue)}
    private val _ButtonGreen:Button by lazy {findViewById<Button>(R.id.button_green)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        _setListners()
    }

    private fun _setListners() {

        // The ClickableViews List Needs To Be Of Type View In Order To Accomadate The Constraint Layout
        val clickableViews: List<View> = listOf(_BoxOne, _BoxTwo, _BoxThree, _BoxFour, _BoxFive, _BackGround,_ButtonBlue
        ,_ButtonGreen,_ButtonRed)

        for (item in clickableViews) {
            item.setOnClickListener { _makeColoured(it) }
        }

    }

    private fun _makeColoured(view: View?) {

        when (view?.id) {

            // Boxes using Color class colors for background
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            R.id.button_red -> _BoxThree.setBackgroundResource(R.color.my_red)
            R.id.button_blue -> _BoxFour.setBackgroundResource(R.color.my_blue)
            R.id.button_green -> _BoxFive.setBackgroundResource(R.color.my_green)


            // You Have Essentially Selected The Constraint Layout (_Background)

            else -> view?.setBackgroundColor(Color.LTGRAY)
        }
    }
}
