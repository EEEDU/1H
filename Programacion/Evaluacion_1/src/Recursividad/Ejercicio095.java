package Recursividad;
//Dado un numero entero que se encuentra dentro de una variable
//diseccionarlo analizandolo hasta las centenas de millar

public class Ejercicio095 {

	public static void main(String[] args) {
		String medidas[] = { "unidades", "decenas", "centenas", "unidades de millar", "decenas de millar",
				"centenas de millar" };
		int numero = 256783;
		int i = 0;

		while (numero > 0) {
			System.out.println((numero % 10) + " " + medidas[i]);
			i++;
			numero /= 10;
		}

		System.out.println();
		numero = 256783;
		i = 0;
		diseccionar(numero, i, medidas);
	}

	public static void diseccionar(int num, int i, String[] med) {
		if (num > 0) {
			System.out.println((num % 10) + " " + med[i]);
			diseccionar(num / 10, i + 1, med);
		}
	}

}
