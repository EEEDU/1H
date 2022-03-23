package IntroduccionMetodos;
/*
 * Realizar metodo  que le pasa una tabla de enteros y te devuelva la suma de todos los valores.
 */

public class Ejercicio048 {

	public static void main(String[] args) {
		int salario[][] = { { 700, 900, 1300, 800, 1000, 700 }, { 700, 1300, 800, 900, 750, 1450 },
				{ 800, 900, 1200, 850, 850, 1300 }, { 1200, 750, 800, 950, 1200, 800 } };

		System.out.println("La suma de los valores es: " + sumaSalarios(salario));
	}

	public static int sumaSalarios(int[][] tabla) {
		int acum = 0;

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				acum += tabla[i][j];
			}
		}

		return acum;
	}

}
