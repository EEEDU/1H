package IntroduccionMetodos;
/*
 * Hacer una funcion que devuelva el valor maximo de un vector
 */

public class Ejercicio047 {

	public static void main(String[] args) {
		int vector1[] = { 23, 43, 54, 2, 45, 67 };
		int vector2[] = { 45, 65, 65, 34, 765, 45, 434345, 534 };

		System.out.println("El numero mayor del vector 1 es: " + numeroMayor(vector1));
		System.out.println("El numero mayor del vector 2 es: " + numeroMayor(vector2));
	}

	public static int numeroMayor(int v[]) {
		int posMax = 0;

		for (int i = 0; i < v.length; i++) {
			if (v[posMax] < v[i]) {
				posMax = i;
			}
		}
		return v[posMax];
	}
}
