package com.example.compose

import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.semantics.text
import com.example.myapplicationhw12.R
import com.example.myapplicationhw12.databinding.ActivitySecondBinding

private var Any.text: String
    get() {
        TODO("Not yet implemented")
    }
    set(value) = Unit
private val Any.recipientEmailTextView: Any
    get() {
        TODO("Not yet implemented")
    }

class SecondActivity : androidx.appcompat.app.AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.getStringExtra("recipientEmail")?.let { recipientEmail ->
            binding.recipientEmailTextView.text = recipientEmail
        }
        intent.getStringExtra("message")?.let { message ->
            binding.messageText.text = message
        }

        binding.clearButton.setOnClickListener {
            clearFields()
        }
    }

    private fun clearFields() {
        binding.recipientEmailTextView.text = ""
        binding.messageText.text = ""
        Toast.makeText(this, getString(R.string.cleared_successfully), Toast.LENGTH_SHORT).show()
    }
}