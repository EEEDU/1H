package IntroduccionMetodos;
/*
 * Crear un metodo que le das la tabla de kilos y te calcula la suma
 */

public class Ejercicio057 {

	public static void main(String[] args) {
		int kilos[][] = { { 5, 6, 4, 8, 9, 10, 2 }, { 4, 4, 8, 4, 5, 9, 11 } };
		String nombre[] = { "Peras", "Manzanas" };

		int total[] = sumaKilos(kilos);

		for (int i = 0; i < kilos.length; i++) {
			System.out.printf("Se han vendido %d kilos de %s en toda la semana \n", total[i], nombre[i]);
		}
	}

	public static int[] sumaKilos(int[][] tabla) {
		int[] acum = new int[tabla.length];

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				acum[i] += tabla[i][j];
			}
		}

		return acum;
	}
}
