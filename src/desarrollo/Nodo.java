package desarrollo;

public class Nodo implements Comparable<Nodo> {

	private int nroNodo;
	private int grado;
	private int color;

	public Nodo(int nroNodo) {

		this.nroNodo = nroNodo;
		this.grado = 0;
		this.color = 0;
	}

	public int getNroNodo() {
		return nroNodo;
	}

	public int getGrado() {
		return grado;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public void aumentarGrado() {
		this.grado++;
	}

	@Override
	public int compareTo(Nodo nodo) {
		return nodo.grado - this.grado;
	}
}
