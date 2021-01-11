package IntroduccionMetodos;
/*
 * Utilizando la funcion de las calse Character llamada toUperrCas, 
 * realizar una funcion propia que convierta todos los caracteres de frase a mayusculas
 */

public class Ejercicio061 {

	public static void main(String[] args) {
		char[] frase = { 'H', 'o', 'l', 'a', ' ', 'b', 'u', 'e', 'n', 'a', 's' };
		convertir(frase);
		System.out.println(frase);
	}

	public static void convertir(char[] f) {
		for (int i = 0; i < f.length; i++) {
			f[i] = Character.toUpperCase(f[i]);
		}
	}
}