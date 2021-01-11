package Ultimos;
/*
 * Igual que el Ejercicio099 pero con String y no con cadena de caracteres
 */

public class Ejercicio099b {

	public static void main(String[] args) {
		String frase = "Hola buena angel que pasa";
		String frase2;
		int lon = frase.length();

		for (int i = 0; i < lon; i++) {
			if (frase.charAt(i) == ' ') {
				for (int j = 0; j < lon; j++) {
					frase2 = frase.substring(i, lon - 1);
					frase = frase.substring(0, i - 1).concat("s");
					frase = frase.substring(0, i).concat(frase2);
				}
			}
		}

		System.out.println(frase);
	}

}
