package IntroduccionMetodos;
/*
 * Cada vez que encontremos la letra sustituir la letra por los sustitutos en la frase2
 */

public class Ejercicio063 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char letra = 'a';
		char[] sustituto = { 'X', 'x' };
		char[] frase2 = new char[100];

		sustituir(frase, frase2, letra, sustituto);

		System.out.println(frase2);
	}

	private static void sustituir(char[] f, char[] f2, char let, char[] sus) {
		for (int i = 0, j = 0; i < f.length; i++) {
			if (f[i] == let) {
				for (int k = 0; k < sus.length; k++, j++) {
					f2[j] = sus[k];
				}
			}
			else {
				f2[j] = f[i];
				j++;
			}
		}
	}
}
