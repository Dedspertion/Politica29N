package com.example.politica29n.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

// Cada ruta representa una pantalla. Detalle recibe el id del debate.
sealed interface Keys : NavKey {
    @Serializable
    data object Lista : Keys

    @Serializable
    data object Crear : Keys

    @Serializable
    data class Detalle(val id: Int) : Keys
}
