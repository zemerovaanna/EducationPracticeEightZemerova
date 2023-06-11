package com.example.cinemaworld

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.cinemaworld.databinding.ActivityRegistrationNewUserBinding
import com.example.cinemaworld.databinding.ActivitySignInBinding
import kotlin.collections.Collection

class RegistrationNewUser : AppCompatActivity() {
    lateinit var bindingClass: ActivityRegistrationNewUserBinding

    lateinit var name: EditText
    lateinit var lastname:EditText
    lateinit var email: EditText
    lateinit var password:EditText
    lateinit var verificationpassword:EditText
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityRegistrationNewUserBinding.inflate((layoutInflater))
        setContentView(bindingClass.root)

        name = findViewById(R.id.EditTextName)
        lastname = findViewById(R.id.EditTextLastname)
        email = findViewById(R.id.EditTextEmail)
        password = findViewById(R.id.EditTextPassword)
        verificationpassword = findViewById(R.id.EditTextVerificatioPassword)

        bindingClass.ButtonRegistartion.setOnClickListener{
            val Name = name.text.toString()
            val Lastname = lastname.text.toString()
            val Email = email.text.toString()
            val Password = password.text.toString()
            val Verificationpassword = verificationpassword.text.toString()

            if(Name.isEmpty() || Lastname.isEmpty() || Email.isEmpty() || Password.isEmpty() || Verificationpassword.isEmpty())
            {
                Toast.makeText(this, R.string.emptyfields, Toast.LENGTH_SHORT).show()
            }
            else
            {
                if(Password.toString() == Verificationpassword.toString())
                {
                    val intent = Intent(this, com.example.cinemaworld.Collection::class.java)
                    startActivity(intent)
                }
                else
                {
                    Toast.makeText(this, R.string.mismatchpassword, Toast.LENGTH_SHORT).show()
                }
            }
        }

        bindingClass.ButtonHaveAccount.setOnClickListener {
            val intent = Intent(this@RegistrationNewUser, SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }
}