package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
        val signUpButton: Button = findViewById(R.id.button_sign_in) // Button ID from XML
        signUpButton.setOnClickListener {
            // Intent to navigate to the LoginActivity
            Toast.makeText(this, "Navigating to Login Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        val already_have_textview: TextView = findViewById(R.id.already_have_account_text) // Button ID from XML
        already_have_textview.setOnClickListener {
            // Intent to navigate to the LoginActivity
            Toast.makeText(this, "Navigating to Login Page", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        class MyBroadcastReceiver : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val sb = StringBuilder()
                sb.append("Action: ${intent.action}\n")
                val log = sb.toString()
                Toast.makeText(context, log, Toast.LENGTH_LONG).show()
            }
        }


    }
}
class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val log = "Action: " + intent.action
        Log.d(TAG, log)
        Toast.makeText(context, log, Toast.LENGTH_LONG).show()
    }

    companion object {
        private const val TAG = "MyBroadcastReceiver"
    }
}
