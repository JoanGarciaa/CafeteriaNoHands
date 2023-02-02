package com.example.cafeteria_nohands.src

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.src.viewmodel.UsuariViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var nombre: String
    lateinit var email : String
    lateinit var user: String
    lateinit var password: String
    lateinit var usuariViewModel: UsuariViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        var buttonRegister: Button = findViewById(R.id.buttonRegistrarte)
        var buttonLogin: Button = findViewById(R.id.buttonIniciarSession)

        usuariViewModel = ViewModelProvider(this).get(UsuariViewModel::class.java)

        val intentLogin = Intent(this, LoginActivity::class.java)

        buttonLogin.setOnClickListener() {
            startActivity(intentLogin)
        }

        buttonRegister.setOnClickListener() {
            nombre = findViewById<EditText>(R.id.editTextTextPersonName2).text.toString()
            email = findViewById<EditText>(R.id.editTextTextPersonName3).text.toString()
            user = findViewById<EditText>(R.id.editTextRegisterUser).text.toString()
            password = findViewById<EditText>(R.id.editTextRegisterPassword).text.toString()
            intentLogin.putExtra("username", user.toString())
            intentLogin.putExtra("password", password.toString())
            if(nombre.isEmpty()||email.isEmpty()||user.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Necesitas rellenar todos los campos", Toast.LENGTH_SHORT).show()

            }else{
                usuariViewModel.newUser(this,nombre,email, user,password)
                Toast.makeText(this, "Usuario creado correctamente", Toast.LENGTH_SHORT).show()
                startActivity(intentLogin)
            }

        }


    }


}