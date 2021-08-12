package com.example.broadcastmessages

import android.R
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.example.broadcastmessages.databinding.ActivityListItemBinding


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

    lateinit var binding: ActivityListItemBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_item)
        binding = ActivityListItemBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtonSend()

    }



    @SuppressLint("WrongConstant")
    private fun initButtonSend() {
        val message: Editable? = binding.textMessage.text
        binding.buttonSend.setOnClickListener {
            // Формируем интент
            val msg: String = message.toString()
            val intent = Intent()
            // Укажем ACTION, по которому будем ловить сообщение
            intent.action = ACTION_SEND_MSG
            // Добавим параметр.
            intent.putExtra(NAME_MSG, msg)
            // Указываем флаг поднятия приложения
            // (без него будут получать уведомления только
            // загруженные приложения)
            intent.addFlags(FLAG_RECEIVER_INCLUDE_BACKGROUND)
            // Отправка сообщения
            sendBroadcast(intent)

        }

    }
}