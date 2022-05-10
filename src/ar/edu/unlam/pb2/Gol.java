package ar.edu.unlam.pb2;

public class Gol {

	private Jugador autor;

	public Gol(Jugador autor) {
		this.autor = autor;
	}

	public Jugador getAutor() {
		return autor;
	}

	@Override
	public String toString() {
		return "autor=" + autor.getNombre();
	}

}
