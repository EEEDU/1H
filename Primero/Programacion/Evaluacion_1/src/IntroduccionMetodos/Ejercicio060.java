package IntroduccionMetodos;
/*
 * Dada un char crear un nuevo char igual pero que a cada palabra le añada al final una x
 */

public class Ejercicio060 {

	public static void main(String[] args) {
		char frase[] = { 'e', 'd', 'u', ' ', 'g', 'u', 'e', 'r', 'r', ' ', 's', 'e', 'r', 'r', ' ' };
		char fraseModificada[] = new char[50];
		ponerX(frase, fraseModificada);

		System.out.println(fraseModificada);

		char[] fraseModificada2 = ponerX2(frase);

		System.out.println(fraseModificada2);
	}

	public static void ponerX(char[] frase1, char[] frase2) {

		for (int i = 0, j = 0; i < frase1.length; i++, j++) {
			if (frase1[i] == ' ') {
				frase2[j] = 'x';
				j++;
			}
			frase2[j] = frase1[i];
		}
	}

	public static char[] ponerX2(char[] frase3) {
		char[] frase4 = new char[50];

		for (int i = 0, j = 0; i < frase3.length; i++, j++) {
			if (frase3[i] == ' ') {
				frase4[j] = 'x';
				j++;
			}
			frase4[j] = frase3[i];
		}

		return frase4;
	}
}
