package Recursividad;
//Recursividad

public class Ejercicio090 {

	public static void main(String[] args) {
		int numero1 = 5;
		int numero2 = 4;
		int resultado;

		resultado = multiplicar(numero1, numero2);

		System.out.println(resultado);
	}

	public static int multiplicar(int n1, int n2) {
		if (n2 == 1) {
			return n1;
		} else {
			return n1 + multiplicar(n1, n2 - 1);
		}
	}

}
