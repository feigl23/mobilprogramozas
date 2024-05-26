package com.example.felezo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.felezo.databinding.FragmentSecondBinding
import kotlin.math.ceil

class SecondFragment : Fragment() {
    private var num = 0
    private var target: Double = 50.0
    private var step: Int = 50
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        start()
        binding.buttonSecond.setOnClickListener {
            start()
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

        binding.smaller.setOnClickListener() {
            step = ceil(step.toDouble() / 2).toInt()
            target -= step
            showQuestion()
            if (step == 1) {
                showAnswer()
            }
        }

        binding.bigger.setOnClickListener() {
            step = ceil(step.toDouble() / 2).toInt()
            target += step
            showQuestion()
            if (step == 1) {
                showAnswer()
            }
        }

        binding.equal.setOnClickListener() {
            showAnswer()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun start() {
        num = (1..100).random()
        target = 50.0
        step = 50
        showQuestion()
    }

    private fun showQuestion() {
        binding.questiontxt.text = "A szám kisebb mint " + target.toInt().toString()
    }

    private fun showAnswer() {
        binding.questiontxt.text = "A szám: " + target.toInt().toString()
    }
}