package BuclesAnidados;

public class Ejercicio029 {

	public static void main(String[] args) {

		int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
		int fil[] = {0, 0, 0};
		int col[] = {0, 0, 0, 0};
		
		for (int i = 0; i < tabla.length; i++) {
			for (int j = 0; j < tabla[i].length; j++) {	
				fil[i] += tabla[i][j];
				col[j] += tabla[i][j];	
			}
		}
		
		System.out.println("Las sumas de las filas son: ");
		for (int i = 0; i < fil.length; i++) {
			System.out.printf("La fila %d es igual a: %d \n", i + 1, fil[i]);
		}
		
		System.out.println("Las sumas de las columnas son: ");
		for (int i = 0; i < col.length; i++) {
			System.out.printf("La columna %d es igual a: %d \n", i + 1, col[i]);
		}
	}
}
