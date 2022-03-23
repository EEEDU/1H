package Introduccion;
/*
 * division medieante restas
 */

public class Ejercicio013 {

	public static void main(String[] args) {
		
		int dividendo = 9, divisor = 2, i = dividendo, acum = 0;
		
		while(i >= divisor) {
			i -= divisor;
			acum++;
		}
		System.out.printf("La division entre %d y %d es igual a %d y de resto %d \n", dividendo, divisor, acum, i);
	}
}
