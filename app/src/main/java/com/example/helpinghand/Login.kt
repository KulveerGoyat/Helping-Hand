package com.example.helpinghand

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

private lateinit var databaseHelper : DatabaseHelper
class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        databaseHelper = DatabaseHelper(this)

        val userlogin= findViewById<EditText>(R.id.signupname)
        val pswdlogin= findViewById<EditText>(R.id.loginpswd)
        val signuptext = findViewById<TextView>(R.id.don_t_have_an_account_)
        val googlebtn = findViewById<TextView>(R.id.googlebtn)
        val abc = findViewById<TextView>(R.id.sign_up)
        val loginhome = findViewById<Button>(R.id.loginhome)

        signuptext.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))
            finish()
        }
       abc.setOnClickListener{
            startActivity(Intent(this,SignUp::class.java))
            finish()
        }

        googlebtn.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW ,Uri.parse("https://shorturl.at/FmBXp"))
                startActivity(intent)

        }
        loginhome.setOnClickListener{
//            startActivity(Intent(this,home::class.java))
            val username = userlogin.text.toString()
            val password = pswdlogin.text.toString()
            if(username.isBlank() || password.isEmpty()){
                Toast.makeText(this,"Please Fill Details!", Toast.LENGTH_SHORT).show()
            } else { logindb(username, password) }
        }

    }
    private fun logindb(username:String,password:String){

        val userExists = databaseHelper.readdata(username, password)
        if(userExists){
            Toast.makeText(this,"Login Successful.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Home::class.java))
            finish()
        }else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Login Failed")
            builder.setMessage("Username or Password is wrong.")
            builder.setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
            builder.create().show()
        }
    }
}