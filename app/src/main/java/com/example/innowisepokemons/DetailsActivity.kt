package com.example.innowisepokemons

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.example.innowisepokemons.databinding.ActivityPokemonDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1
        if (pokemonId != -1) {
            val pokemon = PokemonData.getPokemonById(pokemonId)
            if (pokemon != null) {
                binding.apply {
                    pokemonImage.setImageResource(pokemon.picture)
                    pokemonName.text = pokemon.name
                    pokemonWeight.text = pokemon.weight.toString()
                    pokemonHeight.text = pokemon.height.toString()
                    pokemonTypes.text = pokemon.elementalType.toString()
                    backBtn.setOnClickListener { finish() }
                }
            } else {
                showErrorAndFinish("Такого покемона не существует :с")
            }
        } else {
            showErrorAndFinish("Такого ID нет!")
        }
    }

    private fun showErrorAndFinish(errorMessage: String) {
        Toast.makeText(this, "Упс. Что-то сломалось.", Toast.LENGTH_SHORT).show()
        finish()
    }
}