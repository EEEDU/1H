package BuclesAnidados;
/*
 * Metodo de ordenacion de la burbuja
 */

public class Ejercicio043 {

	public static void main(String[] args) {
		
		int vector[] = {25, 2, 73, 81, 4, 33};
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
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
		
	}

}
