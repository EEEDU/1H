package Introduccion;
/*
 * Declaración y manipulación de vectores
 */

public class Ejercicio014 {

	public static void main(String[] args) {
		
		int datos[] = {17, 55, 33, 21, 44};
		
		for(int i = 0; i < datos.length; i++) {
			System.out.printf("El dato numero %d es: %d \n", i + 1, datos[i]);
		}
		
		System.out.println("\n");
		
		for(int i = 0; i < datos.length; i++) {
			datos[i] *= 2;
			System.out.printf("El dato numero %d por 2 es: %d \n", i + 1, datos[i]);
		}
	}
}
