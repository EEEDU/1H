package BuclesAnidados;
/*
 * Mostrar por pantalla quien ha sacado un 10 y en que asignatura
 */

public class Ejercicio036 {

	public static void main(String[] args) {
		
		int nota[][] = {{1, 2, 10, 4}, {5, 10, 7, 8}, {9, 10, 1, 5}, {3, 10, 10, 5}, {9, 2, 10, 7}};
		String alum[] = {"Alumno1", "Alumno2", "Alumno3", "Alumno4", "Alumno5"};
		String asig[] = {"Asignatura1", "Asignatura2", "Asignatura3", "Asignatura4"};
		
		for (int i = 0; i < nota.length; i++) {
			
			for (int j = 0; j < nota[i].length; j++) {
				
				if (nota[i][j] == 10) {
					System.out.printf("El alumno %s ha sacado un 10 en %s \n", alum[i], asig[j]);
				}
				
			}
			
		}
		
	}

}
