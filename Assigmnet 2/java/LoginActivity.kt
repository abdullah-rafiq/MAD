package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.log_in)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val createaccounttextview: TextView =findViewById(R.id.create_account_log_in_to_sign_in)
            createaccounttextview.setOnClickListener {
                // Intent to navigate to the LoginActivity
                Toast.makeText(this, "Navigating to Sign up Screen", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }


        val intent = Intent()
        intent.setAction("com.myapp.broadcasts.NEW_NOTIFICATION")
        sendBroadcast(intent)

}
}
