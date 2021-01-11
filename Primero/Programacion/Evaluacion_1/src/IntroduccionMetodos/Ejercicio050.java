package IntroduccionMetodos;
/*
 * Un metodo que reciba un vector desordenado y lo ordene, sin que saque ningun numero.
 */

public class Ejercicio050 {

	public static void main(String[] args) {
		int[] numeros = { 3, 5, 1, 4, 6, 2, 9, 8, 7 };
		ordenar(numeros);

		for (int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);
		}
	}

	public static void ordenar(int[] vector) {
		int x;

		for (int i = 0; i < vector.length - 1; i++) {
			for (int j = 0; j < vector.length - 1; j++) {
				if (vector[j] > vector[j + 1]) {
					x = vector[j];
					vector[j] = vector[j + 1];
					vector[j + 1] = x;
				}
			}
		}
	}
}
