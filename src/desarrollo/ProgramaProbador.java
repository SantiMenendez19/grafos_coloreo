package desarrollo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProgramaProbador {

	public static boolean probador(String archEntrada, String archSalida) throws FileNotFoundException {

		GrafoNDNP grafo = new GrafoNDNP(archEntrada);
		Scanner entrada = new Scanner(new File(archSalida));

		int cantNodosColoreados = entrada.nextInt();
		int cantColores = entrada.nextInt();
		if (cantColores > cantNodosColoreados) {
			System.out.println("ERROR: Hay mas colores que nodos");
			entrada.close();
			return false;
		}

		Nodo[] nodosPintados = new Nodo[cantNodosColoreados];
		for (int i = 0; i < cantNodosColoreados; i++) {

			nodosPintados[i] = new Nodo(entrada.nextInt() - 1);
			nodosPintados[i].setColor(entrada.nextInt());
		}
		entrada.close();

		// Chequeo que no hayan nodos sin pintar

		for (int i = 0; i < nodosPintados.length; i++) {
			if (nodosPintados[i].getColor() == 0) {
				System.out.println("ERROR: Hay nodos sin pintar");
				return false;
			}
		}

		// Chequeo que nodos adyacentes no tengan el mismo color

		for (int i = 0; i < nodosPintados.length - 1; i++) {
			for (int j = i + 1; j < nodosPintados.length; j++) {
				if (grafo.matrizAdyacencia.getFC(nodosPintados[i].getNroNodo(), nodosPintados[j].getNroNodo())
						&& nodosPintados[i].getColor() == nodosPintados[j].getColor()) {
					System.out.println("ERROR: Hay nodos adyacentes con el mismo color");
					return false;
				}
			}
		}

		// Cheque que no hayan nodos coloreados dos veces

		for (int i = 0; i < nodosPintados.length - 1; i++) {
			for (int j = i + 1; j < nodosPintados.length; j++) {
				if (nodosPintados[i].getNroNodo() == nodosPintados[j].getNroNodo()) {
					System.out.println("EEROR: Un nodo aparece pintado dos veces");
					return false;
				}
			}
		}

		return true;
	}

}
