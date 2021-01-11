package Recursividad;
// Hacer una division con recursividad

public class Ejercicio093 {

	public static void main(String[] args) {
		int numero1 = 7, numero2 = 2;
		int resultado = division(numero1, numero2);

		System.out.println(resultado);
	}

	public static int division(int num1, int num2) {
		if (num1 < num2) {
			return 0;
		} else {
			return 1 + division(num1 - num2, num2);
		}
	}
}
