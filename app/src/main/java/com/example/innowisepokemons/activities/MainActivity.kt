package com.example.innowisepokemons.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.innowisepokemons.data.PokemonData
import com.example.innowisepokemons.databinding.ActivityMainBinding
import com.example.innowisepokemons.recyler.PokemonAdapter

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

        val adapter = PokemonAdapter()
        adapter.onClick = { pokemon ->
            val intent = Intent(this@MainActivity, DetailsActivity::class.java).apply {
                putExtra("pokemon_id", pokemon.id)
            }
            startActivity(intent)
        }
        binding.pokemonList.adapter = adapter
        adapter.submit(PokemonData.getLisOfPokemons())
    }
}
