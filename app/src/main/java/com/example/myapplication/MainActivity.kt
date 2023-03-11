package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val colors = arrayOf("Red", "Green", "Blue", "Yellow", "DKgray",
            "Cyan", "LTgray", "Magenta", "Gray", "Black", "White")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, colors)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val colorspinner = findViewById(R.id.colorspinner) as Spinner
        colorspinner.adapter = adapter
        colorspinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }


        val changeBackgroundButton = findViewById(R.id.backcolo) as Button
        changeBackgroundButton.setOnClickListener {
            val selectedColor = colorspinner.selectedItem.toString()
            val color = getColorValue(selectedColor)
            findViewById<View>(android.R.id.content).setBackgroundColor(color)
            changeBackgroundButton.setBackgroundColor(color)

        }

        val changeButtonColorButton = findViewById(R.id.buttoncolor) as Button
        changeButtonColorButton.setOnClickListener {
            val selectedColor = colorspinner.selectedItem.toString()
            val color = getColorValue(selectedColor)
            changeButtonColorButton.setBackgroundColor(color)
        }
    }

    private fun getColorValue(selectedColor: String): Int {
        return when (selectedColor) {
            "Red" -> Color.RED
            "Green" -> Color.GREEN
            "Blue" -> Color.BLUE
            "Yellow" -> Color.YELLOW
            "DKgray" -> Color.DKGRAY
            "Cyan" -> Color.CYAN
            "LTgray" -> Color.LTGRAY
            "Magenta" -> Color.MAGENTA
            "Gray" -> Color.GRAY
            "Black" -> Color.BLACK
            "White" -> Color.WHITE
            else -> Color.BLACK
        }
    }
}