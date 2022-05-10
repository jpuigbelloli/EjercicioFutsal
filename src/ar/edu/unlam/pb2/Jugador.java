package ar.edu.unlam.pb2;

public class Jugador {

	private String nombre;
	private Integer camiseta, edad, golAFavor;
	private Double valor;

	public Jugador(String nombre, Integer camiseta, Double valor, Integer edad) {
		this.nombre = nombre;
		this.camiseta = camiseta;
		this.valor = valor;
		this.edad = edad;
		golAFavor = 0;
	}

	public Double getValor() {
		return valor;
	}

	public Integer getEdad() {
		return edad;
	}

	public void sumarGolAFavor() {
		golAFavor++;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public String toString() {
		return nombre + ", camiseta=" + camiseta + ", edad=" + edad + ", golAFavor=" + golAFavor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((camiseta == null) ? 0 : camiseta.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (camiseta == null) {
			if (other.camiseta != null)
				return false;
		} else if (!camiseta.equals(other.camiseta))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
