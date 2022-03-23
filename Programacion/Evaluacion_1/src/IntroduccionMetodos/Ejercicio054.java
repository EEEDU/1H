package IntroduccionMetodos;
/*
 * Dando una tabla, crea una funcion que reciba la tabla y un entero y sea capaz de multiplicar todos los elementos de la tabla por el entero.
 */

public class Ejercicio054 {

	public static void main(String[] args) {
		int tabla[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int multiplicador = 2;
		multiplicar(tabla, multiplicador);

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.printf("%d  ", tabla[i][j]);
			}
			System.out.println();
		}
	}

	public static void multiplicar(int[][] tabla, int numero) {
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				tabla[i][j] *= numero;
			}
		}

	}
}
