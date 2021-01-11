package Introduccion;
/*
 * Tabla de un número
 */

public class Ejercicio009 {
	
	public static void main(String[] arg) {
		
		int num = 7;
		
		System.out.println("La tabla del " + num + " es: ");
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(num + " * " + i + " = " + (num *i));
		}
	}
}
