package com.example.innowisepokemons

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.view.updateLayoutParams
import com.example.innowisepokemons.databinding.ActivityPokemonDetailsBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPokemonDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.extras?.getInt("pokemon_id", -1) ?: -1
        with(binding) {
            if (pokemonId == -1) {
                Toast.makeText(this@DetailsActivity, "Плохой ID покемона.", Toast.LENGTH_SHORT).show()
                finish()
                return@with
            }
            PokemonData.getPokemonById(pokemonId)?.let { pokemon ->
                pokemonImage.setImageResource(pokemon.picture)
                pokemonName.text = pokemon.name
                pokemonWeight.text = "Вес: " + pokemon.weight.toString()
                pokemonHeight.text = "Рост: " + pokemon.height.toString()
                pokemonTypes.text = "Типы: " + pokemon.elementalType.toString()
                backBtn.setOnClickListener { finish() }
            } ?: showErrorAndFinish("Такого покемона нет. Увы.")
        }
    }

    private fun showErrorAndFinish(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        finish()
    }
    fun resizePokemon(view: View) {
        // Я мог бы использовать тут биндинг. Но тогда мне легче было бы задать обработчик
        // через анонимную функцию в методе DetailsActivity onCreate.
        // Но пока я захотел протестировать код на различные варианты реализации.
        if (view.layoutParams.height + view.layoutParams.width > 1600){
            view.updateLayoutParams {
                this.height = 0
                this.width = 0
            }
        }else{
            view.updateLayoutParams {
                this.height += 200
                this.width += 200
            }

        }
    }
}