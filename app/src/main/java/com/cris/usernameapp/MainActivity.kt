package com.cris.usernameapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSignIn.setOnClickListener {

            val str1 = editUsername.text.toString()
            val str2 = editPassword.text.toString()

            if (str1 == "Abc123" && str2 == "Abc") {
                Toast.makeText(this, "You're free to go! :)", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Try again", Toast.LENGTH_SHORT ).show()
            }

        }

        buttonForgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

        buttonSignUp.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}
