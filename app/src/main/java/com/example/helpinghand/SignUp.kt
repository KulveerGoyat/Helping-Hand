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
class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        databaseHelper = DatabaseHelper(this)

        val signupname = findViewById<EditText>(R.id.signupname)
        val signupuser = findViewById<EditText>(R.id.Signupuser)
        val signupemail = findViewById<EditText>(R.id.signupemail)
        val signuppassword = findViewById<EditText>(R.id.Signuppassword)
        val createbtn = findViewById<Button>(R.id.rectangle_10)
        val googlebtn1 = findViewById<Button>(R.id.googlebtn1)
        val loginText1 =  findViewById<TextView>(R.id.already_have_an_account_)
        val loginText2 =  findViewById<TextView>(R.id.login)

        createbtn.setOnClickListener{
            val name = signupname.text.toString()
            val user = signupuser.text.toString()
            val email = signupemail.text.toString()
            val pswd = signuppassword.text.toString()

            signupdb(name, user ,email ,pswd)

        }
        googlebtn1.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://shorturl.at/FmBXp"))
            startActivity(intent)
        }
        loginText1.setOnClickListener{
            startActivity(Intent(this,Login::class.java))

        }
        loginText2.setOnClickListener{
            startActivity(Intent(this,Login::class.java))

        }
    }
    private fun signupdb(name:String, username:String, email : String, password:String){
        val insertedRowId = databaseHelper.insertdata(name, username, email, password )
        if(insertedRowId !=-1L){
            Toast.makeText(this,"Signup Successful.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,Login::class.java))
            finish()
        }else{
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Signup Failed")
            builder.setMessage("Please fill all details!")
            builder.setPositiveButton("OK") { dialog,_ ->
                dialog.dismiss()
            }
            builder.create().show()
        }
    }
}