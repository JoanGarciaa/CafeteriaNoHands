package com.example.cafeteria_nohands.src

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cafeteria_nohands.MainActivity
import com.example.cafeteria_nohands.R
import com.example.cafeteria_nohands.src.viewmodel.UsuariViewModel


class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var usuariViewModel: UsuariViewModel

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        usuariViewModel = ViewModelProvider(this).get(UsuariViewModel::class.java)


        var buttonLogin: Button = findViewById(R.id.buttonLogin)
        var buttonRegister: Button = findViewById(R.id.buttonRegister)

        var datos = intent.extras

        var user = datos?.getString("username")
        var password = datos?.getString("password")

        var mostrarUser: EditText = findViewById(R.id.editTextTextPersonName);
        var mostrarPassword: EditText = findViewById(R.id.editTextTextPassword)

        mostrarUser.setText(user)
        mostrarPassword.setText(password)


        buttonLogin.setOnClickListener(){
            var nombreLogin = findViewById<EditText>(R.id.editTextTextPersonName).text.toString()
            var passwordLogin = findViewById<EditText>(R.id.editTextTextPassword).text.toString()

            if(nombreLogin.isEmpty() || passwordLogin.isEmpty()){
                Toast.makeText(this,"Rellena los campos" , Toast.LENGTH_SHORT).show()
            }else{
                usuariViewModel.loginClient(this,nombreLogin,passwordLogin)!!.observe(this, Observer {llistaUser ->
                    Toast.makeText(this,"Bienvenido: ${llistaUser[0].user}" , Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                })
            }

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