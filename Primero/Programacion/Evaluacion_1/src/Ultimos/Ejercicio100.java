package Ultimos;
/*
 * Eliminar la ultima letra
 */

public class Ejercicio100 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', ' ' };
		int lon = frase.length;

		for (int i = 0; i < lon; i++) {
			if (frase[i] == ' ') {
				for (int j = i; j < lon; j++) {
					frase[j - 1] = frase[j];
				}
				lon--;
			}
		}
		System.out.println(frase);
	}

}
