package com.example.politica29n.ui.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.politica29n.data.creditosFotos
import com.example.politica29n.data.CampanaData
import com.example.politica29n.data.mostrarFecha
import com.example.politica29n.model.Participacion
import com.example.politica29n.ui.componentes.*
import java.util.Locale

@Composable
fun PantallaDetalle(registro: Participacion?, registros: List<Participacion>, onVolver: () -> Unit) {
    val uriHandler = LocalUriHandler.current
    Scaffold(topBar = { BarraSuperior("Ficha del debate", onVolver) }) { padding ->
        if (registro == null) {
            Text("Esta intervención ya no está disponible.", Modifier.padding(padding).padding(24.dp))
        } else {
            val politico = CampanaData.politico(registro.politicoId)
            // Se calcula sobre toda la lista, no solo sobre el partido filtrado.
            val historial = registros.filter { it.politicoId == politico.id }
            val media = historial.map { it.puntos }.average()
            Column(Modifier.padding(padding).fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(politico.nombre, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                Text("${registro.partido} · Campaña 29N", style = MaterialTheme.typography.titleMedium)
                FotoPolitico(politico, Modifier.fillMaxWidth().height(300.dp))
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Historial en tu campaña", style = MaterialTheme.typography.titleMedium)
                        Text("Debates registrados: ${historial.size}")
                        Text("Media de puntos: ${String.format(Locale("es", "ES"), "%.2f", media)}")
                        Text("En este debate: ${registro.puntos} / 100 puntos", fontWeight = FontWeight.Bold)
                    }
                }
                Text("Frente a ${registro.rival} · ${mostrarFecha(registro.fecha)}")
                Text("Temas: ${registro.temas.joinToString()}")
                Text("Datos de una simulación; no son votos ni resultados electorales.",
                    style = MaterialTheme.typography.bodySmall)
                HorizontalDivider()
                Text("Sobre ${politico.nombre}", style = MaterialTheme.typography.titleLarge)
                Text(politico.biografia, style = MaterialTheme.typography.bodyLarge)
                TextButton(onClick = { uriHandler.openUri(politico.fuente) }) { Text("Consultar fuente biográfica") }
                Text("${creditosFotos[politico.id]} Fuentes completas en CREDITOS.md.",
                    style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
