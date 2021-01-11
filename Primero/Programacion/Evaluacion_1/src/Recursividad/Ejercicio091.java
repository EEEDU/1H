package Recursividad;
// Con recursividad hacer el factorial de un numero

public class Ejercicio091 {

	public static void main(String[] args) {
		int numero = 5;
		int resultado = factorial(numero);

		System.out.println(resultado);
	}

	public static int factorial(int num) {
		if (num == 1) {
			return num;
		} else {
			return num * factorial(num - 1);
		}
	}

}
