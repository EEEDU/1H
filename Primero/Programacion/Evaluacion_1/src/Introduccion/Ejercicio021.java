package Introduccion;
/*
 * Desplazar los datos del vector hacia la derecha
 */
public class Ejercicio021 {

	public static void main(String[] args) {
		
		int datos[] = {10, 20, 30, 40, 50, 60};
		int x = datos[datos.length - 1];
		
		for(int i = datos.length - 2; i >= 0; i--) {
			
			datos[i + 1]  = datos[i];
			
		}
		
		datos[0] = x;
		
		for (int i = 0; i < datos.length; i++) {
			
			System.out.println("El dato " + (i + 1) + " es: " + datos[i]);
			
		}

	}

}
