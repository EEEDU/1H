package IntroduccionMetodos;
/*
 * Teniendo los kilos que se ha vendido de cada producto cada dia y el precio de cada producto.
 * Averiguar el dinero que hemos conseguido con cada producto cada dia.
 */

public class Ejercicio056 {

	public static void main(String[] args) {
		int kilos[][] = { { 5, 6, 4, 8, 9, 10, 2 }, { 3, 4, 8, 4, 5, 9, 11 } };
		int precios[] = { 6, 7 };

		// No hace falta instanciar ventar[][]
		int ventas[][] = ganancias(kilos, precios);

		for (int i = 0; i < kilos.length; i++) {
			for (int j = 0; j < kilos[i].length; j++) {
				System.out.printf("El dia numero %d ha conseguido %d euros del producto %d \n", j + 1, ventas[i][j],
						i + 1);
			}
			System.out.println();
		}
	}

	public static int[][] ganancias(int[][] vector, int[] numero) {
		int acum[][] = new int[vector.length][vector[0].length];

		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector[i].length; j++) {
				acum[i][j] = vector[i][j] * numero[i];
			}
		}

		return acum;
	}
}
