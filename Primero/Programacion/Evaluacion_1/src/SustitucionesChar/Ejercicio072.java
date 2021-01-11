package SustitucionesChar;
//una cadena que cda vez que se encuentre con subcadena la susutituya en cadena2 por subcadena2

public class Ejercicio072 {
	public static void main(String[] args) {
		char[] cadena1 = { 'H', 'o', 'l', 'a', ' ', 'H', 'o', 'l', 'a', ' ' };
		char[] cadena2 = new char[100];
		char[] subcadena1 = { 'l', 'a', ' ' };
		char[] subcadena2 = { 'X', 'Y', 'Z', 'A' };
		int i = 0;
		int x = 0;
		while (x < cadena1.length) {
			cadena2[i] = cadena1[x];
			if (cadena2[i] == subcadena1[0]) {
				int j = 0;
				while (j < subcadena1.length && cadena1[x + j] == subcadena1[j]) {
					j++;
				}
				if (j == subcadena1.length) {
					for (int k = 0; k < subcadena2.length; k++, i++) {
						cadena2[i] = subcadena2[k];
					}
					x += subcadena1.length - 1;
				}
			}
			i++;
			x++;
		}
		System.out.println(cadena2);
	}
}
