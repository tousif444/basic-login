package com.teecode.one

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var editName: EditText
    lateinit var editEmail: EditText
    lateinit var textInfo: TextView

    lateinit var editPassword : EditText
    lateinit var editRePassword : EditText


    lateinit var textWarnName: TextView
    lateinit var textWarnEmail: TextView
    lateinit var warnPass : TextView
    lateinit var warnRePass : TextView

    //lateinit var imageView : ImageView

    lateinit var parent: ConstraintLayout



    @SuppressLint("SuspiciousIndentation")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button = findViewById(R.id.btnRegister)
        editName = findViewById(R.id.edtTxtName)
        editEmail = findViewById(R.id.edtTxtEmail)
        editPassword = findViewById(R.id.edtPass)
        editRePassword = findViewById(R.id.edtRepeatPass)

        textInfo = findViewById(R.id.txtInfo)
        parent = findViewById(R.id.parent)

        textWarnName = findViewById(R.id.warnName)
        textWarnEmail = findViewById(R.id.warnEmail)
        warnPass = findViewById(R.id.warnPass)
        warnRePass = findViewById(R.id.warnRepeatPass)



        textWarnName.setVisibility(View.GONE)
        textWarnEmail.setVisibility(View.GONE)
        warnPass.setVisibility(View.GONE)
        warnRePass.setVisibility(View.GONE)

//        imageView = findViewById(R.id.imageView)
//        imageView.setImageResource(R.drawable.ic_launcher_foreground)



        button.setOnClickListener {

            if (validateData()) {
                showSnackBar()
            }

            intent = Intent(this,User::class.java)
            startActivity(intent)

        }
    }


    private fun showSnackBar() {


        var name = editName.getText().toString()
        var email = editEmail.getText().toString()

        var snackText = "Name: $name " + "\n" +
                "Email: $email " + "\n" +
                "Welcome to Jungle"

        val snackbar = Snackbar.make(parent, snackText, Snackbar.LENGTH_LONG)
        snackbar.setAction("Dismiss") {
            Toast.makeText(this, "Thank You", Toast.LENGTH_LONG).show()


            //snackbar.dismiss()
        }
        snackbar.setActionTextColor(Color.parseColor("Blue"))
        //snackbar.view.setBackgroundColor(Color.parseColor("#1eb2a6"))
        snackbar.setTextColor(Color.parseColor("Yellow"))

        snackbar.show()

        textInfo.setText(snackText)
    }

    private fun validateData(): Boolean {

        if (editName.getText().toString().equals("")) {
            textWarnName.setVisibility(View.VISIBLE)
            textWarnName.setText("Enter your name!")
            return false
        }

        if (editEmail.getText().toString().equals("")) {
            textWarnEmail.setVisibility(View.VISIBLE)
            textWarnEmail.setText("Enter your email!")
            return false

        }
        if (editPassword.getText().toString().equals("")){
           warnPass.setVisibility(View.VISIBLE)
           warnPass.setText("Enter password of choice")
           return false
        }
        if (editRePassword.getText().toString().equals("")){
            warnRePass.setVisibility(View.VISIBLE)
            warnRePass.setText("Re-enter your password")
            return false
        }
        if (!editPassword.getText().toString().equals(editRePassword.getText().toString())){
            warnRePass.setVisibility(View.VISIBLE)
            warnRePass.setText("Password doesn't match!")
            return false
        }


        return true
    }


}