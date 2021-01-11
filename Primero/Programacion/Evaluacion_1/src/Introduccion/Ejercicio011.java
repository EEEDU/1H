package Introduccion;
/*
 * Multiplicación mediante sumas
 */

public class Ejercicio011 {
	
	public static void main(String[] args) {
		
		int num1 = 7, num2 = 5, acum = 0;
		
		for(int i = 1; i <= num2; i++) {
			acum += num1;
		}
		System.out.println("El resultado de " + num1 + " * " + num2 + " es: " + acum);
	}
}
