package Introduccion;
/*
 * Te dice si el número acaba en 5 o no
 */

public class Ejercicio006 {
	
	public static void main(String[] arg) {
		int x;
		
		x = 80;
		
		if(x % 10 == 5) {
			System.out.println(x + "Acaba en 5");
		}
		else {
			System.out.println(x + "No acaba en 5");
		}
	}
}
