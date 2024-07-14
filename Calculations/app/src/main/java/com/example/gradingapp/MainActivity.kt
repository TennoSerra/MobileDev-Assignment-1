package com.example.gradingapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
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
            val num1: EditText = findViewById(R.id.num1)
            val num2: EditText = findViewById(R.id.num2)
            val btnCalculate: Button = findViewById(R.id.calculateGrade)
            val result: TextView = findViewById(R.id.result)
            var flag: String ="Sum"
            val spinnerVal: Spinner = findViewById(R.id.spinnerV)
            var options = arrayOf("sum","multiply")
            spinnerVal.adapter =
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,options)
            spinnerVal.onItemSelectedListener=object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    flag = options.get(p2)
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }
            btnCalculate.setOnClickListener {
                val x = num1.text.toString().toInt()
                val y = num2.text.toString().toInt()
                if (flag =="sum") {
                    result.text=sum(x,y).toString();
                } else {
                    result.text=multiply(x,y).toString();
                }
            }
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

private fun sum(a: Int, b: Int): Int{
    return a+b
}

private fun multiply(a: Int, b: Int): Int{
    return a*b
}