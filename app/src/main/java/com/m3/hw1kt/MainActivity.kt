package com.m3.hw1kt

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.m3.hw1kt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.sendBtn.setOnClickListener {
            val receiverMail = binding.emailEditText.text.toString()
            val emailSubject = binding.subjectEditText.text.toString()
            val emailBody = binding.messageEditText.text.toString()
            val intent = Intent(Intent.ACTION_SEND)

            intent.putExtra(Intent.EXTRA_EMAIL, receiverMail)
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject)
            intent.putExtra(Intent.EXTRA_TEXT, emailBody)

            intent.setType("message/rfc822")

            startActivity(Intent.createChooser(intent, "Choose an Email client :"))

        }

        binding.activity2Btn.setOnClickListener {
            val intent = Intent(this, ImageActivity::class.java)
            intent.putExtra("image", R.drawable.pudge_image)
            startActivity(intent)
        }
    }
}