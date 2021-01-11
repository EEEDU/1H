package IntroduccionMetodos;
/*
 * De cada palabra vamos a cambiar el primer caracter con el primero
 */

public class Ejercicio065 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's', ' ' };
		int inicio = 0, fin = 0;

		while (fin < frase.length) {
			while (frase[fin] != ' ') {
				fin++;
			}

			intercambiar(frase, inicio, fin);

			inicio = fin + 1;
			fin = inicio + 1;
		}

		System.out.println(frase);
	}

	private static void intercambiar(char[] frase, int inicio, int fin) {
		char x;
		x = frase[inicio];
		frase[inicio] = frase[fin - 1];
		frase[fin - 1] = x;
	}
}
