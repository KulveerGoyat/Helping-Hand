package com.example.helpinghand

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signUpbtn = findViewById<View>(R.id.Signupbtn)
        val loginText =  findViewById<TextView>(R.id.login)
        val loginText2 =  findViewById<TextView>(R.id.already_have_an_account_)

        signUpbtn.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))

        }
        loginText.setOnClickListener{
            startActivity(Intent(this,Login::class.java))

        }
        loginText2.setOnClickListener{
            startActivity(Intent(this,Login::class.java))
        }
    }
}