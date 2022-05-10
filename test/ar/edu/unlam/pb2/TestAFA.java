package ar.edu.unlam.pb2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestAFA {

	@Test
	public void queSePuedanAgregarEquiposAlTorneo() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_EQUIPOS_AGREGADOS_ESPERADOS = 1;

		assertTrue(sistemaAfa.agregarEquipo(river));
		assertEquals(CANTIDAD_EQUIPOS_AGREGADOS_ESPERADOS, sistemaAfa.getCantidadDeEquiposAgregados());
	}

	@Test
	public void queSePuedanAgregarJugadoresALosEquipos() {
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS = 1;

		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
	}

	@Test
	public void queSePuedaCalcularCorrectamenteElValorDelEquipo() {
		Equipo river = new Equipo("River Plate", 5);
		final Integer CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS = 5;
		final Double PRECIO_TOTAL_EQUIPO_ESPERADO = 75000.0;

		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertEquals(CANTIDAD_JUGADORES_AGREGADOS_ESPERADOS, river.getCantidadDeJugadoresAgregados());
		assertEquals(PRECIO_TOTAL_EQUIPO_ESPERADO, river.getPrecioTotalEquipo(), 0.01);
	}

	@Test
	public void queSePuedaCalcularCorrectamenteLaEdadPromedioDelEquipo() {
		Equipo river = new Equipo("River Plate", 5);
		final Double EDAD_PROMEDIO_EQUIPO_ESPERADO = 25.6;

		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 30));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 20));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 25));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 35));
		assertTrue(river.agregarJugador("Enzo", 1, 15000.0, 18));
		assertEquals(EDAD_PROMEDIO_EQUIPO_ESPERADO, river.getPromedioEdadEquipo(), 0.01);
	}

	@Test
	public void queSePuedaCrearUnNuevoPartidoConLocalYVisitante() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);

		assertNotNull(sistemaAfa.registrarNuevoPartido(river, boca));
	}

	@Test
	public void queSeRegistreElAutorYMinutoDelGol() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String AUTOR_Y_MINUTO_ESPERADO = "Enzo ha marcado el gol a los 00:15 minutos";
		final Integer CANTIDAD_DE_GOLES_MARCADOS_ESPERADOS = 1;

		river.agregarJugador("Enzo", 1, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		String nombreDelAutorYMinuto = clasico.marcarGol(river, river.getJugadorSegunOrdenDelFichaje(0));

		assertEquals(AUTOR_Y_MINUTO_ESPERADO, nombreDelAutorYMinuto);
		assertEquals(CANTIDAD_DE_GOLES_MARCADOS_ESPERADOS, river.getGolesTotales());
	}

	@Test
	public void queSePuedaAmonestarUnJugadorYSeaRetornadoJuntoAlMinutoDeLaFalta() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String MENSAJE_ESPERADO = "Se ha amonestado a Enzo a los 66min";
		final Integer CANTIDAD_DE_AMONESTADOS_ESPERADOS = 1;

		river.agregarJugador("Enzo", 5, 15000.0, 30);
		river.agregarJugador("armani", 1, 15000.0, 30);
		river.agregarJugador("casco", 7, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);

		assertEquals(MENSAJE_ESPERADO, clasico.amonestacionDeJugadores(river.getJugadorSegunOrdenDelFichaje(0)));
		assertEquals(CANTIDAD_DE_AMONESTADOS_ESPERADOS, (Integer) clasico.amonestados.size());
	}

	@Test
	public void queCuandoUnJugadorTengaDobleAmonestaciónSeaExpulsadoDelPartido() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String MENSAJE_ESPERADO = "Se ha expulsado a casco por doble amonestación a los 41 min";
		final Integer CANTIDAD_DE_EXPULSADOS_ESPERADOS = 1;
		final Integer CANTIDAD_DE_AMONESTADOS_ESPERADOS = 0;

		river.agregarJugador("Enzo", 5, 15000.0, 30);
		river.agregarJugador("armani", 1, 15000.0, 30);
		river.agregarJugador("casco", 7, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);

		Jugador amonestado = river.getJugadorSegunOrdenDelFichaje(2);
		// primera amonestacion
		clasico.amonestacionDeJugadores(amonestado);

		// segunda amonestacion
		assertEquals(MENSAJE_ESPERADO, clasico.amonestacionDeJugadores(amonestado));
		assertEquals(CANTIDAD_DE_AMONESTADOS_ESPERADOS, (Integer) clasico.amonestados.size());
		assertEquals(CANTIDAD_DE_EXPULSADOS_ESPERADOS, (Integer) clasico.expulsados.size());
	}

	@Test
	public void queNoSePuedaExpulsarDosVecesAlMismoJugadorDentroDelPartido() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final Integer CANTIDAD_DE_EXPULSADOS_ESPERADOS = 1;
		final String MENSAJE_ESPERADO = "Este jugador ya fue expulsado del partido ahora debe abandonar la cancha";

		river.agregarJugador("Enzo", 5, 15000.0, 30);
		river.agregarJugador("armani", 1, 15000.0, 30);
		river.agregarJugador("casco", 7, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);

		Jugador amonestado = river.getJugadorSegunOrdenDelFichaje(2);
		// expulsado por doble amarilla
		clasico.amonestacionDeJugadores(amonestado);
		clasico.amonestacionDeJugadores(amonestado);
		// tratar de volver a expulsar debe
		assertEquals(MENSAJE_ESPERADO, clasico.expulsionDeJugadores(amonestado));
		assertEquals(CANTIDAD_DE_EXPULSADOS_ESPERADOS, (Integer) clasico.expulsados.size());
	}

	@Test
	public void queSePuedaConocerLaListaDeExpulsados() {
		// ya sea por doble amonestacion o por falta directa
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final Integer CANTIDAD_DE_EXPULSADOS_ESPERADOS = 2;

		river.agregarJugador("Enzo", 5, 15000.0, 30);
		river.agregarJugador("casco", 7, 15000.0, 30);
		boca.agregarJugador("rojo", 1, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		Jugador expulsadoUno = river.getJugadorSegunOrdenDelFichaje(1);
		Jugador expulsadoDos = boca.getJugadorSegunOrdenDelFichaje(0);
		clasico.expulsionDeJugadores(expulsadoUno);
		clasico.expulsionDeJugadores(expulsadoDos);

		assertEquals(CANTIDAD_DE_EXPULSADOS_ESPERADOS, (Integer) clasico.expulsados.size());
		assertNotNull(clasico.expulsados);
	}

	@Test
	public void queSePuedaConocerElResumenDelPartido() {
		TorneoFutsal sistemaAfa = new TorneoFutsal(25);
		Equipo river = new Equipo("River", 5);
		Equipo boca = new Equipo("Boca", 5);
		final String MENSAJE_ESPERADO = "Local=River 1, Visitante=Boca 0\n Goles=\n[autor=casco]\n Amonestados=\n[Enzo, camiseta=5, edad=30, golAFavor=0]\n Expulsados=\n[rojo, camiseta=1, edad=30, golAFavor=0]";

		river.agregarJugador("Enzo", 5, 15000.0, 30);
		river.agregarJugador("casco", 7, 15000.0, 30);
		boca.agregarJugador("rojo", 1, 15000.0, 30);
		Partido clasico = sistemaAfa.registrarNuevoPartido(river, boca);
		Jugador goleador = river.getJugadorSegunOrdenDelFichaje(1);
		Jugador amonestado = river.getJugadorSegunOrdenDelFichaje(0);
		Jugador expulsado = boca.getJugadorSegunOrdenDelFichaje(0);
		clasico.marcarGol(river, goleador);
		clasico.amonestacionDeJugadores(amonestado);
		clasico.expulsionDeJugadores(expulsado);

		assertEquals(MENSAJE_ESPERADO, clasico.toString());
	}

}
