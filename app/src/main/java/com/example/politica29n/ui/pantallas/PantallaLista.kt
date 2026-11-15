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
import com.example.politica29n.ui.componentes.*

@Composable
fun PantallaLista(registros: List<Participacion>, onCrear: () -> Unit,
                  onDetalle: (Int) -> Unit, onBorrar: (List<Int>) -> Unit) {
    var filtro by remember { mutableStateOf("") }
    var borrando by remember { mutableStateOf(false) }
    var confirmar by remember { mutableStateOf(false) }
    val seleccionados = remember { mutableStateListOf<Int>() }
    val visibles = registros.filter { filtro.isBlank() || it.partido.startsWith(filtro, true) }
    BackHandler(enabled = borrando) { borrando = false; seleccionados.clear() }

    Scaffold(topBar = { BarraSuperior("29N / Fantasy") }, bottomBar = {
        Surface(shadowElevation = 6.dp) {
            Row(Modifier.fillMaxWidth().navigationBarsPadding().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween) {
                // ExtendedFloatingActionButton no tiene enabled: desactivamos su acción y su color.
                ExtendedFloatingActionButton(onClick = { if (!borrando) onCrear() },
                    modifier = Modifier.semantics { if (borrando) disabled() },
                    containerColor = if (borrando) MaterialTheme.colorScheme.surfaceVariant else MaterialTheme.colorScheme.primaryContainer,
                    contentColor = if (borrando) MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f) else MaterialTheme.colorScheme.onPrimaryContainer,
                    icon = { Icon(Icons.Default.Add, null) }, text = { Text("Añadir") })
                ExtendedFloatingActionButton(onClick = {
                    if (borrando) confirmar = true else borrando = true
                }, icon = { Icon(Icons.Default.Delete, null) },
                    text = { Text(if (borrando) "Borrar (${seleccionados.size})" else "Borrar") })
            }
        }
    }) { padding ->
        Column(Modifier.padding(padding).padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text("CAMPAÑA ELECTORAL · 29 NOVIEMBRE", style = MaterialTheme.typography.labelLarge)
            Text("Debates y puntuaciones ficticios", style = MaterialTheme.typography.bodySmall)
            BuscadorPartidos { nuevo ->
                if (filtro != nuevo) seleccionados.clear()
                filtro = nuevo
            }
            if (borrando) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Selecciona intervenciones", Modifier.weight(1f).padding(top = 12.dp))
                    TextButton(onClick = { borrando = false; seleccionados.clear() }) { Text("Cancelar") }
                }
            } else Text("${visibles.size} intervenciones", style = MaterialTheme.typography.labelLarge)
            LazyColumn(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(10.dp),
                contentPadding = PaddingValues(bottom = 16.dp)) {
                if (visibles.isEmpty()) item {
                    Text(if (registros.isEmpty()) "Todavía no hay intervenciones. Pulsa Añadir para empezar."
                    else "No hay intervenciones para este partido. Prueba otro o limpia la búsqueda.", Modifier.padding(16.dp))
                }
                items(visibles, key = { it.id }) { registro ->
                    TarjetaParticipacion(registro, borrando, registro.id in seleccionados,
                        onPulsar = { onDetalle(registro.id) }, onSeleccionar = {
                            if (registro.id in seleccionados) seleccionados.remove(registro.id)
                            else seleccionados.add(registro.id)
                        })
                }
            }
        }
    }
    if (confirmar) AlertDialog(onDismissRequest = { confirmar = false },
        title = { Text("Borrar intervenciones") },
        text = { Text(if (seleccionados.isEmpty()) "No has seleccionado ninguna intervención."
            else "Se eliminarán ${seleccionados.size} intervenciones. ¿Quieres continuar?") },
        confirmButton = { TextButton(onClick = {
            onBorrar(seleccionados.toList())
            seleccionados.clear(); borrando = false; confirmar = false
        }) { Text("OK") } },
        dismissButton = { TextButton(onClick = { confirmar = false }) { Text("Cancelar") } })
}
