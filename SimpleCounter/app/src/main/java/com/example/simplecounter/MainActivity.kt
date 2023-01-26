package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
//import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Connect to Text View
        val textView = findViewById<TextView>(R.id.textView)

        //Connect to Buttons
        val button = findViewById<Button>(R.id.button)
        val upgradeButton = findViewById<Button>(R.id.upgradeBtn) //STRETCH FEATURE

        // What happens when button is clicked
        button.setOnClickListener {
            //Toast.makeText(it.context, "Clicked Button!", Toast.LENGTH_SHORT).show()
            counter++
            textView.text = counter.toString()

            // STRETCH FEATURE
            // After hitting 100 clicks, can upgrade to add 2
            if(counter >= 100) {
                //Make button visible and change props
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    button.setOnClickListener {
                        counter += 2
                        textView.text = counter.toString()
                    }
                    // Once clicked, make upgrade button invisible
                    upgradeButton.visibility = View.INVISIBLE
                }
            }
        }
    }
}