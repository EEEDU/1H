package IntroduccionMetodos;
/*
 * Nos dice el numero de espacios
 */
public class Ejercicio059 {

	public static void main(String[] args) {
		char frase[] = { 'e', 'd', 'u', ' ', 'g', 'u', 'e', 'r', 'r', ' ', 's', 'e', 'r', 'r' };

		System.out.printf("El numero de palabras es %d", numeroEspacios(frase) + 1);
	}

	public static int numeroEspacios(char[] caracteres) {
		int acum = 0;

		for (int i = 0; i < caracteres.length; i++) {
			if (caracteres[i] == ' ') {
				acum += 1;
			}
		}
		return acum;
	}
}
