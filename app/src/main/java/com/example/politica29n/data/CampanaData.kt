package com.example.politica29n.data

import com.example.politica29n.R
import com.example.politica29n.model.Participacion
import com.example.politica29n.model.Partido
import com.example.politica29n.model.Politico
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

object CampanaData {
    // Catálogo para los desplegables. No representa candidaturas oficiales del 29N.
    val partidos = listOf(
        Partido("PP", 0xFF1565C0),
        Partido("PSOE", 0xFFB71C1C),
        Partido("Vox", 0xFF387026),
        Partido("Sumar", 0xFFAD245C),
        Partido("Podemos", 0xFF69358B),
        Partido("ERC", 0xFF876200),
        Partido("Junts", 0xFF007B75),
        Partido("PNV", 0xFF23744F),
        Partido("EH Bildu", 0xFF667327),
        Partido("BNG", 0xFF28749A),
        Partido("Coalición Canaria", 0xFF926800),
        Partido("Nueva Canarias", 0xFF38724C),
        Partido("UPN", 0xFF9C3030),
        Partido("PACMA", 0xFF477129),
        Partido("Compromís", 0xFFA95118),
        Partido("Más Madrid", 0xFF087D70),
        Partido("Izquierda Unida", 0xFFA42E39),
        Partido("Ciudadanos", 0xFFA34C16),
        Partido("CUP", 0xFF766500),
        Partido("Teruel Existe", 0xFF436749),
        Partido("PRC", 0xFF665B22),
        Partido("Partido Aragonés", 0xFF895522)
    )
    val temas = listOf("Economía", "Vivienda", "Sanidad", "Educación", "Medio ambiente")

