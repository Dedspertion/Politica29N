# 29N Fantasy

Práctica 3 de Programación Multimedia y Dispositivos Móviles, adaptada a una campaña electoral del 29 de noviembre. Permite registrar intervenciones ficticias de políticos en debates, buscar por partido y consultar sus estadísticas.

## Abrir y ejecutar

Abrir **esta carpeta `trabajo politica`** en Android Studio, sincronizar Gradle y ejecutar `app` en un emulador o móvil Android (mínimo API 24). No abrir el proyecto de la carpeta superior PGL para ejecutar esta práctica.

Se conservan las dependencias de la aplicación del proyecto de clase. Solo se actualizan las dependencias de pruebas (JUnit Android 1.3.0 y Espresso 3.8.0-alpha04) para ejecutarlas en el emulador API 37. Las fotografías están incluidas en `res/drawable-nodpi`; no hace falta Internet para usar las tres pantallas. Los enlaces a las fuentes sí abren el navegador.

## Adaptación del enunciado

| NBA Fantasy | 29N Fantasy |
| --- | --- |
| Jugador | Político de una lista prefijada |
| Equipo | Partido político en ese debate |
| Partido de baloncesto | Participación en un debate ficticio |
| Posiciones | Temas tratados, con selección múltiple |
| Puntos | Puntuación de juego de 0 a 100 |
| Equipo rival | Partido político rival |
| Fecha del partido | Fecha del debate |
| Partidos jugados y media | Debates registrados y media de puntos de la persona |

El enunciado permite otras temáticas, pero indica que se consulten con el profesor. Esta propuesta debe validarse con él. No se necesita una función de traspasos: al crear un registro se propone el partido de la persona, y se puede escoger otro para la simulación sin alterar sus registros anteriores. El catálogo incluye partidos y agrupaciones para practicar la búsqueda; no pretende enumerar candidaturas oficiales del 29N. Las puntuaciones no son encuestas ni resultados electorales.

## Las tres pantallas

- **Lista:** SearchBar con sugerencias por prefijo, 22 partidos disponibles y tarjetas propias dentro de una LazyColumn. Al limpiar la búsqueda aparecen todas las intervenciones. Las tarjetas tienen foto y color según el partido.
- **Creación:** desplegables de persona, partido y rival; casillas para varios temas; Slider con 99 pasos intermedios (101 valores de 0 a 100); DatePicker; desplazamiento vertical. La flecha y Atrás guardan si los datos están completos. También hay un botón Guardar y una salida explícita sin guardar.
- **Detalle:** foto, información del registro, número de debates de esa persona, media calculada sobre todo su historial y texto biográfico con enlace a la fuente.

Al pulsar Borrar se activa la selección múltiple y Añadir deja de actuar. Una segunda pulsación abre la confirmación. Cancelar en el diálogo conserva la selección; Cancelar en la pantalla sale del modo borrado. Cambiar el filtro limpia la selección para evitar borrar elementos ocultos.

## Organización y relación con clase

- `MainActivity.kt`: inicia Compose y carga la navegación.
- `navigation/Keys.kt`: destinos serializables, como `Rutas` en clase.
- `navigation/Navigation.kt`: `rememberNavBackStack`, `NavDisplay` y lista mutable compartida. Recibe los eventos de añadir y borrar.
- `model/Participacion.kt`: clases de datos.
- `data/CampanaData.kt`: `listOf` iniciales, catálogo y formato de fechas.
- `ui/pantallas`: las tres pantallas.
- `ui/componentes`: tarjeta propia, desplegable, buscador, fotografía y barra superior.
- `ui/theme/CampanaTheme.kt`: colores de la práctica.

Se reutilizan los patrones de los ejercicios 1 (desplegables), 2 (AlertDialog), 3 (listas y lambdas) y 4 (SearchBar). Los ejercicios originales se conservan en `PGL/trabajo3`; este proyecto contiene únicamente la aplicación política.

El estado compartido vive en `Navegacion`: los hijos reciben datos y notifican cambios mediante funciones lambda. No hay repositorios, ViewModels ni base de datos. Al recrearse la Activity o reiniciar el proceso se recuperan los datos iniciales, como corresponde al almacenamiento en memoria utilizado en clase.

## Comprobación manual

1. Abrir la lista: aparecen 48 intervenciones.
2. Buscar `Po`, elegir Podemos: aparecen Irene Montero e Ione Belarra. Limpiar: aparecen las 48.
3. Abrir el primer Feijóo: 3 debates, media 73,00 y 72 puntos en ese registro.
4. Crear una intervención con dos temas, rival, fecha y puntuación. Volver con la flecha: aparece un registro más y se actualiza su media.
5. Activar borrado, seleccionar dos tarjetas y cancelar la confirmación: no se borra nada. Confirmar después: se eliminan únicamente las seleccionadas.
6. Probar formulario incompleto, partido sin registros y borrado sin selección.

Comandos desde esta carpeta:

```sh
sh gradlew :app:assembleDebug :app:lintDebug
sh gradlew :app:connectedDebugAndroidTest
```

Las pruebas de interfaz están en `app/src/androidTest/.../CampanaTest.kt` y requieren un emulador o dispositivo. El APK se genera en `app/build/outputs/apk/debug/app-debug.apk`.

## Entrega y fuentes

La entrega indicada en el enunciado es un enlace a GitHub. Este proyecto tiene su propio repositorio Git local, sin historial del profesor y sin remoto configurado. Se puede publicar en un repositorio propio desde Android Studio (Git > GitHub > Share Project on GitHub). No se ha subido nada a GitHub. El proyecto de clase permanece en su carpeta original.

Consultar [CREDITOS.md](CREDITOS.md) para las fuentes biográficas, autores y licencias de las fotografías.

## Verificación realizada

Compilación Debug y Android Lint completados. Cinco pruebas instrumentadas superadas en el emulador API 37: contexto de la app, estadísticas, búsqueda y limpieza, borrado con cancelación y confirmación, y formulario con selección múltiple, fecha y guardado desde la flecha.

El catálogo completo está en [PARTIDOS.md](PARTIDOS.md): 22 partidos, 44 representantes y 48 intervenciones iniciales. Cada formación tiene exactamente dos personas con ficha y foto. Las parejas combinan figuras actuales e históricas, no una presidencia y vicepresidencia oficial. Koldo García acompaña a Pedro Sánchez como invitado del juego, sin atribuirle un cargo ni militancia actual.

El identificador de esta aplicación es `com.example.politica29n`, distinto del proyecto de ejercicios, para poder instalar ambas sin sobrescribirlas.

También pasan las tres pruebas locales, incluidas las dos del catálogo: dos representantes por partido, ejemplos para todos, parejas de ERC y PSOE, identificadores únicos y rivales válidos.
