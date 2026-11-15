package com.example.politica29n.ui.componentes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.text.input.setTextAndPlaceCursorAtEnd
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.politica29n.data.CampanaData
import com.example.politica29n.model.Partido
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuscadorPartidos(onFiltrar: (String) -> Unit) {
    val estadoBarra = rememberSearchBarState()
    val estadoTexto = rememberTextFieldState()
    val scope = rememberCoroutineScope()
    val texto = estadoTexto.text.toString()

    // Al escribir, avisamos a la pantalla de lista para actualizar el filtro.
    LaunchedEffect(texto) {
        onFiltrar(texto.trim())
    }

    val opciones = mutableListOf<Partido>()
    for (partido in CampanaData.partidos) {
        if (partido.nombre.startsWith(texto.trim(), ignoreCase = true)) {
            opciones.add(partido)
        }
    }

    SearchBar(
        state = estadoBarra,
        modifier = Modifier.fillMaxWidth(),
        inputField = {
            SearchBarDefaults.InputField(
                textFieldState = estadoTexto,
                searchBarState = estadoBarra,
                onSearch = {
                    scope.launch {
                        estadoBarra.animateToCollapsed()
                    }
                },
                placeholder = { Text("Buscar partido político") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (texto.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                estadoTexto.setTextAndPlaceCursorAtEnd("")
                                onFiltrar("")
                            }
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Mostrar todos")
                        }
                    }
                }
            )
        }
    )

    // Como en el ejercicio de clase, esta barra muestra la búsqueda expandida.
    ExpandedFullScreenSearchBar(
        state = estadoBarra,
        inputField = {
            SearchBarDefaults.InputField(
                textFieldState = estadoTexto,
                searchBarState = estadoBarra,
                onSearch = {
                    scope.launch {
                        estadoBarra.animateToCollapsed()
                    }
                },
                placeholder = { Text("Buscar partido político") },
                leadingIcon = {
                    Icon(Icons.Default.Search, contentDescription = null)
                },
                trailingIcon = {
                    if (texto.isNotEmpty()) {
                        IconButton(
                            onClick = {
                                estadoTexto.setTextAndPlaceCursorAtEnd("")
                                onFiltrar("")
                            }
                        ) {
                            Icon(Icons.Default.Close, contentDescription = "Mostrar todos")
                        }
                    }
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)
        ) {
            if (opciones.isEmpty()) {
                item {
                    Text(
                        text = "No hay partidos con ese nombre.",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
            items(opciones) { partido ->
                ListItem(
                    headlineContent = { Text(partido.nombre) },
                    modifier = Modifier.clickable {
                        estadoTexto.setTextAndPlaceCursorAtEnd(partido.nombre)
                        onFiltrar(partido.nombre)
                        scope.launch {
                            estadoBarra.animateToCollapsed()
                        }
                    }
                )
            }
        }
    }
}
