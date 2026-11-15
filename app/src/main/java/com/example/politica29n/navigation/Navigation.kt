package com.example.politica29n.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.politica29n.model.Participacion
import com.example.politica29n.data.CampanaData
import com.example.politica29n.ui.pantallas.PantallaCrear
import com.example.politica29n.ui.pantallas.PantallaDetalle
import com.example.politica29n.ui.pantallas.PantallaLista

@Composable
fun Navegacion() {
    val pila = rememberNavBackStack(Keys.Lista)

    // La lista está aquí para que las tres pantallas compartan los cambios.
    val participaciones = remember {
        val lista = mutableStateListOf<Participacion>()
        lista.addAll(CampanaData.participaciones)
        lista
    }

    fun volver() {
        if (pila.size > 1) {
            pila.removeLastOrNull()
        }
    }

    NavDisplay(
        backStack = pila,
        onBack = { volver() },
        entryProvider = entryProvider {
            entry<Keys.Lista> {
                PantallaLista(
                    registros = participaciones,
                    onCrear = {
                        pila.add(Keys.Crear)
                    },
                    onDetalle = { id ->
                        pila.add(Keys.Detalle(id))
                    },
                    onBorrar = { ids ->
                        // Recorremos una copia para poder borrar de la lista original.
                        val copia = participaciones.toList()
                        for (participacion in copia) {
                            if (ids.contains(participacion.id)) {
                                participaciones.remove(participacion)
                            }
                        }
                    }
                )
            }

            entry<Keys.Crear> {
                PantallaCrear(
                    onGuardar = { nueva ->
                        var idMayor = 0
                        for (participacion in participaciones) {
                            if (participacion.id > idMayor) {
                                idMayor = participacion.id
                            }
                        }

                        val participacionConId = nueva.copy(id = idMayor + 1)
                        participaciones.add(participacionConId)
                        volver()
                    },
                    onCancelar = {
                        volver()
                    }
                )
            }

            entry<Keys.Detalle> { destino ->
                var registroElegido: Participacion? = null
                for (participacion in participaciones) {
                    if (participacion.id == destino.id) {
                        registroElegido = participacion
                        break
                    }
                }

                PantallaDetalle(
                    registro = registroElegido,
                    registros = participaciones,
                    onVolver = {
                        volver()
                    }
                )
            }
        }
    )
}
