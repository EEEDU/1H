package SustitucionesChar;
/* 
 * Poner en mayuscula el primer caracter  y el ultimo de cada palabra
 */

public class Ejercicio075 {

	public static void main(String[] args) {
		char[] cadena = { 'h', 'o', 'l', 'a', ' ', 'h', 'o', 'l', 'a', ' ' };
		int inicio = 0, fin = 0;

		while (fin < cadena.length) {
			while (cadena[fin] != ' ') {
				fin++;
			}
			cadena[inicio] = Character.toUpperCase(cadena[inicio]);
			cadena[fin - 1] = Character.toUpperCase(cadena[fin - 1]);
			inicio = fin + 1;
			fin = inicio + 1;

		}

		System.out.println(cadena);
	}

}
