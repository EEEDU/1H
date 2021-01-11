package SustitucionesChar;
/*
 * Ejercicio para aprender a útilizar .substring( , )
 * 
 * TODO Para ir a una parte especifica del string
 */

public class Ejercicio079 {

	public static void main(String[] args) {
		String frase = "En un lugar de la mancha, de cuyo nombre no quiero acordarme";
		int inicio = 7, fin = 18;

		System.out.println("La subcadena contiene: " + frase.substring(inicio, fin));

		for (int i = 0; i < frase.length(); i++) {
			System.out.printf("%s\n", frase.substring(0, i + 1));
		}
	}

}
