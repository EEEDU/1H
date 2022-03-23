package Introduccion;
/*
 * Vector que cada dato se desplaza hacia la izquierda
 */

public class Ejercicio020 {

	public static void main(String[] args) {
		
		int datos[] = {1, 2, 3, 4, 5, 6};
		int x;
		
		x = datos[0];
		
		for(int i = 1; i < datos.length; i++) {
			
			datos[i - 1] = datos[i];
			
		}
		
		datos[datos.length - 1] = x;
		
		for(int i = 0; i < datos.length; i++) {
			
			System.out.println("El datos " + (i + 1) + " es: " + datos[i]);
	
		}

	}

}
