package SustitucionesChar;
/*
 * Poner en mayusculas la subcadena en la frase[]
 * Ejemplo método .contact()   sirve para concatenar
 * TODO para concatenar
 */

public class Ejercicio082 {

	public static void main(String[] args) {
		String frase[] = { "en un lugar", "de en la enmancha", "de cuyo nomenbre no", "quiero en acordarme" };
		String subcadena = "en";

		for (int i = 0; i < frase.length; i++) {
			frase[i] = frase[i].replace(subcadena, subcadena.toUpperCase());
			System.out.println(frase[i]);
		}

		frase[0] = frase[0].concat("Hola");

		System.out.println(frase[0]);
	}

}
