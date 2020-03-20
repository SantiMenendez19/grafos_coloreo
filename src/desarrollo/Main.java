package desarrollo;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter("analisisRegular75.txt"));
		GrafoNPGenerador gen = new GrafoNPGenerador();
		int cant1, cant2, cant3;
		pw.println("Aleatorio | Matula | WellshPowell");
//		gen.aleatorioConPorcentajeAdyacencia(600, 0.9);
//		gen.aleatorioConPorcentajeAdyacencia(600, 0.4);
//		gen.aleatorioConPorcentajeAdyacencia(600, 0.6);
//		gen.regularConPorcentajeAdyacencia(1000, 0.5);
		gen.regularConPorcentajeAdyacencia(1000, 0.75);
		GrafoNDNP g1 = new GrafoNDNP("grafo.in");
		for (int i = 0; i < 10000; i++) {
			//System.out.println("Corrida : " + (i+1));
			cant1 = g1.secuencialAleatorio();
			cant2 = g1.matula();
			cant3 = g1.wellshPowell();
			if (ProgramaProbador.probador("grafo.in", "coloreadoWellshPowell.out") && 
					ProgramaProbador.probador("grafo.in", "coloreadoSecuencialAleatorio.out") &&
					ProgramaProbador.probador("grafo.in", "coloreadoMatula.out")) {
				//System.out.println("El coloreo es correcto");
				pw.println(cant1 + " | " + cant2 + " | " + cant3  ); 
			} else {
				System.out.println("El coloreo No fue correcto");
				break;
			}
		}
		pw.close();

	}

}
