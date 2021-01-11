package Recursividad;
//Ley D'Hondt

public class Ejercicio097 {

	public static void main(String[] args) {
		final int ESCAÑOS = 7;
		String[] partidos = { "PP", "PSOE", "Podemos", "Ciudadanos" };
		int[] votos = { 10000, 8000, 7000, 6000 };
		int[] nEscaños = { 1, 1, 1, 1 };
		int posMax = 0;

		for (int i = 0; i < ESCAÑOS; i++) {
			posMax = 0;
			for (int j = 0; j < votos.length; j++) {
				if (votos[j] / nEscaños[j] > votos[posMax] / nEscaños[posMax]) {
					posMax = j;
				}
			}
			nEscaños[posMax]++;
		}

		for (int i = 0; i < nEscaños.length; i++) {
			nEscaños[i]--;
			System.out.println(nEscaños[i] + " escaños tiene el " + partidos[i]);
		}
	}
}
