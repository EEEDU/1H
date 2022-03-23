package SustitucionesChar;
/*
 * Vemos String y las primeras funciones
 * 
 * TODO .charAt(posicion) te indica que hay en esa posicion
 */

public class Ejercicio077 {

	public static void main(String[] args) {
		String frase = "En un lugar de la mancha, de cuyo nombre no quiero acordarme";
		char[] cadena = new char[150];

		for (int i = 0; i < frase.length(); i++) {
			System.out.printf(" %c ", frase.charAt(i));
		}
		System.out.println();
		for (int i = 0; i < frase.length(); i++) {
			cadena[i] = frase.charAt(i);
		}

		System.out.println(cadena);
	}

}
