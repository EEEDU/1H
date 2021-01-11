package BuclesAnidados;
/*
 * Igual que el Ejercicio030 pero utilizando una variable acumuladora en mede un vector
 */
public class Ejercicio030b {

	public static void main(String[] args) {
		
		int tabla[][] = {{10, 20, 30, 40, 45}, {50, 60, 70, 80, 85}, {90, 100, 110, 120, 125}};
		String prod[] = {"Naranjas", "Peras", "Manzanas"};
		int acum = 0;
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				acum += tabla[i][j];
			}
			
			System.out.println("Se han vendido " + acum + " kilogramos de " + prod[i]);
			
			acum = 0;
		}


	}

}
