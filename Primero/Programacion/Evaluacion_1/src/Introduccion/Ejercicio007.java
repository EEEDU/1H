package Introduccion;
/*
 * Calcular si uno es multiplo de otro o no
 */

public class Ejercicio007 {
	
	public static void main(String[] arg) {
		int x, y, z;
		
		x = 50;
		y = 2;
		
		if(x < y) {
			z = x;
			x = y;
			y = z;		
		}
		
		if(x % y == 0) {
			System.out.println("El número " + x + " es múltiplo de " + y);
		}
		/*
		else if(y % x == 0){
			System.out.println("El número " + y + " es múltiplo de " + x);
		}
		*/
		else {
			System.out.println("Ninguno de los números es múltiplo del otro");
		}
	}
}
