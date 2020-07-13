package com.chandsemma.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity(){
    lateinit var etMobileNumber: EditText
    lateinit var etPwd: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPasswd: TextView
    lateinit var butonRegister: TextView
    val validMobileNumber="5555545455"
    val validPassword=arrayOf("tony","steve","bruce","thor")
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE);
        val isLoggedin=sharedPreferences.getBoolean("isLoggedIn",false)//If it gets the value of key as "true", it will store that value in isLoggedin variable
                                    //But, if it gets no value, it means the user has not logged in even once and so the variable(i.e. isLoggedin) will take the default value which is "false".

        setContentView(R.layout.activity_login)

        if(isLoggedin){
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

 //       setContentView(R.layout.activity_login)

        title="Login"

        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPwd=findViewById(R.id.etPwd)
        btnLogin=findViewById(R.id.loginbutton)
        txtForgotPasswd=findViewById(R.id.txtForgotPwd)
        butonRegister=findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener{

            val mobileNumber=etMobileNumber.text.toString()
            val password=etPwd.text.toString()
            var nameOfAvenger="Avenger"
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)

            if(mobileNumber==validMobileNumber){
                when(password){
                    validPassword[0]-> {
                        nameOfAvenger = "Iron Man"
                        savePreferences(nameOfAvenger)
                 //       intent.putExtra("Name", nameOfAvenger)    //we don't need this now because we are using the savePreferences() method
                        startActivity(intent)
                    }
                    validPassword[1]-> {
                        nameOfAvenger = "Capitan America"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[2]-> {
                        nameOfAvenger = "The Hulk"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    validPassword[3]-> {
                        nameOfAvenger = "The Avengers"
                        savePreferences(nameOfAvenger)
                        startActivity(intent)
                    }
                    else-> Toast.makeText(this@LoginActivity,"You clicked on the button to see this Toast! \nIncorrect Credentials",Toast.LENGTH_LONG).show()
                }
/*                if(password==validPassword[0]){
                    nameOfAvenger="Iron Man"
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[1]){
                    nameOfAvenger="Capitan America"
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[2]){
                    nameOfAvenger="The Hulk"
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[3])
                {
                    nameOfAvenger="The Avengers"
                    intent.putExtra("Name",nameOfAvenger)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(
                        this@LoginActivity,"You clicked on the button to see this Toast! \nIncorrect Credentials",Toast.LENGTH_LONG).show()
                }
*/            }
            else{
                Toast.makeText(
                    this@LoginActivity,"You clicked on the button to see this Toast! \nIncorrect Credentials",Toast.LENGTH_LONG).show()
            }
        }

        butonRegister.setOnClickListener{
            Toast.makeText(this@LoginActivity,"Register yourself in the app with your details",Toast.LENGTH_LONG).show()
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()//commit()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}