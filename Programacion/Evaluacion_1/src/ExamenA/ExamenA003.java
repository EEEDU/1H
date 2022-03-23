package ExamenA;

public class ExamenA003 {

	public static void main(String[] args) {
		char[] frase = { 'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'e', 'n', ' ', 'l', 'a', ' ', 'm',
				'a', 'n', 'c', 'h', 'a', ' ' };
		int pos = frase.length - 1;

		char aux = frase[frase.length - 1];
		for (int i = frase.length - 2; i >= 0; i--) {
			frase[i + 1] = frase[i];
		}
		frase[0] = aux;

		while (frase[pos] != ' ') {
			aux = frase[frase.length - 1];
			for (int i = frase.length - 2; i >= 0; i--) {
				frase[i + 1] = frase[i];
			}
			frase[0] = aux;
		}

		System.out.println(frase);
	}
}
