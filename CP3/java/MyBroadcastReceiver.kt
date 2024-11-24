package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class MyBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val message = intent.getStringExtra("message")

        if (action == "com.myapp.broadcasts.NEW_NOTIFICATION") {
            Toast.makeText(context, "Broadcast Received: $message", Toast.LENGTH_SHORT).show()
            Log.d("MyBroadcastReceiver", "Received: $message")
        }
    }
}

