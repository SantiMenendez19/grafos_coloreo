package desarrollo;

public class MatrizSimetrica {

	private boolean[] matrizSimetrica;
	private int orden;
	private int tam;

	public MatrizSimetrica(int orden) {
		this.orden = orden;
		this.tam = this.orden * (this.orden - 1) / 2;
		matrizSimetrica = new boolean[this.tam];
	}

	public void setFC(int f, int c, boolean dato) {
		if (f == c)
			return;

		int i;

		if (f > c)
			i = c * this.orden + f - (c * c + 3 * c + 2) / 2;
		else
			i = f * this.orden + c - (f * f + 3 * f + 2) / 2;

		matrizSimetrica[i] = dato;
	}

	public boolean getFC(int f, int c) {
		if (f == c)
			return false;

		int i;

		if (f > c)
			i = c * this.orden + f - (c * c + 3 * c + 2) / 2;
		else
			i = f * this.orden + c - (f * f + 3 * f + 2) / 2;

		return matrizSimetrica[i];
	}

	public int getOrden() {
		return orden;
	}

	public int getTam() {
		return tam;
	}

	public void mostrar() {
		for (int i = 0; i < this.orden; i++) {
			if (this.matrizSimetrica[i])
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}

	}
}
