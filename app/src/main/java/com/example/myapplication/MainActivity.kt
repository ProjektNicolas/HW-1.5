package com.example.compose

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationhw12.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_EMAIL_DATA = "emailData"
        const val MAX_MESSAGE_LENGTH = 250
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendButton.setOnClickListener {
            sendEmail()
        }
    }

    private fun sendEmail() {
        val email = binding.emailInput.text.toString()
        val recipientEmail = binding.recipientInput.text.toString()
        val message = binding.messageInput.text.toString()

        if (Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
            Patterns.EMAIL_ADDRESS.matcher(recipientEmail).matches() &&
            message.length <= MAX_MESSAGE_LENGTH
        ) {
            val emailData = EmailData(recipientEmail, message)
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("EXTRA_EMAIL", emailData.recipientEmail)
            }
            intent.putExtras("EXTRA_DATA",emailData.message)
            startActivity(intent)
        } else {
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.emailInput.error = "Invalid email format"
            }
        }
    }
}

private fun Any.putExtras(s: String, message: String) {
    TODO("Not yet implemented")
}

data class EmailData(val recipientEmail: String, val message: String)