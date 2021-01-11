package BuclesAnidados;
/*
 * Tenemos tabla1 y hay que mostrar su transpuesta en tabla2
 */

public class Ejercicio038 {

	public static void main(String[] args) {
		
		int tabla1[][] = {{1, 2, 3, 4},
						  {5, 6, 7, 8},
						  {9, 10, 11, 12},
						  {13, 14, 15, 16}};
		int tabla2[][] = new int[4][4]; //instanciar es reservar memoria; new es una direccion de memoria
		
		for (int i = 0; i < tabla1.length; i++) {
			for (int j = 0; j < tabla1[i].length; j++) {
				
				tabla2[j][i] = tabla1[i][j];
				
			}
		}
		
		for (int i = 0; i < tabla2.length; i++) {
			for (int j = 0; j < tabla2[i].length; j++) {
				
				System.out.print(tabla2[i][j] + " ");
				
			}
			System.out.println();
		}
		
	}

}
