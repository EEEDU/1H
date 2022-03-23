package BuclesAnidados;
/*
 * Mostrar por pantalla que peli es la mas vista y cuanto a vendido y cual es la menos
 */

public class Ejercicio033 {

	public static void main(String[] args) {
		
		int salas[][] = {{10, 20, 30, 40, 45, 12, 74}, {50, 60, 70, 80, 85, 65, 43}, {90, 100, 110, 120, 125, 108, 190}, {109, 200, 170, 160, 111, 190, 201}};
		String peli[] = {"Peli1", "Peli2", "Peli3", "Peli4"};
		int acum[] = {0, 0, 0, 0};
		int max = 0, min = 0;
		
		for (int i = 0; i < salas.length; i++) {
			
			for (int j = 0; j < salas[i].length; j++) {
				acum[i] += salas[i][j];
			}
			
		}
		
		for (int i = 1; i < acum.length; i++) {
			
			if (acum[max] < acum[i]) {
				max = i;
			}
			
			else if (acum[min] > acum[i]) {
				min = i;
			}
			
		}
		
		System.out.printf("La peli más vista es la %s y se vendieron %d entradas \n", peli[max], acum[max]);
		System.out.printf("La peli menos vista es la %s y se vendieron %d entradas \n", peli[min], acum[min]);
		
	}

}
