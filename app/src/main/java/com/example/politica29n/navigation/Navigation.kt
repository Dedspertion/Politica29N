package com.example.politica29n.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.politica29n.model.Participacion
import com.example.politica29n.data.CampanaData
import com.example.politica29n.ui.pantallas.*

@Composable
fun Navegacion() {
    val pila = rememberNavBackStack(Keys.Lista)
    // State hoisting: las pantallas reciben los datos y avisan mediante lambdas.
    val participaciones = remember {
        mutableStateListOf<Participacion>().apply { addAll(CampanaData.participaciones) }
    }
    NavDisplay(
        backStack = pila,
        onBack = { if (pila.size > 1) pila.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Keys.Lista> {
                PantallaLista(participaciones,
                    onCrear = { pila.add(Keys.Crear) },
                    onDetalle = { pila.add(Keys.Detalle(it)) },
                    onBorrar = { ids -> participaciones.removeAll { it.id in ids } })
            }
            entry<Keys.Crear> {
                PantallaCrear(
                    onGuardar = { nueva ->
                        val id = (participaciones.maxOfOrNull { it.id } ?: 0) + 1
                        participaciones.add(nueva.copy(id = id))
                        pila.removeLastOrNull()
                    },
                    onCancelar = { pila.removeLastOrNull() })
            }
            entry<Keys.Detalle> { destino ->
                PantallaDetalle(participaciones.firstOrNull { it.id == destino.id },
                    participaciones, onVolver = { pila.removeLastOrNull() })
            }
        }
    )
}
