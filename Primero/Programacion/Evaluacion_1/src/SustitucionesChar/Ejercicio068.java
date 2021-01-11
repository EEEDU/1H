package SustitucionesChar;
/*
 * Tenemos que copiar el contenido de cadena en cadena2 dos veces
 */

public class Ejercicio068 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char[] cadena2 = new char[150];
		
		for (int i = 0, j = 0; i < cadena.length; i++, j++) {
			cadena2[i] = cadena[j];
		}
		for (int i = 0, j = 0; i < cadena.length; i++, j++) {
			cadena2[cadena.length + i] = cadena[j];
		}

		System.out.println(cadena2);
	}

}
