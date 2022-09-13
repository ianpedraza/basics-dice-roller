package com.ianpedraza.diceroller.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.ianpedraza.diceroller.databinding.ActivityMainBinding
import com.ianpedraza.diceroller.utils.viewBinding

class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        subscribeObservers()
        setupUI()
    }

    private fun setupUI() {
        binding.rollButton.setOnClickListener { viewModel.rollDice() }
    }

    private fun subscribeObservers() {
        viewModel.diceImageResource.observe(this) { event ->
            event.getContentIfNotHandled()?.let { resource ->
                binding.diceImage.setImageResource(resource)
            }
        }
    }
}