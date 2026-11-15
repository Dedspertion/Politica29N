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
import com.example.politica29n.ui.componentes.BarraSuperior
import com.example.politica29n.ui.componentes.FotoPolitico
import java.util.Locale

@Composable
fun PantallaDetalle(
    registro: Participacion?,
    registros: List<Participacion>,
    onVolver: () -> Unit
) {
    val navegador = LocalUriHandler.current

    Scaffold(
        topBar = {
            BarraSuperior(
                titulo = "Ficha del debate",
                onVolver = onVolver
            )
        }
    ) { padding ->
        if (registro == null) {
            Text(
                text = "Esta intervención ya no está disponible.",
                modifier = Modifier.padding(padding).padding(24.dp)
            )
        } else {
            val politico = CampanaData.politico(registro.politicoId)

            // Contamos todos sus debates, aunque haya un filtro en la lista.
            var numeroDebates = 0
            var totalPuntos = 0
            for (participacion in registros) {
                if (participacion.politicoId == politico.id) {
                    numeroDebates++
                    totalPuntos += participacion.puntos
                }
            }

            var media = 0.0
            if (numeroDebates > 0) {
                media = totalPuntos.toDouble() / numeroDebates
            }
            val mediaFormateada = String.format(Locale("es", "ES"), "%.2f", media)

            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = politico.nombre,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "${registro.partido} · Campaña 29N",
                    style = MaterialTheme.typography.titleMedium
                )
                FotoPolitico(
                    politico = politico,
                    modifier = Modifier.fillMaxWidth().height(300.dp)
                )
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Historial en tu campaña",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text("Debates registrados: $numeroDebates")
                        Text("Media de puntos: $mediaFormateada")
                        Text(
                            text = "En este debate: ${registro.puntos} / 100 puntos",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Text("Frente a ${registro.rival} · ${mostrarFecha(registro.fecha)}")
                Text("Temas: ${registro.temas.joinToString()}")
                Text(
                    text = "Datos de una simulación; no son votos ni resultados electorales.",
                    style = MaterialTheme.typography.bodySmall
                )
                HorizontalDivider()
                Text(
                    text = "Sobre ${politico.nombre}",
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = politico.biografia,
                    style = MaterialTheme.typography.bodyLarge
                )
                TextButton(onClick = { navegador.openUri(politico.fuente) }) {
                    Text("Consultar fuente biográfica")
                }
                Text(
                    text = "${creditosFotos[politico.id]} Fuentes completas en CREDITOS.md.",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
