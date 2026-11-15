package com.example.politica29n.model

// Cada elemento representa una intervención, no una persona nueva.
data class Participacion(
    val id: Int,
    val politicoId: String,
    val partido: String,
    val temas: List<String>,
    val puntos: Int,
    val rival: String,
    val fecha: Long
)

data class Politico(
    val id: String,
    val nombre: String,
    val partido: String,
    val foto: Int,
    val biografia: String,
    val fuente: String
)

data class Partido(val nombre: String, val color: Long)
