package IntroduccionMetodos;
/*
 * Para cada palabra los caracteres se colocan uno mas a la derecha y el ultimo se coloca en primer lugar
 */
public class Ejercicio066 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's', ' ' };
		int inicio = 0, fin = 0;


		while (fin < frase.length) {
			while (frase[fin] != ' ') {
				fin++;
			}

			desplazarDerecha(frase, inicio, fin);
			desplazarIzquierda(frase, inicio, fin);

			inicio = fin + 1;
			fin = inicio + 1;
		}

		System.out.println(frase);
	}

	public static void desplazarDerecha(char[] frase, int inicio, int fin) {
		char guardar;

		guardar = frase[fin - 1];

		for (int i = fin - 1; i > inicio; i--) {
			frase[i] = frase[i - 1];
		}

		frase[inicio] = guardar;

	}

	public static void desplazarIzquierda(char[] frase, int inicio, int fin) {
		char guardar;

		guardar = frase[inicio];

		for (int i = inicio; i < fin - 1; i++) {
			frase[i] = frase[i + 1];
		}

		frase[fin - 1] = guardar;
	}
}
