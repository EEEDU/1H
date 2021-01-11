package IntroduccionMetodos;
/*
 * Metodo en donde la pasamos una tabla y un numero y multiplique si el numero de la tabla es inferior a 10.
 */

public class Ejercicio058 {

	public static void main(String[] args) {
		int tabla[][] = { { 5, 16, 4, 8, 19, 10, 2 }, { 4, 4, 18, 4, 15, 9, 11 } };
		int numero = 5;

		multiplicar(tabla, numero);

		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				System.out.printf("%d  ", tabla[i][j]);
			}
			System.out.println();
		}
	}

	public static void multiplicar(int[][] tab, int num) {
		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				if (tab[i][j] < 10) {
					tab[i][j] *= 5;
				}
			}
		}
	}
}
