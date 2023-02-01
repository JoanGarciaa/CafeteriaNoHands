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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.room.Index.Order
import com.example.cafeteria_nohands.MainActivity
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.src.model.OrderViewModel


class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var usuariViewModel: OrderViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usuariViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)


        var buttonLogin: Button = findViewById(R.id.buttonLogin)
        var buttonRegister: Button = findViewById(R.id.buttonRegister)

        var datos = intent.extras

        var user = datos?.getString("username")
        var password = datos?.getString("password")

        var mostrarUser: EditText = findViewById(R.id.editTextTextPersonName);
        var mostrarPassword: EditText = findViewById(R.id.editTextTextPassword)

        mostrarUser.setText(user)
        mostrarPassword.setText(password)

        lateinit var nombreLogin : String
        lateinit var passwordLogin : String

        buttonLogin.setOnClickListener(){
            nombreLogin = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            passwordLogin = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            usuariViewModel.loginClient(this,nombreLogin,passwordLogin)!!.observe(this, Observer {llistaClients ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            })
        }

//        buttonLogin.setOnClickListener() {
//            if (mostrarUser.text.contains(user.toString()) && mostrarPassword.text.contains(password.toString())) {
//
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
//
//            } else {
//                Toast.makeText(this, "Usuario y contraseña invalido", Toast.LENGTH_SHORT).show()
//            }
//        }


        buttonRegister.setOnClickListener() {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }


    }

}