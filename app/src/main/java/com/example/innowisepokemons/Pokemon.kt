package com.example.innowisepokemons
data class Pokemon (
    val id: Int,
    val name: String,
    val weight: Double,
    val height: Double,
    val elementalType: List<String>,
    val picture: Int
)