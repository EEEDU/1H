package SustitucionesChar;
/*
 * Convertir las vocales que esten en minuscula a mayuscula y al reves
 * TODO switch
 */

public class Ejercicio076 {

	public static void main(String[] args) {
		char[] cadena = { 'h', 'O', 'l', 'a', ' ', 'h', 'o', 'l', 'A', ' ' };

		for (int i = 0; i < cadena.length; i++) {
			switch(cadena[i]){
			case 'A':
			case 'E':
			case 'I':
			case 'O':
			case 'U':
				cadena[i] = Character.toLowerCase(cadena[i]);
				break;
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				cadena[i] = Character.toUpperCase(cadena[i]);
				break;
			default:
				cadena[i] = '*';
			}
		}

		System.out.println(cadena);
	}

}
