package Recursividad;
//Ley D'Hondt

public class Ejercicio097 {

	public static void main(String[] args) {
		final int ESCA�OS = 7;
		String[] partidos = { "PP", "PSOE", "Podemos", "Ciudadanos" };
		int[] votos = { 10000, 8000, 7000, 6000 };
		int[] nEsca�os = { 1, 1, 1, 1 };
		int posMax = 0;

		for (int i = 0; i < ESCA�OS; i++) {
			posMax = 0;
			for (int j = 0; j < votos.length; j++) {
				if (votos[j] / nEsca�os[j] > votos[posMax] / nEsca�os[posMax]) {
					posMax = j;
				}
			}
			nEsca�os[posMax]++;
		}

		for (int i = 0; i < nEsca�os.length; i++) {
			nEsca�os[i]--;
			System.out.println(nEsca�os[i] + " esca�os tiene el " + partidos[i]);
		}
	}
}
