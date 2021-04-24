package com.example.ecoreport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.makeText
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent





class MainActivity : AppCompatActivity() {

    val buttons = mapOf(
        "button2" to "Нефтяной разлив",
        "button3" to "Лесной пожар",
        "button4" to "Другое",
        "button5" to "Smth",
    )

    fun onClickAction(view: View) {
        val buttonName = view.toString().substringAfterLast("app:id/")
            .dropLast(1)
        val value = buttons.getValue(buttonName)

        val intent = Intent(this, DescriptionActivity::class.java)

        intent.putExtra(DescriptionActivity.problemName, value)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}