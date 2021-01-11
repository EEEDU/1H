package BuclesAnidados;
/*
 * Igual que Ejercicio038 pero sin necesidad de tabla2
 */

public class Ejercicio039 {

	public static void main(String[] args) {
		int tabla1[][] = {{1, 2, 3, 4},
				  		  {5, 6, 7, 8},
				  		  {9, 10, 11, 12},
				  		  {13, 14, 15, 16}};
		int x; 
		
		for (int i = 0; i < tabla1.length; i++) {
			for (int j = 0 ; j < i; j++) {
				
				x = tabla1[j][i];
				tabla1[j][i] = tabla1[i][j];
				tabla1[i][j] = x;
			
			}
		}
		
		for (int i = 0; i < tabla1.length; i++) {
			for (int j = 0; j < tabla1[i].length; j++) {
				
				System.out.print(tabla1[i][j] + " ");
				
			}
			System.out.println();
		}
		
		
	}

}
