package com.example.innowisepokemons.data

import androidx.annotation.DrawableRes

data class Pokemon (
    val id: Int,
    val name: String,
    val weight: Double,
    val height: Double,
    val elementalType: List<String>,
    @DrawableRes
    val picture: Int
)