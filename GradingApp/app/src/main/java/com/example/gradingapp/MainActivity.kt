package com.example.gradingapp

import android.health.connect.ReadRecordsRequest
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val gradeNumber: EditText = findViewById(R.id.num1)
            val btnCalculate: Button = findViewById(R.id.calculateGrade)
            val gradeOutput: TextView = findViewById(R.id.result)
            btnCalculate.setOnClickListener {
                val number = gradeNumber.text.toString().toIntOrNull()
                if (number != null) {
                    val gradeLetter = getGradeLetter(number)
                    gradeOutput.text = "Grade:"+ gradeLetter
                } else {
                    gradeOutput.text = "Please enter a valid number"
                }
            }
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
private fun getGradeLetter(num: Int): String {
    return when {
        num >= 85 -> "A"
        num >= 75 -> "B"
        num >= 65 -> "C"
        num >= 50 -> "D"
        else -> "F"
    }
}