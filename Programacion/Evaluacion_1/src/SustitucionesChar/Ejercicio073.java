package SustitucionesChar;
/*
 * Sobre la misma cadena eliminar el caracter de la cadena
 */

public class Ejercicio073 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'H', 'o', 'l', 'a' };
		char caracter = 'l';

		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i] == caracter) {
				for (int j = i + 1; j < cadena.length; j++) {
					cadena[j - 1] = cadena[j];
				}
				cadena[cadena.length - 1] = ' ';
				i--;
			}
		}

		System.out.println(cadena);
	}

}
