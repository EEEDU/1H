package ExamenB;


public class EduardoGuerrero_Examen003 {

	public static void main(String[] args) {
		char[] frase = { 'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'l', 'a', ' ',
				'm',
				'a', 'n', 'c', 'h', 'a', ' ' };
		int posicion = 0;

		char auxiliar = frase[0];

		while (frase[posicion] != ' ') {
			auxiliar = frase[posicion];
			for (int i = 0; i < (frase.length - 1) - posicion; i++) {
				frase[i] = frase[i + 1];
			}
			frase[frase.length - 1] = auxiliar;
		}

		System.out.println(frase);
	}
}
