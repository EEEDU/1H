package BuclesAnidados;
/*
 * Con una tabla los numeros negativos se cambain a positivos y los positivos se multiplican por 5
 */

public class Ejercicio027 {

	public static void main(String[] args) {

		int tabla[][] = {{-10, 20, -30, 40}, {-50, 60, -70, 80}, {90, -100, -110, 120}};
		
		for (int i = 0; i < tabla.length; i++) {
			
			System.out.println("Fila número " + (i + 1) + ": ");
			
			for (int j = 0; j < tabla[0].length; j++) {
				
				if (tabla[i][j] > 0) {
					tabla[i][j] *= 5;
				}
				else if(tabla[i][j] < 0) {
					tabla[i][j] *= -1;
				}
				
				System.out.printf("%d \n", tabla[i][j]);
				
			}
			
		}

	}

}
