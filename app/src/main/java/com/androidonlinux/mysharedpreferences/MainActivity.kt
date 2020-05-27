package com.androidonlinux.mysharedpreferences

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "Activity 1"
        val sharedPreferences = getSharedPreferences("sample", Context.MODE_PRIVATE)

        // restore existing value
        val current = sharedPreferences.getInt("A_NUMBER", 0)
        editText.setText("$current")

        button.setOnClickListener {
            val text = editText.text.toString()

            val value = try {
                text.toInt()
            } catch (e: NumberFormatException) {
                0
            }

            sharedPreferences.edit().putInt("A_NUMBER", value).apply()

            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
