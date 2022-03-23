package BuclesAnidados;
/*
 * Mostrar por pantalla el resultado de multiplicar cada uno de los datos de la tabla por su correspondiente vector
 */

public class Ejercicio028 {

	public static void main(String[] args) {
		
		int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
		int v1[] = {2, 4, 6};
		
		for (int i = 0; i < tabla.length; i++) {
			
			System.out.printf("Los datos numero: %d \n", i + 1);
			
			for (int j = 0; j < tabla[i].length; j++) {	
				System.out.printf("%d * %d = %d \n", tabla[i][j], v1[i], tabla[i][j] * v1[i] );
			}
		}
		
	}

}
