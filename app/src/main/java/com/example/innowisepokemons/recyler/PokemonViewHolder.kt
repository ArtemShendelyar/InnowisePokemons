package com.example.innowisepokemons.recyler

import androidx.recyclerview.widget.RecyclerView
import com.example.innowisepokemons.data.Pokemon
import com.example.innowisepokemons.databinding.PokemonListItemBinding

class PokemonViewHolder(
    private val binding: PokemonListItemBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        binding.pokemonName.text = model.name
        binding.root.setOnClickListener { onClick(model) }
    }
}