    val politicos = listOf(
        Politico("feijoo", "Alberto Núñez Feijóo", "PP", R.drawable.feijoo,
            "Alberto Núñez Feijóo es un político y funcionario español. Su trayectoria incluye una larga etapa en la política autonómica de Galicia: presidió la Xunta entre 2009 y 2022. También fue senador por designación del Parlamento gallego entre 2022 y 2023.\n\nEn 2022 pasó a presidir el Partido Popular. Su recorrido permite distinguir entre la representación autonómica y la actividad política de ámbito estatal. En esta aplicación su ficha reúne diferentes intervenciones de una campaña simulada; los puntos y los enfrentamientos son datos de práctica, no valoraciones de su actividad real.",
            "https://es.wikipedia.org/wiki/Alberto_Núñez_Feijóo"),
        Politico("ayuso", "Isabel Díaz Ayuso", "PP", R.drawable.ayuso,
            "Isabel Díaz Ayuso es una periodista y política española vinculada al Partido Popular. Su trayectoria se ha desarrollado especialmente en la Comunidad de Madrid, cuya presidencia asumió en agosto de 2019. En mayo de 2022 pasó también a presidir el Partido Popular de Madrid.\n\nSu ficha sirve para mostrar que un mismo partido puede tener más de un representante dentro de la lista. Cada intervención tiene su propia fecha, rival y temas, aunque la fotografía y la información personal sean las mismas. Las intervenciones incluidas en 29N Fantasy son ejemplos ficticios para practicar listas y estadísticas; no describen debates reales ni una candidatura oficial.",
            "https://es.wikipedia.org/wiki/Isabel_Díaz_Ayuso"),
        Politico("sanchez", "Pedro Sánchez", "PSOE", R.drawable.sanchez,
            "Pedro Sánchez Pérez-Castejón es un político y economista español perteneciente al Partido Socialista Obrero Español. Ocupó la secretaría general del PSOE entre 2014 y 2016 y volvió a ella en 2017. Accedió a la presidencia del Gobierno en junio de 2018 y fue investido de nuevo en enero de 2020 y noviembre de 2023.\n\nSu trayectoria combina responsabilidades dentro de su formación con funciones en las instituciones del Estado. En esta práctica aparece como uno de los participantes disponibles en el desplegable. Los registros se agrupan por persona para calcular el número de debates y la media, con independencia del filtro que esté activo en la pantalla principal.",
            "https://es.wikipedia.org/wiki/Pedro_Sánchez"),
        Politico("diaz", "Yolanda Díaz", "Sumar", R.drawable.diaz,
            "Yolanda Díaz Pérez es una abogada laboralista y política española nacida en Fene, A Coruña, en 1971. Estudió Derecho en la Universidad de Santiago de Compostela. Su formación jurídica y su ejercicio profesional estuvieron relacionados con el ámbito del trabajo.\n\nFue elegida diputada en el Parlamento de Galicia en 2012 y pasó al Congreso de los Diputados tras las elecciones generales de 2016. Asumió el Ministerio de Trabajo y Economía Social en enero de 2020 y la vicepresidencia segunda del Gobierno en julio de 2021. Aquí se utiliza su nombre en una simulación educativa; los temas seleccionados y los puntos no representan una evaluación de su gestión.",
            "https://www.mites.gob.es/es/organizacion/organigrama/bio/bio_ministra.htm"),
        Politico("abascal", "Santiago Abascal", "Vox", R.drawable.abascal,
            "Santiago Abascal Conde es un político español que pasó por el Partido Popular antes de su etapa en Vox. Su trayectoria incluye actividad en el Parlamento Vasco y responsabilidades en entidades de la Comunidad de Madrid. En septiembre de 2014 asumió el liderazgo de Vox.\n\nEn 2019 entró en el Congreso de los Diputados por Madrid. Esta ficha recoge una breve referencia a su recorrido para acompañar la imagen y las estadísticas que solicita la práctica. Los registros del listado son intervenciones inventadas: la fecha, el partido rival y los puntos se eligen en el formulario y no proceden de resultados electorales ni de encuestas.",
            "https://es.wikipedia.org/wiki/Santiago_Abascal"),
        Politico("montero", "Irene Montero", "Podemos", R.drawable.montero,
            "Irene María Montero Gil es una política y psicóloga española vinculada a Podemos. Su actividad pública incluye responsabilidades parlamentarias y su etapa como ministra de Igualdad del Gobierno de España, que se desarrolló entre 2020 y 2023. Posteriormente pasó a ejercer como eurodiputada por su formación.\n\nEn esta aplicación es una de las personas que se pueden escoger para registrar una nueva participación. Cada registro conserva los datos del debate seleccionado, mientras que la pantalla de detalle reúne el historial de esa persona. Los puntos son una escala de juego entre cero y cien y no deben interpretarse como votos, porcentajes de apoyo ni una medida de popularidad.",
            "https://es.wikipedia.org/wiki/Irene_Montero"),
        Politico("koldo", "Koldo García", "PSOE", R.drawable.koldo,
            "Koldo García Izaguirre trabajó como asesor de José Luis Ábalos durante su etapa en el Ministerio de Fomento y Transportes. Su trayectoria está relacionada con labores de asesoramiento y organización política. En esta app acompaña a Pedro Sánchez por elección del autor del juego: es una pareja ficticia, no una afirmación de militancia actual ni de que haya ocupado la vicepresidencia del PSOE.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://efe.com/espana/2024-02-22/koldo-asesor-abalos-mascarillas-reacciones/"),
        Politico("garriga", "Ignacio Garriga", "Vox", R.drawable.garriga,
            "Ignacio Garriga es un odontólogo y político vinculado a Vox. Representó a Barcelona en el Congreso de los Diputados durante las legislaturas XIII y XIV. En octubre de 2022 asumió la secretaría general de su formación, una responsabilidad de organización interna que se diferencia de los cargos que se ejercen en las instituciones públicas.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Ignacio_Garriga"),
        Politico("urtasun", "Ernest Urtasun", "Sumar", R.drawable.urtasun,
            "Ernest Urtasun es un economista, diplomático y político español vinculado a Sumar. Su trayectoria combina la actividad diplomática con responsabilidades de representación política. Ha ejercido como portavoz de Sumar y como ministro de Cultura, dos funciones distintas: una pertenece a la organización política y la otra a la Administración del Estado.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Ernest_Urtasun"),
        Politico("belarra", "Ione Belarra", "Podemos", R.drawable.belarra,
            "Ione Belarra es una psicóloga y política española vinculada a Podemos. Su trayectoria incluye la representación parlamentaria y responsabilidades en el Gobierno de España. Entre 2020 y 2021 fue secretaria de Estado para la Agenda 2030; posteriormente ejerció como ministra de Derechos Sociales y Agenda 2030 entre 2021 y 2023.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Ione_Belarra"),
        Politico("rufian", "Gabriel Rufián", "ERC", R.drawable.rufian,
            "Gabriel Rufián es un político, entrevistador y activista español vinculado a Esquerra Republicana de Catalunya. Su actividad pública incluye la participación en la plataforma Súmate, creada en 2013, y la representación parlamentaria. En 2019 pasó a ejercer como portavoz de ERC en el Congreso de los Diputados.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Gabriel_Rufi%C3%A1n"),
        Politico("junqueras", "Oriol Junqueras", "ERC", R.drawable.junqueras,
            "Oriol Junqueras es un historiador y político vinculado a Esquerra Republicana de Catalunya. Su trayectoria combina el trabajo académico con responsabilidades dentro de su formación. En diciembre de 2024 volvió a asumir la presidencia de ERC. En el catálogo comparte partido con Gabriel Rufián, cuya actividad se asocia especialmente a la portavocía en el Congreso.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Oriol_Junqueras"),
        Politico("puigdemont", "Carles Puigdemont", "Junts", R.drawable.puigdemont,
            "Carles Puigdemont es un político catalán vinculado a Junts per Catalunya. Fue presidente de la Generalitat entre 2016 y 2017 y diputado en el Parlamento Europeo entre 2019 y 2024. En octubre de 2024 asumió la presidencia de Junts. Su trayectoria incluye, por tanto, responsabilidades autonómicas, europeas y de organización de partido.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Carles_Puigdemont"),
        Politico("turull", "Jordi Turull", "Junts", R.drawable.turull,
            "Jordi Turull es un político catalán vinculado a Junts. Fue diputado en el Parlamento de Cataluña entre 2004 y 2018. Durante 2017 ejerció como consejero de la Presidencia y portavoz del Gobierno catalán. Su ficha permite distinguir entre la pertenencia a un partido y los distintos puestos institucionales que una persona puede haber ocupado.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Jordi_Turull"),
        Politico("esteban", "Aitor Esteban", "PNV", R.drawable.esteban,
            "Aitor Esteban es un abogado, jurista, profesor universitario y político vinculado al Partido Nacionalista Vasco. Su actividad profesional y pública combina el ámbito jurídico con la representación política. En 2025 asumió la presidencia del Euzkadi Buru Batzar, el órgano ejecutivo nacional del PNV.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Aitor_Esteban"),
        Politico("ortuzar", "Andoni Ortuzar", "PNV", R.drawable.ortuzar,
            "Andoni Ortuzar es un periodista y político vinculado al Partido Nacionalista Vasco. Fue presidente del Euzkadi Buru Batzar entre 2013 y 2025. Se incluye como una figura conocida de la formación y como compañero de Aitor Esteban en el juego, sin presentar a ambos como titulares simultáneos de la presidencia del partido.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Andoni_Ortuzar"),
        Politico("otegi", "Arnaldo Otegi", "EH Bildu", R.drawable.otegi,
            "Arnaldo Otegi es un político vinculado a la izquierda abertzale y a Euskal Herria Bildu. Su trayectoria incluye la participación en distintas organizaciones de ese espacio político. Desde 2017 ha ejercido como coordinador general de EH Bildu. En esta aplicación aparece junto a Mertxe Aizpurua para representar dos perfiles de la misma formación.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Arnaldo_Otegi"),
        Politico("aizpurua", "Mertxe Aizpurua", "EH Bildu", R.drawable.aizpurua,
            "Mertxe Aizpurua es una periodista y política vinculada a Euskal Herria Bildu. Ha representado a Guipúzcoa en el Congreso de los Diputados durante las legislaturas XIII, XIV y XV. También ha ejercido como portavoz de su grupo en la Cámara, una función relacionada con la comunicación y coordinación del trabajo parlamentario.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Mertxe_Aizpurua"),
        Politico("ponton", "Ana Pontón", "BNG", R.drawable.ponton,
            "Ana Pontón es una politóloga y política del Bloque Nacionalista Galego. En febrero de 2016, después de la XV Asamblea Nacional de su formación, se convirtió en la primera mujer en liderarla. Su actividad pública está especialmente vinculada a la política gallega y a la portavocía nacional del BNG.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Ana_Pont%C3%B3n"),
        Politico("rego", "Néstor Rego", "BNG", R.drawable.rego,
            "Néstor Rego es un profesor y político perteneciente al Bloque Nacionalista Galego. Su trayectoria incluye responsabilidades en la Unión do Povo Galego y representación en el Congreso de los Diputados por A Coruña durante las legislaturas XIV y XV. En el catálogo comparte formación con Ana Pontón.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/N%C3%A9stor_Rego"),
        Politico("clavijo", "Fernando Clavijo", "Coalición Canaria", R.drawable.clavijo,
            "Fernando Clavijo es un economista y político de Coalición Canaria. Fue presidente del Gobierno de Canarias entre 2015 y 2019 y volvió a asumir esa responsabilidad en julio de 2023. Su trayectoria está ligada a las instituciones del archipiélago y sirve para incorporar la política canaria al catálogo de la práctica.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Fernando_Clavijo_Batlle"),
        Politico("valido", "Cristina Valido", "Coalición Canaria", R.drawable.valido,
            "Cristina Valido es una política vinculada a Coalición Canaria. En agosto de 2023 asumió su escaño en el Congreso de los Diputados por Santa Cruz de Tenerife. En esta aplicación acompaña a Fernando Clavijo, mostrando dos ámbitos de representación distintos: las instituciones canarias y el Parlamento estatal.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Cristina_Valido"),
        Politico("rodriguez", "Román Rodríguez", "Nueva Canarias", R.drawable.rodriguez,
            "Román Rodríguez es un político nacido en La Aldea de San Nicolás, en Gran Canaria. Fue presidente del Gobierno de Canarias entre julio de 1999 y julio de 2003. Se incluye como una figura conocida de Nueva Canarias, junto a Luis Campos, dentro del catálogo de representantes de las formaciones canarias.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Rom%C3%A1n_Rodr%C3%ADguez"),
        Politico("campos", "Luis Campos", "Nueva Canarias", R.drawable.campos,
            "Luis Alberto Campos Jiménez es un representante político vinculado a Nueva Canarias-Bloque Canarista. Su ficha en el Parlamento de Canarias lo sitúa como diputado por la circunscripción de Gran Canaria. En esta práctica comparte formación con Román Rodríguez, aunque cada persona mantiene un historial independiente de participaciones.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://www.parcan.es/composicion/diputados/diputado/11023/"),
        Politico("esparza", "Javier Esparza", "UPN", R.drawable.esparza,
            "José Javier Esparza Abaurrea es un maestro y político nacido en Pamplona en 1970. Su trayectoria está vinculada a Unión del Pueblo Navarro y a la política foral. Se incluye junto a Cristina Ibarrola como una de las figuras conocidas de UPN, sin atribuir a la pareja una presidencia y vicepresidencia oficiales dentro del juego.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Jos%C3%A9_Javier_Esparza_Abaurrea"),
        Politico("ibarrola", "Cristina Ibarrola", "UPN", R.drawable.ibarrola,
            "Cristina Ibarrola es una médica y política vinculada a Unión del Pueblo Navarro. Fue alcaldesa de Pamplona entre junio y diciembre de 2023. Su trayectoria profesional incluye la medicina, la gestión sanitaria y la docencia. En esta aplicación comparte formación con Javier Esparza, con datos de debate independientes para cada persona.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Cristina_Ibarrola"),
        Politico("luna", "Javier Luna", "PACMA", R.drawable.luna,
            "Javier Luna es un empresario y activista cordobés vinculado a la defensa de los animales. Asumió la presidencia de PACMA en octubre de 2021 y fue reelegido en la renovación de la junta directiva de marzo de 2024. Su actividad pública incluye la organización del partido y su participación en candidaturas electorales.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://pacma.es/noticias/pacma-elige-nueva-junta-directiva-y-se-refuerza-para-afrontar-las-europeas/"),
        Politico("barquero", "Silvia Barquero", "PACMA", R.drawable.barquero,
            "Silvia Barquero es una activista española por los derechos de los animales. Fue presidenta de PACMA y ha participado en iniciativas para llevar la protección animal al debate público y político. Se incluye como figura histórica de la formación, junto a Javier Luna, sin indicar que ambos ocupen simultáneamente la presidencia.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Silvia_Barquero"),
        Politico("baldovi", "Joan Baldoví", "Compromís", R.drawable.baldovi,
            "Joan Baldoví es un maestro y político valenciano vinculado a Compromís. Fue alcalde de Sueca entre 2007 y 2011 y diputado en el Congreso hasta mayo de 2023. Después pasó a las Cortes Valencianas, donde ejerció como portavoz. Su trayectoria reúne experiencia municipal, autonómica y estatal.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Joan_Baldov%C3%AD"),
        Politico("oltra", "Mónica Oltra", "Compromís", R.drawable.oltra,
            "Mónica Oltra es una abogada y política vinculada a Compromís. Fue vicepresidenta, portavoz y consejera de Igualdad y Políticas Inclusivas de la Generalitat Valenciana entre 2015 y 2022. También fue diputada en las Cortes Valencianas. En el juego se incluye como una figura conocida de la formación, junto a Joan Baldoví.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/M%C3%B3nica_Oltra"),
        Politico("garcia", "Mónica García", "Más Madrid", R.drawable.garcia,
            "Mónica García Gómez es una médica anestesióloga y política vinculada a Más Madrid. Fue diputada en la Asamblea de Madrid entre 2015 y 2023 y candidata a la presidencia de la Comunidad de Madrid. En noviembre de 2023 asumió el Ministerio de Sanidad. Su perfil combina una trayectoria sanitaria y responsabilidades de representación política.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/M%C3%B3nica_Garc%C3%ADa_G%C3%B3mez"),
        Politico("maestre", "Rita Maestre", "Más Madrid", R.drawable.maestre,
            "Rita Maestre es una politóloga y política vinculada a Más Madrid. Fue portavoz del Gobierno del Ayuntamiento de Madrid entre junio de 2015 y junio de 2019. En 2023 se presentó como candidata a la alcaldía por Más Madrid-Verdes Equo. Su actividad pública se ha desarrollado especialmente en el ámbito municipal.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Rita_Maestre"),
        Politico("maillo", "Antonio Maíllo", "Izquierda Unida", R.drawable.maillo,
            "Antonio Maíllo es un filólogo, profesor de educación secundaria y político vinculado a Izquierda Unida. Su actividad docente se ha centrado en el latín. Después de asumir responsabilidades en la organización andaluza, pasó a ejercer como coordinador federal de IU en 2024. En la aplicación comparte formación con Alberto Garzón.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Antonio_Ma%C3%ADllo"),
        Politico("garzon", "Alberto Garzón", "Izquierda Unida", R.drawable.garzon,
            "Alberto Garzón es un economista, escritor y expolítico español vinculado a Izquierda Unida. Fue diputado entre 2011 y 2023 y coordinador federal de la formación entre 2016 y 2023. También ejerció como ministro de Consumo entre enero de 2020 y noviembre de 2023. Se incluye como figura histórica del partido.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Alberto_Garz%C3%B3n"),
        Politico("arrimadas", "Inés Arrimadas", "Ciudadanos", R.drawable.arrimadas,
            "Inés Arrimadas es una abogada y expolítica vinculada a Ciudadanos. Ejerció como presidenta de la formación entre 2020 y 2023 y como diputada por Barcelona en el Congreso. Con anterioridad fue diputada en el Parlamento de Cataluña. En junio de 2023 anunció su salida de la política activa; aquí forma parte del catálogo histórico del juego.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/In%C3%A9s_Arrimadas"),
        Politico("rivera", "Albert Rivera", "Ciudadanos", R.drawable.rivera,
            "Albert Rivera es un abogado y expolítico español. Presidió Ciudadanos desde su fundación hasta noviembre de 2019. Fue diputado en el Parlamento de Cataluña entre 2006 y 2015 y posteriormente en el Congreso. En la práctica aparece junto a Inés Arrimadas como una pareja de figuras históricas, no como una dirección actual de la formación.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Albert_Rivera"),
        Politico("sabater", "Dolors Sabater", "CUP", R.drawable.sabater,
            "Dolors Sabater es una docente y política catalana. Fue alcaldesa de Badalona entre 2015 y 2018 después de concurrir por Guanyem Badalona en Comú. En 2021 encabezó la candidatura de la CUP a la presidencia de la Generalitat. Por esa relación electoral se incluye junto a Mireia Vehí en la pareja del juego.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Dolors_Sabater"),
        Politico("vehi", "Mireia Vehí", "CUP", R.drawable.vehi,
            "Mireia Vehí es una socióloga y política vinculada a la CUP. Fue diputada por Barcelona en el Congreso entre diciembre de 2019 y agosto de 2023. Con anterioridad había sido diputada en el Parlamento de Cataluña por CUP-Crida Constituent. Su trayectoria comprende la representación en dos cámaras parlamentarias distintas.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Mireia_Veh%C3%AD"),
        Politico("guitarte", "Tomás Guitarte", "Teruel Existe", R.drawable.guitarte,
            "Tomás Guitarte es un arquitecto y político vinculado a Teruel Existe. En las elecciones generales de noviembre de 2019 se convirtió en el primer diputado de la plataforma en el Congreso. Su trayectoria política está ligada a la representación del territorio turolense y a la participación institucional de este movimiento ciudadano.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Tom%C3%A1s_Guitarte"),
        Politico("martin", "Beatriz Martín Larred", "Teruel Existe", R.drawable.martin,
            "Beatriz Martín Larred fue senadora por Teruel durante la XIV legislatura, elegida en noviembre de 2019 por Teruel Existe. Su actividad parlamentaria incluyó iniciativas relacionadas con los servicios públicos y las necesidades del medio rural. Se incorpora junto a Tomás Guitarte como una de las representantes de la plataforma.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://www.senado.es/web/composicionorganizacion/senadores/composicionsenado/fichasenador/index.html?id1=19026&legis=14"),
        Politico("revilla", "Miguel Ángel Revilla", "PRC", R.drawable.revilla,
            "Miguel Ángel Revilla es un economista, profesor, escritor y político vinculado al Partido Regionalista de Cantabria. Fue presidente de Cantabria entre 2003 y 2011 y de nuevo entre 2015 y 2023. Su trayectoria pública está especialmente relacionada con el regionalismo cántabro y las instituciones de esa comunidad autónoma.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Miguel_%C3%81ngel_Revilla"),
        Politico("fernandez", "Paula Fernández Viaña", "PRC", R.drawable.fernandez,
            "Paula Fernández Viaña es una política del Partido Regionalista de Cantabria. En noviembre de 2018 asumió la secretaría de Organización de la formación. Entre 2019 y 2023 fue consejera de Presidencia, Interior, Justicia y Acción Exterior del Gobierno de Cantabria. En el catálogo comparte formación con Miguel Ángel Revilla.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Paula_Fern%C3%A1ndez_Via%C3%B1a"),
        Politico("izquierdo", "Alberto Izquierdo", "Partido Aragonés", R.drawable.izquierdo,
            "Alberto Izquierdo es un político del Partido Aragonés. Su actividad incluye la alcaldía de Gúdar y responsabilidades en la organización de su formación. Fue elegido presidente del PAR en 2025 y encabezó su candidatura autonómica en 2026. En esta aplicación aparece junto a Arturo Aliaga como una de las figuras del regionalismo aragonés.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://www.partidoaragones.es/el-partido-aragones-concurrira-en-solitario-a-las-elecciones-autonomicas-con-alberto-izquierdo-como-candidato/"),
        Politico("aliaga", "Arturo Aliaga", "Partido Aragonés", R.drawable.aliaga,
            "Arturo Aliaga es un político español vinculado al Partido Aragonés. Su trayectoria incluye la presidencia del PAR y responsabilidades en el Gobierno de Aragón. Ejerció como vicepresidente y consejero de Industria, Competitividad y Desarrollo Empresarial. Se incorpora como una figura conocida de la formación junto a Alberto Izquierdo.\n\nEn 29N Fantasy, sus intervenciones se registran con una fecha, un partido rival y uno o varios temas. La ficha calcula el total de debates y la media a partir de los datos guardados. Los puntos pertenecen a una simulación educativa y no representan votos ni una evaluación de su trayectoria real.",
            "https://es.wikipedia.org/wiki/Arturo_Aliaga")
    )

