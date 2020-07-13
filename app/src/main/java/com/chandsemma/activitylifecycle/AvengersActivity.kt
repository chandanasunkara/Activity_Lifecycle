package com.chandsemma.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AvengersActivity : AppCompatActivity() {
    var titleName: String?="Avengersz"
    lateinit var sharedPref: SharedPreferences
/*
    lateinit var btnSend: Button
    lateinit var etSendingText: EditText
*/
    lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPref=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedout=sharedPref.getBoolean("isLoggedOut",false)

        setContentView(R.layout.scrollview_example)

    /*
        We are using Shared Preferences so we don't need this block any more
        if(intent!=null){
            titleName=intent.getStringExtra("Name")
        }
   */
        titleName=sharedPref.getString("Title","The Avengers")   //The Avengers is the default title
        title=titleName

/*        btnSend.setOnClickListener{

            val sendingText=etSendingText.text.toString()
            val intent=Intent(this@AvengersActivity, MessageActivity::class.java)
            intent.putExtra("Text",sendingText)
            startActivity(intent)
        }
*/
        btnLogout= findViewById(R.id.btnLogout)

        btnLogout.setOnClickListener{

            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            logoutFromApp()
            Toast.makeText(this@AvengersActivity,"Logged out",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }
    }
    fun logoutFromApp(){
        sharedPref.edit().clear().apply()
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}
