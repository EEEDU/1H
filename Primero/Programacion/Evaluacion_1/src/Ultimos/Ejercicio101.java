package Ultimos;
/*
 * Cada vez que aparezca una subcadena que se elimine
 */

public class Ejercicio101 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'a', 'b', 'u', 'e', 'l', 'a', ' ' };
		char[] cadena2 = new char[100];
		char[] subcadena = { 'l', 'a', ' ' };
		int j = 0;

		for (int i = 0; i < cadena.length - subcadena.length; i++) {
			if (cadena[i] == subcadena[0]) {
				j = 0;
				while (j < subcadena.length && cadena[i + j] == subcadena[j]) {
					j++;
				}
				if (j == subcadena.length) {
					for (int k = i; k < cadena.length - subcadena.length; k++) {
						cadena2[k] = cadena[k + subcadena.length];
					}
					i += subcadena.length;
				} else {
					cadena2[i] = cadena[i];
				}
			} else {
				cadena2[i] = cadena[i];
			}
		}
		System.out.println(cadena2);
	}

}
