package IntroduccionMetodos;
/*
 * Teniendo los kilos que se ha vendido de cada producto cada dia y el precio de cada producto.
 * Averiguar el dinero que hemos conseguido con cada producto cada dia. Pero sin añadir variable
 */

public class Ejercicio055 {

	public static void main(String[] args) {
		int kilos[][] = { { 5, 6, 4, 8, 9, 10, 2 }, { 3, 4, 8, 4, 5, 9, 11 } };
		int precios[] = { 6, 7 };

		ganancias(kilos, precios);

		for (int i = 0; i < kilos.length; i++) {
			for (int j = 0; j < kilos[i].length; j++) {
				System.out.printf("El dia numero %d ha conseguido %d euros del producto %d \n", j + 1,
						kilos[i][j],
						i + 1);
			}
			System.out.println();
		}
	}

	public static void ganancias(int[][] vector, int[] numero) {
		for (int i = 0; i < vector.length; i++) {
			for (int j = 0; j < vector[i].length; j++) {
				vector[i][j] *= numero[i];
			}
		}
	}
}
