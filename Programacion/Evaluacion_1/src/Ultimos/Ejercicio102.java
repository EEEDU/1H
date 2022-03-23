package Ultimos;
/*
 * Dado un string mostrar las palabras en orden inverso.
 */

public class Ejercicio102 {

	public static void main(String[] args) {
		String frase = "Habia una vez un circo ";
		int inicio = 0;
		int fin = frase.indexOf(' ', 0);

		mostrarPalabra(frase, inicio, fin);
	}

	public static void mostrarPalabra(String frase, int inicio, int fin) {
		if (fin != -1) {
			mostrarPalabra(frase, fin + 1, frase.indexOf(' ', inicio));
			System.out.printf("%s", frase.substring(inicio, fin + 1));
		}
	}
}
