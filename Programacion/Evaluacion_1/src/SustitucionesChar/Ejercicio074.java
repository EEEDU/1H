package SustitucionesChar;
/*
 * Suprimir la subcadena de la cadena
 * 
 * TODO Ejemplo de examen, conjunto de dos ejercicios
 */

public class Ejercicio074 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'H', 'o', 'l', 'a', ' ' };
		char[] subcadena = { 'l', 'a', ' ' };

		int i = 0;
		while (i < cadena.length) {
			if (cadena[i] == subcadena[0]) {
				int j = 0;
				while (j < subcadena.length && cadena[i + j] == subcadena[j]) {
					j++;
				}
				if (j == subcadena.length) {
					for (int l = 0; l < subcadena.length; l++) {
						for (int k = i + 1; k < cadena.length; k++) {
							cadena[k - 1] = cadena[k];
						}
						cadena[cadena.length - 1] = ' ';
					}
					i--;
				}
			}
			i++;
		}

		System.out.println(cadena);
	}

}
