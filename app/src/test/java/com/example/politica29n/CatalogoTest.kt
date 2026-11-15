package com.example.politica29n

import com.example.politica29n.data.CampanaData
import org.junit.Assert.*
import org.junit.Test

class CatalogoTest {
    @Test fun cadaPartidoTieneDosRepresentantesConEjemplos() {
        val datos = CampanaData
        assertEquals(22, datos.partidos.size)
        assertEquals(44, datos.politicos.size)
        assertEquals(44, datos.politicos.map { it.id }.distinct().size)
        datos.partidos.forEach { partido ->
            val pareja = datos.politicos.filter { it.partido == partido.nombre }
            assertEquals(partido.nombre, 2, pareja.size)
            pareja.forEach { politico ->
                assertTrue(datos.participaciones.any { it.politicoId == politico.id && it.partido == partido.nombre })
                assertTrue(politico.biografia.isNotBlank())
                assertTrue(politico.fuente.startsWith("https://"))
            }
        }
        assertEquals(setOf("rufian", "junqueras"), datos.politicos.filter { it.partido == "ERC" }.map { it.id }.toSet())
        assertEquals(setOf("sanchez", "koldo"), datos.politicos.filter { it.partido == "PSOE" }.map { it.id }.toSet())
    }

    @Test fun losRegistrosTienenIdsUnicosYRivalesValidos() {
        val registros = CampanaData.participaciones
        assertEquals(registros.size, registros.map { it.id }.distinct().size)
        registros.forEach {
            assertTrue(it.puntos in 0..100)
            assertNotEquals(it.partido, it.rival)
            assertTrue(CampanaData.partidos.any { partido -> partido.nombre == it.rival })
        }
    }
}
