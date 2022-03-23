package IntroduccionMetodos;
/*
 * Utilizando el metodo ordenar del ejercicio050, ordenar cada uno de los vectores que componen la tabla salario 
 */

public class Ejercicio051 {

	public static void main(String[] args) {
		int salario[][] = { { 700, 900, 1300, 800, 1000, 700 }, { 700, 1300, 800, 900, 750, 1450 },
				{ 800, 900, 1200, 850, 850, 1300 }, { 1200, 750, 800, 950, 1200, 800 } };

		// TODO va a preguntar sobre los vectores de una tabla

		for (int i = 0; i < salario.length; i++) {
			ordenar(salario[i]);
			System.out.println("El vector numero " + (i + 1) + ": ");

			for (int j = 0; j < salario[i].length; j++) {
				System.out.println(salario[i][j]);
			}
		}

	}

	public static void ordenar(int[] vector) {
		int x;

		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j] > vector[j + 1]) {
					x = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = x;
				}
			}
		}
	}

}
