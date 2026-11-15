package com.example.politica29n.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface Keys : NavKey {
    @Serializable data object Lista : Keys
    @Serializable data object Crear : Keys
    @Serializable data class Detalle(val id: Int) : Keys
}