    val participaciones = listOf(
        Participacion(1, "feijoo", "PP", listOf("Economía", "Vivienda"), 72, "PSOE", fecha("03/11/2026")),
        Participacion(2, "ayuso", "PP", listOf("Sanidad", "Educación"), 65, "Más Madrid", fecha("04/11/2026")),
        Participacion(3, "sanchez", "PSOE", listOf("Economía"), 78, "PP", fecha("05/11/2026")),
        Participacion(4, "diaz", "Sumar", listOf("Vivienda", "Economía"), 68, "Vox", fecha("06/11/2026")),
        Participacion(5, "abascal", "Vox", listOf("Economía"), 62, "Sumar", fecha("07/11/2026")),
        Participacion(6, "montero", "Podemos", listOf("Educación", "Vivienda"), 74, "PP", fecha("08/11/2026")),
        Participacion(7, "feijoo", "PP", listOf("Sanidad"), 80, "Sumar", fecha("09/11/2026")),
        Participacion(8, "sanchez", "PSOE", listOf("Medio ambiente"), 70, "Vox", fecha("10/11/2026")),
        Participacion(9, "ayuso", "PP", listOf("Vivienda"), 71, "PSOE", fecha("11/11/2026")),
        Participacion(10, "feijoo", "PP", listOf("Educación"), 67, "Podemos", fecha("12/11/2026")),
        Participacion(11, "koldo", "PSOE", listOf("Economía", "Vivienda"), 75, "PP", fecha("12/11/2026")),
        Participacion(12, "garriga", "Vox", listOf("Economía", "Vivienda"), 82, "PSOE", fecha("13/11/2026")),
        Participacion(13, "urtasun", "Sumar", listOf("Economía", "Vivienda"), 89, "PSOE", fecha("14/11/2026")),
        Participacion(14, "belarra", "Podemos", listOf("Economía", "Vivienda"), 65, "PSOE", fecha("01/11/2026")),
        Participacion(15, "rufian", "ERC", listOf("Economía", "Vivienda"), 72, "PSOE", fecha("02/11/2026")),
        Participacion(16, "junqueras", "ERC", listOf("Economía", "Vivienda"), 79, "PSOE", fecha("03/11/2026")),
        Participacion(17, "puigdemont", "Junts", listOf("Economía", "Vivienda"), 86, "PSOE", fecha("04/11/2026")),
        Participacion(18, "turull", "Junts", listOf("Economía", "Vivienda"), 62, "PSOE", fecha("05/11/2026")),
        Participacion(19, "esteban", "PNV", listOf("Economía", "Vivienda"), 69, "PSOE", fecha("06/11/2026")),
        Participacion(20, "ortuzar", "PNV", listOf("Economía", "Vivienda"), 76, "PSOE", fecha("07/11/2026")),
        Participacion(21, "otegi", "EH Bildu", listOf("Economía", "Vivienda"), 83, "PSOE", fecha("08/11/2026")),
        Participacion(22, "aizpurua", "EH Bildu", listOf("Economía", "Vivienda"), 90, "PSOE", fecha("09/11/2026")),
        Participacion(23, "ponton", "BNG", listOf("Economía", "Vivienda"), 66, "PSOE", fecha("10/11/2026")),
        Participacion(24, "rego", "BNG", listOf("Economía", "Vivienda"), 73, "PSOE", fecha("11/11/2026")),
        Participacion(25, "clavijo", "Coalición Canaria", listOf("Economía", "Vivienda"), 80, "PSOE", fecha("12/11/2026")),
        Participacion(26, "valido", "Coalición Canaria", listOf("Economía", "Vivienda"), 87, "PSOE", fecha("13/11/2026")),
        Participacion(27, "rodriguez", "Nueva Canarias", listOf("Economía", "Vivienda"), 63, "PSOE", fecha("14/11/2026")),
        Participacion(28, "campos", "Nueva Canarias", listOf("Economía", "Vivienda"), 70, "PSOE", fecha("01/11/2026")),
        Participacion(29, "esparza", "UPN", listOf("Economía", "Vivienda"), 77, "PSOE", fecha("02/11/2026")),
        Participacion(30, "ibarrola", "UPN", listOf("Economía", "Vivienda"), 84, "PSOE", fecha("03/11/2026")),
        Participacion(31, "luna", "PACMA", listOf("Economía", "Vivienda"), 60, "PSOE", fecha("04/11/2026")),
        Participacion(32, "barquero", "PACMA", listOf("Economía", "Vivienda"), 67, "PSOE", fecha("05/11/2026")),
        Participacion(33, "baldovi", "Compromís", listOf("Economía", "Vivienda"), 74, "PSOE", fecha("06/11/2026")),
        Participacion(34, "oltra", "Compromís", listOf("Economía", "Vivienda"), 81, "PSOE", fecha("07/11/2026")),
        Participacion(35, "garcia", "Más Madrid", listOf("Economía", "Vivienda"), 88, "PSOE", fecha("08/11/2026")),
        Participacion(36, "maestre", "Más Madrid", listOf("Economía", "Vivienda"), 64, "PSOE", fecha("09/11/2026")),
        Participacion(37, "maillo", "Izquierda Unida", listOf("Economía", "Vivienda"), 71, "PSOE", fecha("10/11/2026")),
        Participacion(38, "garzon", "Izquierda Unida", listOf("Economía", "Vivienda"), 78, "PSOE", fecha("11/11/2026")),
        Participacion(39, "arrimadas", "Ciudadanos", listOf("Economía", "Vivienda"), 85, "PSOE", fecha("12/11/2026")),
        Participacion(40, "rivera", "Ciudadanos", listOf("Economía", "Vivienda"), 61, "PSOE", fecha("13/11/2026")),
        Participacion(41, "sabater", "CUP", listOf("Economía", "Vivienda"), 68, "PSOE", fecha("14/11/2026")),
        Participacion(42, "vehi", "CUP", listOf("Economía", "Vivienda"), 75, "PSOE", fecha("01/11/2026")),
        Participacion(43, "guitarte", "Teruel Existe", listOf("Economía", "Vivienda"), 82, "PSOE", fecha("02/11/2026")),
        Participacion(44, "martin", "Teruel Existe", listOf("Economía", "Vivienda"), 89, "PSOE", fecha("03/11/2026")),
        Participacion(45, "revilla", "PRC", listOf("Economía", "Vivienda"), 65, "PSOE", fecha("04/11/2026")),
        Participacion(46, "fernandez", "PRC", listOf("Economía", "Vivienda"), 72, "PSOE", fecha("05/11/2026")),
        Participacion(47, "izquierdo", "Partido Aragonés", listOf("Economía", "Vivienda"), 79, "PSOE", fecha("06/11/2026")),
        Participacion(48, "aliaga", "Partido Aragonés", listOf("Economía", "Vivienda"), 86, "PSOE", fecha("07/11/2026"))
    )

    fun politico(id: String): Politico {
        for (politico in politicos) {
            if (politico.id == id) {
                return politico
            }
        }
        throw NoSuchElementException("No existe un político con id: $id")
    }

    fun color(partido: String): Long {
        for (opcion in partidos) {
            if (opcion.nombre == partido) {
                return opcion.color
            }
        }
        throw NoSuchElementException("No existe el partido: $partido")
    }
}

// El calendario de Compose utiliza UTC; usamos la misma zona al leer y mostrar.
fun formatoFecha(): SimpleDateFormat {
    val formato = SimpleDateFormat("dd/MM/yyyy", Locale("es", "ES"))
    formato.timeZone = TimeZone.getTimeZone("UTC")
    return formato
}

fun fecha(texto: String): Long {
    val fechaConvertida = formatoFecha().parse(texto)
    if (fechaConvertida == null) {
        throw IllegalArgumentException("Fecha no válida: $texto")
    }
    return fechaConvertida.time
}

fun mostrarFecha(valor: Long): String {
    val fecha = Date(valor)
    return formatoFecha().format(fecha)
}
