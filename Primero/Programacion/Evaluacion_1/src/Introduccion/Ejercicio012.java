package Introduccion;
/*
 * Calculo de variaciones 
 * Uso de printf
 * Salto de linea \n (la contrabarra es secuencia de escape)
 * TODO printf --> %d = int; &f = float; %c = char; %s = String
 */

public class Ejercicio012 {

	public static void main(String[] arg) {
		
		int elem = 7, toma = 4, acum = 1;
		
		for(int i = elem; i > toma; i--) {
			acum *= i;
		}
		System.out.println("Variaciones de " + elem + " elementos tomados de " + toma + " en " + toma + " es " + acum);
		System.out.printf("Variaciones de %d elementos tomados de %d en %d es %d \n", elem, toma, toma, acum );
	}

}
