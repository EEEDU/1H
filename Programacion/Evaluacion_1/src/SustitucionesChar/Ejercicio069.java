package SustitucionesChar;
/*
 * En cadena2 ponemos la misma cadena pero invertida
 */
public class Ejercicio069 {

	public static void main(String[] args) {
		char[] cadena = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		char[] cadena2 = new char[150];

		for (int i = 0; i < cadena.length; i++) {
			cadena2[i] = cadena[(cadena.length - 1) - i];
		}

		System.out.println(cadena2);
	}

}
