package com.chandsemma.activitylifecycle

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_message.*

class MessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        if(intent!=null){
            intent.getStringExtra("Text")
            //txtMessage=intent.getStringExtra("Text")

        }
    }
}