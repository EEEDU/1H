package IntroduccionMetodos;
/*
 * Sustituir un caracter por otro
 */

public class Ejercicio062 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char letra = 'a';
		char sustituto = 'X';

		sustituir(frase, letra, sustituto);

		System.out.println(frase);

	}

	public static void sustituir(char[] fra, char let, char sus) {
		for (int i = 0; i < fra.length; i++) {
			if (fra[i] == let) {
				fra[i] = sus;
			}
		}
	}
}
