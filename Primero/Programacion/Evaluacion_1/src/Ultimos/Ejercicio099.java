package Ultimos;
/*
 * Covertir las palabras que acaben en vocal en plural
 */

public class Ejercicio099 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', ' '};
		char[] frase2 = new char[50];
		int lon = frase.length + 1;

		for (int i = 0; i < frase.length; i++) {
			frase2[i] = frase[i];
		}
		
		for (int i = 0; i < lon; i++) {
			if (frase2[i] == ' ') {
				if (frase2[i - 1] == 'a' || frase2[i - 1] == 'e' || frase2[i - 1] == 'i' || frase2[i - 1] == 'o'
						|| frase2[i - 1] == 'u') {
					for (int j = lon - 1; j >= i; j--) {
						frase2[j + 1] = frase2[j];
					}
					frase2[i] = 's';
					i++;
					lon++;
				}
			}
		}
		System.out.println(frase2);
	}

}
