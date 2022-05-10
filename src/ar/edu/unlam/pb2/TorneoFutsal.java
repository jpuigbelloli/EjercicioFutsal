package ar.edu.unlam.pb2;

public class TorneoFutsal {
	private Integer cantidadDeEquiposMaximos, cantidadDeEquiposAgregados;
	private Equipo equipos[];

	public TorneoFutsal(Integer cantidadDeEquiposMaximos) {
		this.cantidadDeEquiposMaximos = cantidadDeEquiposMaximos;
		equipos = new Equipo[cantidadDeEquiposMaximos];
		cantidadDeEquiposAgregados = 0;
	}

	public Boolean agregarEquipo(Equipo equipoCandidato) {
		if (cantidadDeEquiposAgregados < cantidadDeEquiposMaximos) {
			for (int i = 0; i < equipos.length; i++) {
				if (equipos[i] == null) {
					equipos[i] = equipoCandidato;
					cantidadDeEquiposAgregados++;
					return true;
				}
			}
		}
		return false;
	}

	public Integer getCantidadDeEquiposAgregados() {
		return cantidadDeEquiposAgregados;
	}

	public Partido registrarNuevoPartido(Equipo local, Equipo visitante) {
		Partido nuevoPartido = new Partido(local, visitante);
		return nuevoPartido;
	}

}
