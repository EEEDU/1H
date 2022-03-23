package BuclesAnidados;
/*
 * Mostrar por pantalla, cuanto hemos cobrado por cada producto y el total de dinero recaudado
 * double = float pero mas grande
 */

public class Ejercicio031 {

	public static void main(String[] args) {

		int tabla[][] = {{10, 20, 30, 40, 45}, {50, 60, 70, 80, 85}, {90, 100, 110, 120, 125}};
		String prod[] = {"Naranjas", "Peras", "Manzanas"};
		double precios[] = {1.5, 2, 0.8};
		double acum = 0;
		double total = 0;
		
		for (int i = 0; i < tabla.length; i++) {
			
			for (int j = 0; j < tabla[i].length; j++) {
				acum += tabla[i][j];
			}
			
			acum *= precios[i];
			System.out.println("El precio de " + prod[i] + " es igual a " + acum + " euros");
			total += acum;
			acum = 0;
		}
		
		System.out.printf("El total del dinero recaudado es de " + total + " euros");
		
	}
	
}
