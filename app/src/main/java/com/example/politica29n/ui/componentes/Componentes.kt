package com.example.politica29n.ui.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.politica29n.data.CampanaData
import com.example.politica29n.data.mostrarFecha
import com.example.politica29n.model.Participacion
import com.example.politica29n.model.Politico

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSuperior(titulo: String, onVolver: (() -> Unit)? = null, descripcionVolver: String = "Volver") {
    TopAppBar(title = { Text(titulo, fontWeight = FontWeight.Bold) },
        navigationIcon = {
            if (onVolver != null) IconButton(onClick = onVolver) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, descripcionVolver)
            }
        })
}

@Composable
fun FotoPolitico(politico: Politico, modifier: Modifier = Modifier) {
    Image(painterResource(politico.foto), contentDescription = politico.nombre,
        contentScale = ContentScale.Crop, alignment = Alignment.TopCenter,
        modifier = modifier.clip(RoundedCornerShape(12.dp)))
}

@Composable
fun TarjetaParticipacion(
    registro: Participacion, modoBorrado: Boolean, seleccionado: Boolean,
    onPulsar: () -> Unit, onSeleccionar: () -> Unit
) {
    val politico = CampanaData.politico(registro.politicoId)
    val color = Color(CampanaData.color(registro.partido))
    Card(modifier = Modifier.fillMaxWidth().clickable {
        if (modoBorrado) onSeleccionar() else onPulsar()
    }, colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.12f))) {
        Row(Modifier.padding(12.dp), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            FotoPolitico(politico, Modifier.width(72.dp).height(96.dp))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(registro.partido, color = color, style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold)
                Text(politico.nombre, fontWeight = FontWeight.Bold)
                Text("Frente a ${registro.rival} · ${mostrarFecha(registro.fecha)}",
                    style = MaterialTheme.typography.bodySmall)
                Text("${registro.puntos} puntos", color = color, fontWeight = FontWeight.Bold)
            }
            if (modoBorrado) Checkbox(checked = seleccionado, onCheckedChange = { onSeleccionar() })
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Desplegable(etiqueta: String, valor: String, opciones: List<String>, onElegir: (String) -> Unit) {
    var abierto by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = abierto, onExpandedChange = { abierto = it }) {
        OutlinedTextField(value = valor, onValueChange = {}, readOnly = true,
            label = { Text(etiqueta) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = abierto) },
            modifier = Modifier.fillMaxWidth().menuAnchor(ExposedDropdownMenuAnchorType.PrimaryNotEditable))
        ExposedDropdownMenu(expanded = abierto, onDismissRequest = { abierto = false }) {
            opciones.forEach { opcion ->
                DropdownMenuItem(text = { Text(opcion) }, onClick = { onElegir(opcion); abierto = false })
            }
        }
    }
}
