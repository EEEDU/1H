package BuclesAnidados;
/*
 * Metodo de ordenacion por vectores, seleccion directa.
 */

public class Ejercicio045 {

	public static void main(String[] args) {
		
		int vector[] = {15, 12, 3, 81, 33, 4};
		int x;
			
		for (int j = 1; j < vector.length; j++) {
			
			int i = j;
					
			while ((i > 0) && (vector[i] < vector[i - 1])) {
				x = vector[i];
				vector[i] = vector[i - 1];
				vector[i - 1] = x;
				 
				i--;	
			}
			
		}
		
		for (int j = 0; j < vector.length; j++) {
			System.out.println(vector[j]);
		}
	}
	
}
