package com.woojun.yumyumschool

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.card.MaterialCardView
import com.woojun.yumyumschool.databinding.FragmentHomeBinding
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val weekdays = getWeekdays()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            val weekText = arrayOf(mondayText, tuesdayText, wednesdayText, thursdayText, fridayText)
            weekText.forEachIndexed { index, textView ->
                textView.text = "${weekdays[index]}"
            }

            mondayButton.setOnClickListener {
                resetButtonColors()
                highlightButton(it)
            }

            tuesdayButton.setOnClickListener {
                resetButtonColors()
                highlightButton(it)
            }

            wednesdayButton.setOnClickListener {
                resetButtonColors()
                highlightButton(it)
            }

            thursdayButton.setOnClickListener {
                resetButtonColors()
                highlightButton(it)
            }

            fridayButton.setOnClickListener {
                resetButtonColors()
                highlightButton(it)
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getWeekdays(): List<String> {
        val today = LocalDate.now()
        val monday = today.with(DayOfWeek.MONDAY)
        val formatter = DateTimeFormatter.ofPattern("MM월 dd일")

        return (0..4).map { monday.plusDays(it.toLong()).format(formatter) }
    }

    private fun resetButtonColors() {
        binding.apply {
            val gray = ContextCompat.getColor(requireContext(), R.color.gray)
            mondayButton.strokeColor = gray
            tuesdayButton.strokeColor = gray
            wednesdayButton.strokeColor = gray
            thursdayButton.strokeColor = gray
            fridayButton.strokeColor = gray
        }
    }

    private fun highlightButton(button: View) {
        button as MaterialCardView
        val primaryColor = ContextCompat.getColor(requireContext(), R.color.primary_color)
        button.strokeColor = primaryColor
    }


}