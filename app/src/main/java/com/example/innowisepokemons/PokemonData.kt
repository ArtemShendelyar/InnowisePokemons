package com.example.innowisepokemons

object PokemonData {
        private val pokemons: Map<Int, Pokemon> = listOf(
            Pokemon(
                id = 1,
                name = "Вапореошка",
                weight = 29.0,
                height = 1.0,
                elementalType = listOf("Водяной"),
                picture = R.drawable.vaporeon
            ),
            Pokemon(
                id = 2,
                name = "Пикачидло",
                weight = 6.0,
                height = 0.4,
                elementalType = listOf("Электрический"),
                picture = R.drawable.pikachu
            )
        ).associateBy { it.id }
        fun getPokemonById(id: Int): Pokemon? {
            return pokemons[id]
        }
}