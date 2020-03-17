package com.example.hellomobile

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.hellomobile.R.*
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class DisplayMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // this is where we'd want to make a call to some other library...whatever Xamarin gives us maybe
        var answer = "";
        if (Build.VERSION.SDK_INT >= 29) {
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("MMM dd yyyy HH:mm:ss")
            answer =  current.format(formatter)
        } else {
            var date = Date();
            val formatter = SimpleDateFormat("MMM dd yyyy HH:mma")
            answer = formatter.format(date)
        }
        val finalMessage = "Hello $message! it is now $answer"

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = finalMessage
        }

    }
}
