package com.example.myapplication


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val intents = Intent("com.myapp.broadcasts.NEW_NOTIFICATION")
        intents.putExtra("message", "App Started!")
        Log.d("MainActivity", "Broadcast Sent: App Started!")
        sendBroadcast(intents)
        val signUpButton: Button = findViewById(R.id.button_sign_in) // Button ID from XML
        signUpButton.setOnClickListener {
            val email = findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString()
            val password = findViewById<EditText>(R.id.editTextTextPassword).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.editTextTextPassword2).text.toString()

            if(email.isEmpty()){
                Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show()
            }
            if (password == confirmPassword) {
                Toast.makeText(this, "Passwords Match", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            }

            if(email.isNotEmpty() && password==confirmPassword){
            // Intent to navigate to the LoginActivity
            Toast.makeText(this, "Navigating to Login Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            }
        }

        val haveAccount: TextView = findViewById(R.id.already_have_account_text) // Button ID from XML
        haveAccount.setOnClickListener {
            // Intent to navigate to the LoginActivity
            Toast.makeText(this, "Navigating to Login Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}