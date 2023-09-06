package com.teecode.one

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class User : AppCompatActivity() {

    lateinit var button: Button
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)

        button.setOnClickListener(){
            intent = Intent(this,MainActivity::class.java)
            startActivity(intent)


        }

    }
}