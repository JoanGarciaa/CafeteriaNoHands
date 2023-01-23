package com.example.cafeteria_nohands.src

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.cafeteria_nohands.MainActivity
import com.example.cafeteria_nohands.R


class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        var buttonLogin: Button = findViewById(R.id.buttonLogin)
        var buttonRegister: Button = findViewById(R.id.buttonRegister)

        var datos = intent.extras

        var user = datos?.getString("username")
        var password = datos?.getString("password")

        var mostrarUser: EditText = findViewById(R.id.editTextTextPersonName);
        var mostrarPassword: EditText = findViewById(R.id.editTextTextPassword)

        mostrarUser.setText(user)
        mostrarPassword.setText(password)

        buttonLogin.setOnClickListener() {
            if (mostrarUser.text.contains(user.toString()) && mostrarPassword.text.contains(password.toString())) {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Usuario y contraseña invalido", Toast.LENGTH_SHORT).show()
            }
        }


        buttonRegister.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

}