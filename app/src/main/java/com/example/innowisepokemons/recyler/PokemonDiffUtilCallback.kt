package com.example.innowisepokemons.recyler
import androidx.recyclerview.widget.DiffUtil
import com.example.innowisepokemons.data.Pokemon

class PokemonDiffUtilCallback(
    private val items: List<Pokemon>,
    private val newItems: List<Pokemon>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = items.size

    override fun getNewListSize(): Int = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        items[oldItemPosition].name == newItems[newItemPosition].name

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        items[oldItemPosition] == newItems[newItemPosition]
}
