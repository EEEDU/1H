package BuclesAnidados;
/*
 * Tablas de multiplicar
 */

public class Ejercicio025 {

	public static void main(String[] args) {

		int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		for (int i = 0; i < num.length; i++) {
			
			System.out.println("La tabla del " + num[i]);
			
			for (int j = 1; j <= 10; j++) {				
				System.out.println(num[i] + " * " + j + " = " + num[i] * j);
			}
			
		}
		
	}

}