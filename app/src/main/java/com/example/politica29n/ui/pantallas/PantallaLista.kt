package com.example.politica29n.ui.pantallas

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.semantics.disabled
import androidx.compose.ui.semantics.semantics
import com.example.politica29n.model.Participacion
import com.example.politica29n.ui.componentes.BarraSuperior
import com.example.politica29n.ui.componentes.BuscadorPartidos
import com.example.politica29n.ui.componentes.TarjetaParticipacion

@Composable
fun PantallaLista(
    registros: List<Participacion>,
    onCrear: () -> Unit,
    onDetalle: (Int) -> Unit,
    onBorrar: (List<Int>) -> Unit
) {
    var filtro by remember { mutableStateOf("") }
    var modoBorrado by remember { mutableStateOf(false) }
    var mostrarConfirmacion by remember { mutableStateOf(false) }
    val seleccionados = remember { mutableStateListOf<Int>() }

    val registrosVisibles = mutableListOf<Participacion>()
    for (registro in registros) {
        if (filtro.isBlank() || registro.partido.startsWith(filtro, ignoreCase = true)) {
            registrosVisibles.add(registro)
        }
    }

    fun cancelarBorrado() {
        modoBorrado = false
        seleccionados.clear()
    }

    BackHandler(enabled = modoBorrado) {
        cancelarBorrado()
    }

    // El botón flotante no tiene enabled. Cambiamos sus colores y bloqueamos su acción.
    var colorBoton = MaterialTheme.colorScheme.primaryContainer
    var colorTextoBoton = MaterialTheme.colorScheme.onPrimaryContainer
    if (modoBorrado) {
        colorBoton = MaterialTheme.colorScheme.surfaceVariant
        colorTextoBoton = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
    }

    Scaffold(
        topBar = {
            BarraSuperior(titulo = "29N / Fantasy", mostrarVolver = false)
        },
        bottomBar = {
            Surface(shadowElevation = 6.dp) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .navigationBarsPadding()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ExtendedFloatingActionButton(
                        onClick = {
                            if (!modoBorrado) {
                                onCrear()
                            }
                        },
                        modifier = Modifier.semantics {
                            if (modoBorrado) {
                                disabled()
                            }
                        },
                        containerColor = colorBoton,
                        contentColor = colorTextoBoton,
                        icon = { Icon(Icons.Default.Add, contentDescription = null) },
                        text = { Text("Añadir") }
                    )
                    ExtendedFloatingActionButton(
                        onClick = {
                            if (modoBorrado) {
                                mostrarConfirmacion = true
                            } else {
                                modoBorrado = true
                            }
                        },
                        icon = { Icon(Icons.Default.Delete, contentDescription = null) },
                        text = {
                            if (modoBorrado) {
                                Text("Borrar (${seleccionados.size})")
                            } else {
                                Text("Borrar")
                            }
                        }
                    )
                }
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = "CAMPAÑA ELECTORAL · 29 NOVIEMBRE",
                style = MaterialTheme.typography.labelLarge
            )
            Text(
                text = "Debates y puntuaciones ficticios",
                style = MaterialTheme.typography.bodySmall
            )
            BuscadorPartidos(
                onFiltrar = { nuevoFiltro ->
                    if (filtro != nuevoFiltro) {
                        seleccionados.clear()
                    }
                    filtro = nuevoFiltro
                }
            )
            if (modoBorrado) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Selecciona intervenciones",
                        modifier = Modifier.weight(1f).padding(top = 12.dp)
                    )
                    TextButton(onClick = { cancelarBorrado() }) {
                        Text("Cancelar")
                    }
                }
            } else {
                Text(
                    text = "${registrosVisibles.size} intervenciones",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 16.dp)
            ) {
                if (registrosVisibles.isEmpty()) {
                    item {
                        var mensaje = "No hay intervenciones para este partido. Prueba otro o limpia la búsqueda."
                        if (registros.isEmpty()) {
                            mensaje = "Todavía no hay intervenciones. Pulsa Añadir para empezar."
                        }
                        Text(mensaje, modifier = Modifier.padding(16.dp))
                    }
                }
                items(
                    items = registrosVisibles,
                    key = { registro -> registro.id }
                ) { registro ->
                    TarjetaParticipacion(
                        registro = registro,
                        modoBorrado = modoBorrado,
                        seleccionado = seleccionados.contains(registro.id),
                        onPulsar = {
                            onDetalle(registro.id)
                        },
                        onSeleccionar = {
                            if (seleccionados.contains(registro.id)) {
                                seleccionados.remove(registro.id)
                            } else {
                                seleccionados.add(registro.id)
                            }
                        }
                    )
                }
            }
        }
    }

    if (mostrarConfirmacion) {
        AlertDialog(
            onDismissRequest = { mostrarConfirmacion = false },
            title = { Text("Borrar intervenciones") },
            text = {
                if (seleccionados.isEmpty()) {
                    Text("No has seleccionado ninguna intervención.")
                } else {
                    Text("Se eliminarán ${seleccionados.size} intervenciones. ¿Quieres continuar?")
                }
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        onBorrar(seleccionados.toList())
                        cancelarBorrado()
                        mostrarConfirmacion = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrarConfirmacion = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
