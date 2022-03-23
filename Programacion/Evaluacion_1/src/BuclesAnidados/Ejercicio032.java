package BuclesAnidados;
/*
 * Cine con cuatro salas, se guarda en un array bidimensional las entradas que se venden cada dia de la semana
 * Mostrar por pantalla cuando fue el dia que mas vendimos y cual el que menos
 */

public class Ejercicio032 {

	public static void main(String[] args) {
		
		int tabla[][] = {{10, 20, 30, 40, 45, 12, 74}, {50, 60, 70, 80, 85, 65, 43}, {90, 100, 110, 120, 125, 108, 190}, {109, 200, 170, 160, 111, 190, 201}};
		String prod[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		int acum[] = {0, 0, 0, 0, 0, 0, 0};
		int max = 0, min = 0;
		
		for (int i = 0; i < tabla.length; i++) {
			
			for (int j = 0; j < tabla[i].length; j++) {
				acum[j] += tabla[i][j];
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
		
		System.out.println("El dia que mas gente vienes es el " + prod[max] + " y vinen " + acum[max]);
		System.out.println("El dia que menos gente vienes es el " + prod[min] + " y vienen " + acum[min]);

	}

}
