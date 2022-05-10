package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Partido {
	Equipo local, visitante;
	List<Gol> goles = new ArrayList<Gol>();
	List<Jugador> amonestados = new ArrayList<Jugador>();
	Set<Jugador> expulsados = new HashSet<Jugador>();

	public Partido(Equipo local, Equipo visitante) {
		this.local = local;
		this.visitante = visitante;
	}

	public String marcarGol(Equipo equipo, Jugador jugador) {

		Gol nuevoGol = new Gol(jugador);
		goles.add(nuevoGol);
		equipo.sumargolesTotales();
		jugador.sumarGolAFavor();
		return nuevoGol.getAutor().getNombre() + " ha marcado el gol a los 00:15 minutos";
	}

	public String amonestacionDeJugadores(Jugador jugador) {
		String mensaje = "";
		if (amonestados.contains(jugador)) {
			return expulsionDeJugadores(jugador);
		} else {
			amonestados.add(jugador);
			mensaje = "Se ha amonestado a " + jugador.getNombre() + " a los 66min";
			return mensaje;
		}
	}

	public String expulsionDeJugadores(Jugador jugador) {
		String mensaje = "";
		if (expulsados.contains(jugador)) {
			return "Este jugador ya fue expulsado del partido ahora debe abandonar la cancha";
		} else if (amonestados.contains(jugador)) {
			amonestados.remove(jugador);
			expulsados.add(jugador);
			mensaje = "Se ha expulsado a " + jugador.getNombre() + " por doble amonestación a los 41 min";
			return mensaje;
		} else {
			expulsados.add(jugador);
			mensaje = "Se ha expulsado a " + jugador.getNombre() + " por amonestación directa los 41 min";
			return mensaje;
		}
	}

	@Override
	public String toString() {
		return "Local=" + local + ", Visitante=" + visitante + "\n Goles=\n" + goles + "\n Amonestados=\n" + amonestados
				+ "\n Expulsados=\n" + expulsados;
	}

}
