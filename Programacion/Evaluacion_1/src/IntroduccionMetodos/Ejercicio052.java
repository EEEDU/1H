package IntroduccionMetodos;
/*
 * una funcion factorial
 */

public class Ejercicio052 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 2;

		System.out.println(
				"La combinación es igual a: " + ((factorial(num1) - factorial(num1 - num2)) / factorial(num2)));
	}

	public static int factorial(int num) {
		int acum = 1;

		for (int i = 1; i <= num; i++) {
			acum *= i;
		}

		return acum;
	}
}
