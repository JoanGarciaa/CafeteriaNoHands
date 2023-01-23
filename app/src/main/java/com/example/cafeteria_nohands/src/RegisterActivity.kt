package com.example.cafeteria_nohands.src

import android.annotation.SuppressLint
import android.content.ClipData.Item
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.cafeteria_nohands.R

class RegisterActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var buttonRegister: Button = findViewById(R.id.buttonRegistrarte)
        var buttonLogin: Button = findViewById(R.id.buttonIniciarSession)

        var username: EditText = findViewById(R.id.editTextRegisterUser)
        var password: EditText = findViewById(R.id.editTextRegisterPassword)

        val intentLogin = Intent(this, LoginActivity::class.java)

        buttonLogin.setOnClickListener() {
            startActivity(intentLogin)
        }

        buttonRegister.setOnClickListener() {
            intentLogin.putExtra("username", username.text.toString())
            intentLogin.putExtra("password", password.text.toString())
            Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show()
            startActivity(intentLogin)
        }


    }


}