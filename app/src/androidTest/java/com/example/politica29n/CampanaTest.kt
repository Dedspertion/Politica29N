package com.example.politica29n

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.politica29n.navigation.Navegacion
import com.example.politica29n.ui.theme.CampanaTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CampanaTest {
    @get:Rule val compose = createComposeRule()
    private fun abrir() { compose.setContent { CampanaTheme { Navegacion() } } }

    @Test fun detalleCalculaMediaDeLaPersona() {
        abrir()
        compose.onAllNodesWithText("Alberto Núñez Feijóo")[0].performClick()
        compose.onNodeWithText("Debates registrados: 3").performScrollTo().assertIsDisplayed()
        compose.onNodeWithText("Media de puntos: 73,00").performScrollTo().assertIsDisplayed()
        compose.onNodeWithText("En este debate: 72 / 100 puntos").assertExists()
    }

    @Test fun borrarPermiteCancelarYConfirmarSinEntrarAlDetalle() {
        abrir()
        compose.onNodeWithText("Borrar", useUnmergedTree = true).performClick()
        compose.onAllNodesWithText("Alberto Núñez Feijóo")[0].performClick()
        compose.onNodeWithText("Añadir", useUnmergedTree = true).performClick()
        compose.onNodeWithText("Nueva intervención").assertDoesNotExist()
        compose.onNodeWithText("Borrar (1)", useUnmergedTree = true).performClick()
        compose.onAllNodesWithText("Cancelar").onLast().performClick()
        compose.onNodeWithText("48 intervenciones").assertDoesNotExist()
        compose.onNodeWithText("Borrar (1)", useUnmergedTree = true).performClick()
        compose.onNodeWithText("OK").performClick()
        compose.onNodeWithText("47 intervenciones").assertIsDisplayed()
    }

    @Test fun buscarPorPrefijoSeleccionarYLimpiar() {
        abrir()
        compose.onNodeWithText("Buscar partido político").performClick()
        compose.onAllNodes(hasSetTextAction()).onLast().performTextInput("Po")
        compose.onAllNodesWithText("Podemos").onLast().performClick()
        compose.onNodeWithText("2 intervenciones").assertIsDisplayed()
        compose.onNodeWithText("Irene Montero").assertIsDisplayed()
        compose.onNodeWithContentDescription("Mostrar todos").performClick()
        compose.onNodeWithText("48 intervenciones").assertIsDisplayed()
    }

    @Test fun formularioValidaYCreaUnaParticipacion() {
        abrir()
        compose.onNodeWithText("Añadir", useUnmergedTree = true).performClick()
        compose.onNodeWithContentDescription("Volver y guardar").performClick()
        compose.onAllNodesWithText("Selecciona una persona, un partido, al menos un tema, un rival y una fecha.")[0].assertExists()
        compose.onNodeWithText("Político").performClick()
        compose.onNodeWithText("Alberto Núñez Feijóo").performClick()
        compose.onNodeWithText("Economía").performScrollTo().performClick()
        compose.onNodeWithText("Vivienda").performScrollTo().performClick()
        compose.onNodeWithText("Partido rival").performScrollTo().performClick()
        compose.onNodeWithText("PSOE").performClick()
        compose.onNodeWithText("Seleccionar fecha").performScrollTo().performClick()
        compose.onAllNodes(hasText("15", substring = true) and hasClickAction()).onFirst().performClick()
        compose.onNodeWithText("Aceptar").performClick()
        compose.onNodeWithContentDescription("Volver y guardar").performClick()
        compose.onNodeWithText("49 intervenciones").assertIsDisplayed()
    }
}
