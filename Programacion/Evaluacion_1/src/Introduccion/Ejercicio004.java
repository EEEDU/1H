package Introduccion;
/*
 * El mayor de tres numeros
 */

public class Ejercicio004 {
	
	public static void main(String[] arg) {
		int x, y, z;
		
		x = 55;
		y = 76;
		z = 33;
		
		if(x > y && x > z) {
			System.out.println("El mayor n�mero es x: " + x);
		}
		else if(y > x && y > z) {
			System.out.println("El mayor n�mero es y: " + y);
		}
		else if(z > x && z > y) {
			System.out.println("El mayor n�mero es z: " + z);
		}
		else {
			System.out.println("Alguno de los n�meros son iguales");
		}
	}
}
