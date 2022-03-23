package BuclesAnidados;
/*
 * Recorremos el contenido de una tabla.
 * Declaramos e instanciamos un vector bidimensional, tabla.
 */

public class Ejercicio026 {

	public static void main(String[] args) {

		int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
		
		for (int i = 0; i < tabla.length; i++) {
			
			for (int j = 0; j < tabla[0].length; j++) {
				System.out.println(tabla[i][j]);
			}
			
		}
			
	}

}
