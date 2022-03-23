package SustitucionesChar;
/*
 * Ordenar alfabeticamente los nombres
 * Utilizar el metododo "compareTo"
 */

public class Ejercicio078 {

	public static void main(String[] args) {
		String[] nombres = { "Pepe", "Edu", "Antonio", "Juan" };
		String x;

		for (int i = 0; i < nombres.length; i++) {
			for (int j = nombres.length - 1; j > i; j--) {
				if (nombres[j].compareTo(nombres[j - 1]) < 0) {
					x = nombres[j];
					nombres[j] = nombres[j - 1];
					nombres[j - 1] = x;
				}
			}
		}
		for (int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
		}
	}

}
