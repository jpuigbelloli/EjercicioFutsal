package ar.edu.unlam.pb2;

public class Equipo {

	private String nombre;
	private Jugador jugadores[];
	private Integer cantidadDeJugadoresMaximo, cantidadDeJugadoresAgregados, golesTotales;

	public Equipo(String nombre, Integer cantidadDeJugadoresMaximo) {
		this.nombre = nombre;
		this.cantidadDeJugadoresMaximo = cantidadDeJugadoresMaximo;
		this.cantidadDeJugadoresAgregados = 0;
		jugadores = new Jugador[cantidadDeJugadoresMaximo];
		golesTotales = 0;
	}

	public boolean agregarJugador(String nombre, Integer numeroCamiseta, Double valor, Integer edad) {
		Jugador candidatoAFichar = new Jugador(nombre, numeroCamiseta, valor, edad);
		if (cantidadDeJugadoresAgregados < cantidadDeJugadoresMaximo) {
			for (int i = 0; i < jugadores.length; i++) {
				if (jugadores[i] == null) {
					jugadores[i] = candidatoAFichar;
					cantidadDeJugadoresAgregados++;
					return true;
				}
			}
		}
		return false;
	}

	public Integer getCantidadDeJugadoresAgregados() {
		return cantidadDeJugadoresAgregados;
	}

	public double getPrecioTotalEquipo() {
		double valorDelEquipoAcumulado = 0.0;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				valorDelEquipoAcumulado += jugadores[i].getValor();
			}
		}
		return valorDelEquipoAcumulado;
	}

	public double getPromedioEdadEquipo() {
		double edadPromedioDelEquipoAcumulado = 0.0;
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i] != null) {
				edadPromedioDelEquipoAcumulado += jugadores[i].getEdad();

			}
		}
		return (edadPromedioDelEquipoAcumulado / jugadores.length);
	}

	public Jugador getJugadorSegunOrdenDelFichaje(Integer ordenDeFichaje) {
		return jugadores[ordenDeFichaje];
	}

	public void sumargolesTotales() {
		golesTotales++;
	}

	public Integer getGolesTotales() {
		return golesTotales;
	}

	@Override
	public String toString() {
		return nombre + " " + golesTotales;
	}

}
