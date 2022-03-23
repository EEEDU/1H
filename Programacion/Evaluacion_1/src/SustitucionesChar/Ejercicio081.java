package SustitucionesChar;
/*
 * Mostrar el numero de veces que aparece en un vector
 * Utilizando el metodo .charAt;
 */
public class Ejercicio081 {

	public static void main(String[] args) {
		String frase[] = { "En un lugar", "de la mancha", "de cuyo nombre no", "quiero acordarme" };
		char caracter = 'a';
		int j = 0;
		
		for (int i = 0; i < frase.length; i++) {
			for (int k = 0; k < frase[i].length(); k++) {
				if (frase[i].charAt(k) == caracter) {
					j++;
				}
			}
		}

		System.out.printf("La letra a se repite %d veces", j);
	}

}
