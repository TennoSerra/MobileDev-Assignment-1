package com.example.mobiledevassignment1.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobiledevassignment1.R
import com.example.mobiledevassignment1.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val num1: EditText = binding.num1
        val num2: EditText = binding.num2
        val btnCalculate: Button = binding.calculateGrade
        val result: TextView = binding.result
        var flag = "Sum"
        val spinnerVal: Spinner = binding.spinnerV
        val options = arrayOf("sum", "multiply")

        spinnerVal.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, options).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerVal.adapter = adapter
            }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                flag = options[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        btnCalculate.setOnClickListener {
            val x = num1.text.toString().toIntOrNull()
            val y = num2.text.toString().toIntOrNull()

            if (x != null && y != null) {
                result.text = if (flag == "sum") {
                    sum(x, y).toString()
                } else {
                    multiply(x, y).toString()
                }
            } else {
                result.text = "Please enter valid numbers"
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun multiply(a: Int, b: Int): Int {
        return a * b
    }
}
