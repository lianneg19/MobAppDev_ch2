package com.example.lgabriel_challenge2

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var editText:EditText
    private var textValue:String = ""
    private var reversedText:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById<EditText>(R.id.et_input)
        val btn_palindrome = findViewById<Button>(R.id.btn_palindrome)
        val btn_pangram = findViewById<Button>(R.id.btn_pangram)

        btn_palindrome.setOnClickListener {
            textValue = editText.text.toString()
            reversedText = textValue.reversed()

            if(textValue == reversedText){
                intent = Intent(this, PalindromeActivity1::class.java)
                intent
                startActivity(intent)
            }
            else{
                intent = Intent(this, PalindromeActivity2::class.java)
                startActivity(intent)
            }
        }

        btn_pangram.setOnClickListener {
            intent = Intent(this, PangramActivity1::class.java)
            startActivity(intent)
        }
    }
}