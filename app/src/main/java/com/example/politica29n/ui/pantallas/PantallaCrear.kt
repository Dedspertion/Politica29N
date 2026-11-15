package com.example.politica29n.ui.pantallas

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.example.politica29n.data.CampanaData
import com.example.politica29n.data.mostrarFecha
import com.example.politica29n.model.Participacion
import com.example.politica29n.ui.componentes.BarraSuperior
import com.example.politica29n.ui.componentes.Desplegable
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCrear(
    onGuardar: (Participacion) -> Unit,
    onCancelar: () -> Unit
) {
    // rememberSaveable conserva el formulario al girar el móvil.
    var politicoId by rememberSaveable { mutableStateOf("") }
    var nombrePolitico by rememberSaveable { mutableStateOf("") }
    var partido by rememberSaveable { mutableStateOf("") }
    var rival by rememberSaveable { mutableStateOf("") }
    var temas by rememberSaveable { mutableStateOf(listOf<String>()) }
    var puntos by rememberSaveable { mutableFloatStateOf(0f) }
    var fecha by rememberSaveable { mutableStateOf<Long?>(null) }
    var mostrarCalendario by remember { mutableStateOf(false) }
    var error by rememberSaveable { mutableStateOf("") }

    val nombresPoliticos = mutableListOf<String>()
    for (politico in CampanaData.politicos) {
        nombresPoliticos.add(politico.nombre)
    }

    val nombresPartidos = mutableListOf<String>()
    val partidosRivales = mutableListOf<String>()
    for (opcion in CampanaData.partidos) {
        nombresPartidos.add(opcion.nombre)
        if (opcion.nombre != partido) {
            partidosRivales.add(opcion.nombre)
        }
    }

    fun guardarParticipacion() {
        val fechaElegida = fecha

        if (politicoId.isEmpty() || partido.isEmpty() || rival.isEmpty() ||
            temas.isEmpty() || fechaElegida == null
        ) {
            error = "Selecciona una persona, un partido, al menos un tema, un rival y una fecha."
        } else if (partido == rival) {
            error = "El partido rival debe ser diferente."
        } else {
            val nuevaParticipacion = Participacion(
                id = 0,
                politicoId = politicoId,
                partido = partido,
                temas = temas.toList(),
                puntos = puntos.roundToInt(),
                rival = rival,
                fecha = fechaElegida
            )
            onGuardar(nuevaParticipacion)
        }
    }

    // La flecha y el botón Atrás intentan guardar el formulario.
    BackHandler {
        guardarParticipacion()
    }

    Scaffold(
        topBar = {
            BarraSuperior(
                titulo = "Nueva intervención",
                onVolver = { guardarParticipacion() },
                descripcionVolver = "Volver y guardar"
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Registra un debate de tu campaña",
                style = MaterialTheme.typography.titleLarge
            )
            Text(
                text = "La flecha guarda y vuelve a la lista. Puedes salir sin guardar con Cancelar.",
                style = MaterialTheme.typography.bodySmall
            )
            if (error.isNotEmpty()) {
                Text(error, color = MaterialTheme.colorScheme.error)
            }

            Desplegable(
                etiqueta = "Político",
                valor = nombrePolitico,
                opciones = nombresPoliticos,
                onElegir = { nombre ->
                    for (politico in CampanaData.politicos) {
                        if (politico.nombre == nombre) {
                            politicoId = politico.id
                            nombrePolitico = politico.nombre
                            partido = politico.partido
                        }
                    }
                    if (rival == partido) {
                        rival = ""
                    }
                }
            )
            Desplegable(
                etiqueta = "Partido en este debate",
                valor = partido,
                opciones = nombresPartidos,
                onElegir = { partidoElegido ->
                    partido = partidoElegido
                    if (rival == partido) {
                        rival = ""
                    }
                }
            )
            Text(
                text = "El partido se propone al elegir la persona. Puedes cambiarlo para esta simulación.",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Temas tratados · elige uno o varios",
                style = MaterialTheme.typography.titleMedium
            )
            Column {
                CampanaData.temas.forEach { tema ->
                    val marcado = temas.contains(tema)

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .toggleable(
                                value = marcado,
                                role = Role.Checkbox,
                                onValueChange = { seleccionado ->
                                    val nuevosTemas = temas.toMutableList()
                                    if (seleccionado) {
                                        nuevosTemas.add(tema)
                                    } else {
                                        nuevosTemas.remove(tema)
                                    }
                                    temas = nuevosTemas
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // La fila completa se encarga de marcar o desmarcar.
                        Checkbox(
                            checked = marcado,
                            onCheckedChange = null,
                            modifier = Modifier.padding(12.dp)
                        )
                        Text(tema)
                    }
                }
            }

            Text(
                text = "Puntuación ficticia: ${puntos.roundToInt()} / 100",
                style = MaterialTheme.typography.titleMedium
            )
            Slider(
                value = puntos,
                onValueChange = { nuevoValor ->
                    puntos = nuevoValor.roundToInt().toFloat()
                },
                valueRange = 0f..100f,
                steps = 99
            )
            Desplegable(
                etiqueta = "Partido rival",
                valor = rival,
                opciones = partidosRivales,
                onElegir = { partidoElegido ->
                    rival = partidoElegido
                }
            )

            OutlinedButton(
                onClick = { mostrarCalendario = true },
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(Icons.Default.DateRange, contentDescription = null)
                Spacer(Modifier.width(8.dp))
                val fechaElegida = fecha
                if (fechaElegida == null) {
                    Text("Seleccionar fecha")
                } else {
                    Text("Fecha: ${mostrarFecha(fechaElegida)}")
                }
            }
            if (error.isNotEmpty()) {
                Text(error, color = MaterialTheme.colorScheme.error)
            }
            Button(
                onClick = { guardarParticipacion() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar y volver")
            }
            TextButton(
                onClick = onCancelar,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cancelar sin guardar")
            }
        }
    }

    if (mostrarCalendario) {
        val estadoFecha = rememberDatePickerState(initialSelectedDateMillis = fecha)

        DatePickerDialog(
            onDismissRequest = { mostrarCalendario = false },
            confirmButton = {
                TextButton(
                    enabled = estadoFecha.selectedDateMillis != null,
                    onClick = {
                        fecha = estadoFecha.selectedDateMillis
                        mostrarCalendario = false
                    }
                ) {
                    Text("Aceptar")
                }
            },
            dismissButton = {
                TextButton(onClick = { mostrarCalendario = false }) {
                    Text("Cancelar")
                }
            }
        ) {
            DatePicker(state = estadoFecha)
        }
    }
}
