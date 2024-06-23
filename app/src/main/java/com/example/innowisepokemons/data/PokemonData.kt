package com.example.innowisepokemons.data

import com.example.innowisepokemons.R

object PokemonData {
    private val pokemons: HashMap<Int, Pokemon> = hashMapOf(
            1 to Pokemon(
                id = 1,
                name = "Вапореошка",
                weight = 29.0,
                height = 1.0,
                elementalType = listOf("Водяной"),
                picture = R.drawable.vaporeon
            ),
            2 to Pokemon(
                id = 2,
                name = "Пикачидло",
                weight = 6.0,
                height = 0.4,
                elementalType = listOf("Электрический"),
                picture = R.drawable.pikachu
            )
        )
        fun getPokemonById(id: Int): Pokemon? {
            return pokemons[id]
        }
}