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
			System.out.println("El n�mero " + x + " es m�ltiplo de " + y);
		}
		/*
		else if(y % x == 0){
			System.out.println("El n�mero " + y + " es m�ltiplo de " + x);
		}
		*/
		else {
			System.out.println("Ninguno de los n�meros es m�ltiplo del otro");
		}
	}
}
