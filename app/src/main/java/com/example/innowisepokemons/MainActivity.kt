package com.example.innowisepokemons

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innowisepokemons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:  ActivityMainBinding
    private fun startPokemonDetailActivity(pokemonId: Int) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("pokemon_id", pokemonId)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Да простит меня дух святого кода за такую реализацию.
        binding.pokemon1.setOnClickListener {
            startPokemonDetailActivity(1)
        }
        binding.pokemon2.setOnClickListener {
            startPokemonDetailActivity(2)
        }
        binding.pokemon3.setOnClickListener {
            startPokemonDetailActivity(3)
        }
    }
}
