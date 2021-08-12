package com.example.broadcastmessages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.R
import android.os.Build
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {

    companion object {
        // Имя ACTION для Broadcast, по нему Receiver и будет определяться
        const val ACTION_SEND_MSG: String = "broadcastsender.message"

        // Имя передаваемого параметра
        const val NAME_MSG: String = "MSG"

        // Эта константа спрятана в Intent классе,
        // Но, именно посредством её можно поднять приложение
        const val FLAG_RECEIVER_INCLUDE_BACKGROUND: Int = 0x01000000
    }

    lateinit var binding: MainActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonSend();

    }

    private fun initButtonSend() {
       

    }
}