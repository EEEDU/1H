package BuclesAnidados;
/*
 * Desplazamiento hacia la derecha con bucles anidados
 */

public class Ejercicio023 {

	public static void main(String[] args) {
		
		int datos[] = {10, 20, 30, 40, 50, 60};
		int x;
		
		for (int i = 0; i < datos.length; i++) {
			
			System.out.println("Ronda número: " + (i + 1));
			
			x = datos[datos.length - 1];		
			
			for (int j = datos.length - 2; j >= 0; j--) {	
				datos[j + 1] = datos[j];		
			}			
			
			datos[0] = x; 
			
			for (int k = 0; k < datos.length; k++) {
				System.out.println("El número "+ (k + 1) + " es: " + datos[k]);
			}
			
		}

	}

}
