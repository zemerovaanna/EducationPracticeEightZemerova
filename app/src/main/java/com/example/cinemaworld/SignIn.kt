package com.example.cinemaworld

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.EditText
import android.widget.Toast
import com.example.cinemaworld.databinding.ActivityMainBinding
import com.example.cinemaworld.databinding.ActivitySignInBinding

class SignIn : AppCompatActivity() {
    lateinit var bindingClass: ActivitySignInBinding

    lateinit var email: String
    lateinit var password: String
    lateinit var sp: SharedPreferences
    private val APP_PREFERENCES = "MyAppPreferences"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivitySignInBinding.inflate((layoutInflater))
        setContentView(bindingClass.root)

        sp = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE)
        val EmailSaved = sp.getString("email", "")
        val PasswordSaved = sp.getString("password", "")

        if (!EmailSaved.isNullOrEmpty() && !PasswordSaved.isNullOrEmpty()) {
            if (!EmailSaved.isNullOrEmpty() && !PasswordSaved.isNullOrEmpty()) {
                bindingClass.EditTextEmail.setText(EmailSaved)
                bindingClass.EditTextPassword.setText(PasswordSaved)
            }
        }


        bindingClass.ButtonSignIn.setOnClickListener {

            email = bindingClass.EditTextEmail.text.toString()
            password = bindingClass.EditTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Поля не могут быть пустые.", Toast.LENGTH_SHORT).show()
            } else {
                val spEditor = sp.edit()
                spEditor.putString("email", email)
                spEditor.putString("password", password)
                spEditor.apply()

                var intent = Intent(this@SignIn, Collection::class.java)
                startActivity(intent)
                finish()
            }


        }

        bindingClass.ButtonSignUp.setOnClickListener {
            var intent = Intent(this@SignIn, RegistrationNewUser::class.java)
            startActivity(intent)
            finish()
        }
    }
}