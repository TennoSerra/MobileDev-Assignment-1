package com.example.mobiledevassignment1.ui.grading

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mobiledevassignment1.R
import com.example.mobiledevassignment1.databinding.FragmentGradingBinding

class GradingFragment : Fragment() {

    private var _binding: FragmentGradingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGradingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val gradeNumber: EditText = binding.num
        val btnCalculate: Button = binding.calculateGrade
        val gradeOutput: TextView = binding.result

        btnCalculate.setOnClickListener {
            val number = gradeNumber.text.toString().toIntOrNull()
            if (number != null) {
                val gradeLetter = getGradeLetter(number)
                gradeOutput.text = "Grade: $gradeLetter"
            } else {
                gradeOutput.text = "Please enter a valid number"
            }
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
}
