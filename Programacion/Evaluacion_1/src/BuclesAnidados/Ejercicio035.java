package BuclesAnidados;
/*
 * Mostrar por pantalla que alumno tiene mas nota y su media y quien tiene menos
 * Mostrar la asignatura con mejor nota y su media y la que menos
 */

public class Ejercicio035 {

	public static void main(String[] args) {

		int nota[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 1, 5}, {3, 6, 7, 5}, {9, 2, 10, 7}};
		String alum[] = {"Alumno1", "Alumno2", "Alumno3", "Alumno4", "Alumno5"};
		String asig[] = {"Asignatura1", "Asignatura2", "Asignatura3", "Asignatura4"};
		int acum[][] = {{0, 0, 0, 0, 0}, {0, 0, 0, 0}}; //acumAlum == acum[0] & acumAsig == acum[1]
		int max[] = {0, 0}, min[] = {0, 0}; //maxAlum == max[0] && maxAsig == max[1]
		
		for (int i = 0; i < nota.length; i++) {
			
			for (int j = 0; j < nota[i].length; j++) {
				acum[0][i] += nota[i][j];
				acum[1][j] += nota[i][j];
			}
			
		}
		
		for (int i = 0; i < acum.length; i++) {
			
			for (int j = 1; j < acum[i].length; j++) {
				
				if (acum[i][max[i]] < acum[i][j]) {
					max[i] = j;
				}
				
				else if (acum[i][min[i]] < acum[i][j]) {
					min[i] = j;
				}
				
			}
		
		}
		
		System.out.printf("El alumno con más nota es %s con una media de %d \n", alum[max[0]], acum[0][max[0]] / acum[0].length);
		System.out.printf("El alumno con menos nota es %s con una media de %d \n", alum[min[0]],  acum[0][min[0]] / acum[0].length);
		
		System.out.printf("La asignatura con más nota es %s con una media de %d \n", asig[max[1]],  acum[1][max[1]] / acum[1].length);
		System.out.printf("La asignatura con menos nota es %s con una media de %de \n", asig[min[1]], acum[1][min[1]] / acum[1].length);
		
	}

}
