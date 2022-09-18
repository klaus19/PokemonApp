package com.example.pokemonapp

import PokemonViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonapp.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private val viewModel:PokemonViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val v = binding.root
        setContentView(v)

        lifecycleScope.launchWhenCreated {
              viewModel.stateFlow.collectLatest { data ->
                  binding.txt1.text = data
              }

        }

        lifecycleScope.launchWhenCreated {
            viewModel.sharedFlow.collectLatest { data->

                binding.txtSharedFlow.text=data
            }
        }

    }
}