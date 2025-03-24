package com.example.helpinghand

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context : Context) : SQLiteOpenHelper(context, DB_NAME,null, DB_VERSION){

    companion object{
        private const val DB_NAME ="UserDB"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "userdata"
        private const val COL_ID = "id"
        private const val COL_NAME = "name"
        private const val COL_USERNAME = "username"
        private const val COL_EMAIL = "email"
        private const val COL_PASSWORD = "password"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createtable = ("CREATE TABLE $TABLE_NAME ("+
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "$COL_NAME TEXT, $COL_USERNAME TEXT, $COL_EMAIL TEXT ,$COL_PASSWORD TEXT );")
        db?.execSQL(createtable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val droptable = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(droptable)
        onCreate(db)
    }
    fun insertdata(name :String ,username:String, email:String ,password:String) :Long{
        val values = ContentValues().apply {
            put(COL_NAME,name)
            put(COL_USERNAME,username)
            put(COL_EMAIL,email)
            put(COL_PASSWORD,password)
        }
        val db = writableDatabase
        return db.insert(TABLE_NAME,null,values)
    }

    fun readdata(username:String,password:String) :Boolean{
        val db = readableDatabase
        val selection ="($COL_USERNAME = ? OR $COL_EMAIL = ?) AND $COL_PASSWORD = ?"
        val selectionArguments = arrayOf(username, username, password)
        val cursor = db.query(TABLE_NAME ,null, selection,selectionArguments,null,null,null)
        val userExists = cursor.count > 0
        cursor.close()
        return  userExists
    }

}