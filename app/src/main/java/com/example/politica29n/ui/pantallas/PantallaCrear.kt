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
import com.example.politica29n.ui.componentes.*
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaCrear(onGuardar: (Participacion) -> Unit, onCancelar: () -> Unit) {
    var politicoId by rememberSaveable { mutableStateOf("") }
    var partido by rememberSaveable { mutableStateOf("") }
    var rival by rememberSaveable { mutableStateOf("") }
    var temas by rememberSaveable { mutableStateOf(listOf<String>()) }
    var puntos by rememberSaveable { mutableFloatStateOf(0f) }
    var fecha by rememberSaveable { mutableStateOf<Long?>(null) }
    var calendario by remember { mutableStateOf(false) }
    var error by rememberSaveable { mutableStateOf("") }
    val politico = CampanaData.politicos.firstOrNull { it.id == politicoId }

    val guardar: () -> Unit = {
        if (politicoId.isEmpty() || partido.isEmpty() || rival.isEmpty() || temas.isEmpty() || fecha == null) {
            error = "Selecciona una persona, un partido, al menos un tema, un rival y una fecha."
        } else if (partido == rival) {
            error = "El partido rival debe ser diferente."
        } else {
            onGuardar(Participacion(0, politicoId, partido, temas.toList(), puntos.roundToInt(), rival, fecha!!))
        }
    }
    // Tanto la flecha como el botón Atrás guardan, como pide el enunciado.
    BackHandler { guardar() }
    Scaffold(topBar = { BarraSuperior("Nueva intervención", guardar, "Volver y guardar") }) { padding ->
        Column(Modifier.padding(padding).fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text("Registra un debate de tu campaña", style = MaterialTheme.typography.titleLarge)
            Text("La flecha guarda y vuelve a la lista. Puedes salir sin guardar con Cancelar.",
                style = MaterialTheme.typography.bodySmall)
            if (error.isNotEmpty()) Text(error, color = MaterialTheme.colorScheme.error)
            Desplegable("Político", politico?.nombre ?: "", CampanaData.politicos.map { it.nombre }) { nombre ->
                val elegido = CampanaData.politicos.first { it.nombre == nombre }
                politicoId = elegido.id
                partido = elegido.partido
                if (rival == partido) rival = ""
            }
            Desplegable("Partido en este debate", partido, CampanaData.partidos.map { it.nombre }) {
                partido = it
                if (rival == partido) rival = ""
            }
            Text("El partido se propone al elegir la persona. Puedes cambiarlo para esta simulación.",
                style = MaterialTheme.typography.bodySmall)
            Text("Temas tratados · elige uno o varios", style = MaterialTheme.typography.titleMedium)
            Column {
                CampanaData.temas.forEach { tema ->
                    Row(Modifier.fillMaxWidth().toggleable(value = tema in temas, role = Role.Checkbox,
                        onValueChange = { marcado -> temas = if (marcado) temas + tema else temas - tema }),
                        verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(checked = tema in temas, onCheckedChange = null, modifier = Modifier.padding(12.dp))
                        Text(tema)
                    }
                }
            }
            Text("Puntuación ficticia: ${puntos.roundToInt()} / 100", style = MaterialTheme.typography.titleMedium)
            Slider(value = puntos, onValueChange = { puntos = it.roundToInt().toFloat() },
                valueRange = 0f..100f, steps = 99)
            Desplegable("Partido rival", rival, CampanaData.partidos.map { it.nombre }.filter { it != partido }) { rival = it }
            OutlinedButton(onClick = { calendario = true }, modifier = Modifier.fillMaxWidth()) {
                Icon(Icons.Default.DateRange, null)
                Spacer(Modifier.width(8.dp))
                Text(if (fecha == null) "Seleccionar fecha" else "Fecha: ${mostrarFecha(fecha!!)}")
            }
            if (error.isNotEmpty()) Text(error, color = MaterialTheme.colorScheme.error)
            Button(onClick = guardar, modifier = Modifier.fillMaxWidth()) { Text("Guardar y volver") }
            TextButton(onClick = onCancelar, modifier = Modifier.fillMaxWidth()) { Text("Cancelar sin guardar") }
        }
    }
    if (calendario) {
        val estadoFecha = rememberDatePickerState(initialSelectedDateMillis = fecha)
        DatePickerDialog(onDismissRequest = { calendario = false },
            confirmButton = {
                TextButton(enabled = estadoFecha.selectedDateMillis != null,
                    onClick = { fecha = estadoFecha.selectedDateMillis; calendario = false }) { Text("Aceptar") }
            }, dismissButton = { TextButton(onClick = { calendario = false }) { Text("Cancelar") } }) {
            DatePicker(state = estadoFecha)
        }
    }
}
