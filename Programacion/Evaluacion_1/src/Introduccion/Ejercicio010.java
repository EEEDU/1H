package Introduccion;
/*
 * Factorial de un numero
 */

public class Ejercicio010 {

	public static void main(String[] args) {

		int num = 5, fact = 1;
		
		for(int i = 2 ; i <= num; i++) {
			fact *= i;
		}	
		System.out.println("El factorial de " + num + " es: " + fact);
		
		fact = num;
		
		for(int i = (num - 1); i >= 1; i--) {
			fact *= i;
		}
		System.out.println("El factorial de " + num + " es: " + fact);
	}
}
