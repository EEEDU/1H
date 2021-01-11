package SustitucionesChar;
/*
 * Copiar la cadena en cadena2 pero las palabras al reves
 */

public class Ejercicio071 {

	public static void main(String[] args) {
		char[] cadena = { ' ', 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char[] cadena2 = new char[100];
		int inicio = cadena.length - 1, fin = cadena.length - 1, j = 0;

		while (inicio > 0) {
			while (cadena[inicio] != ' ') {
				inicio--;
			}
			for (int i = inicio; i <= fin; i++, j++) {
				cadena2[j] = cadena[i];
			}
			inicio = fin = inicio - 1;
		}

		System.out.println(cadena2);
	}

}
