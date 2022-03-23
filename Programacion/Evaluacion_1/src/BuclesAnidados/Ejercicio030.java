package BuclesAnidados;
/*
 * tabla nos guarda los kg que se han vendido cada dia de la semana cada una de las frutas. 
 * Mostrar cuantos kg de cada fruta hemos vendido.
 */
public class Ejercicio030 {

	public static void main(String[] args) {
		
		int tabla[][] = {{10, 20, 30, 40, 45}, {50, 60, 70, 80, 85}, {90, 100, 110, 120, 125}};
		String prod[] = {"Naranjas", "Peras", "Manzanas"};
		int acum[] = {0, 0, 0};
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {
				acum[i] += tabla[i][j];
			}
		}
		
		for (int i = 0; i < tabla.length; i++) {
			System.out.println("Se han vendido " + acum[i] + " kilogramos de " + prod[i]);
		}

	}

}
