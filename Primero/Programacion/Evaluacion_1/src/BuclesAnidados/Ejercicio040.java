package BuclesAnidados;
/*
 * Intercambiar las diagonales pricipales en una unica tabla cuadrada
 */

public class Ejercicio040 {

	public static void main(String[] args) {
		
		int tabla[][] = {{1, 2, 3, 4},
						{5, 6, 7, 8},
						{9, 10, 11, 12},
						{13, 14, 15, 16}}; 
		int x;
		
		for (int i = 0; i < tabla.length; i++) {
			x = tabla[i][i];
			tabla[i][i] = tabla[i][tabla[i].length - (i + 1)];
			tabla[i][tabla[i].length - (i + 1)] = x;
		}
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				
				System.out.print(tabla[i][j] + " ");
				
			}
			
			System.out.println();
		}
	}

}
