package SustitucionesChar;
/*
 * Ejercicio para aprender a útilizar .replace( , ) remplaza un caracter por otro en un String
 * Ejercicio para aprender a útilizar .index( )   te pone la posicion y si no lo encuentra pone -1 
 * 
 * TODO remplazar un caracter en un string
 * TODO Buscar una subcadena dentro de una cadena
 */

public class Ejercicio080 {

	public static void main(String[] args) {
		String frase = "En un lugar de la mancha, de cuyo nombre no quiero acordarme";

		frase = frase.replace('a', 'X');
		// .replace es polimorfo es decir puede tener muchas formas
		// public String replace(char x, char y);
		// public String replace(String x, String y);

		System.out.println(frase);

		frase = frase.replace("En", "Hola");

		System.out.println(frase);
		
		System.out.printf("La palabara Hola se encuentra en la posicion: %d\n", frase.indexOf("no"));
		//public int indexOf(String x)
		
		int j = 0;
		int posicion = frase.indexOf("no", 0);
		while (posicion != -1) {
			j++;
			posicion = frase.indexOf("no", posicion + 1);

		}
		System.out.println("Ha sido encontrado: " + j + " veces");
	}

}
