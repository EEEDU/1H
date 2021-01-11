package BuclesAnidados;
/*
 *Metodo de ordenacion por insercion directa
 */

public class Ejercicio044 {

	public static void main(String[] args) {
		
		int vector[] = {25, 2, 73, 81, 4, 33};
		int x, posMin = 0;

		for (int i = 0; i < vector.length; i++) {
			for (int j = i; j < vector.length; j++) {
				
				if (vector[j] < vector[posMin]) {
					posMin = j;
				}
				
			}
			
			x = vector[i];
			vector[i] = vector[posMin];
			vector[posMin] = x; 
			
		}
		
		for (int i = 0; i < vector.length; i++) {
			System.out.println(vector[i]);
		}
		
	}

}
