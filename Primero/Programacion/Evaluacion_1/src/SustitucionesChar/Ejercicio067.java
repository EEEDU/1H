package SustitucionesChar;
/*
 * Copiar la cadena en cadena2, despues sustituir el caracter por la subcadena
 * Parecido al Ejercicio063
 */
public class Ejercicio067 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char caracter = 'a';
		char[] subcadena = { 'X', 'x', 'd', 'X' };
		char[] cadena2 = new char[150];
		int longitud = cadena.length;

		for (int i = 0; i < cadena.length; i++) {
			cadena2[i] = cadena[i];
		}

		for (int i = 0; i < longitud; i++) {
			if (cadena2[i] == caracter) {
				cadena2[i] = subcadena[0];
				for (int j = 1; j < subcadena.length; j++) {
					for (int k = (longitud - 1); k > i; k++) {
						cadena2[k + 1] = cadena2[k];// TODO hay un error
					}
					cadena2[++i] = subcadena[j];
					longitud++;
				}
			}
		}

		System.out.println(cadena2);
	}
}

