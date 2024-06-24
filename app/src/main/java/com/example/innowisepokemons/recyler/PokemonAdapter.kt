package com.example.innowisepokemons.recyler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.innowisepokemons.data.Pokemon
import com.example.innowisepokemons.databinding.PokemonListItemBinding

class PokemonAdapter : RecyclerView.Adapter<PokemonViewHolder>() {
    private var items = emptyList<Pokemon>()
    var onClick: (Pokemon) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun submit(newItems: List<Pokemon>) {
        val diffUtilCallback = PokemonDiffUtilCallback(items, newItems)
        items = newItems
        DiffUtil.calculateDiff(diffUtilCallback).dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}