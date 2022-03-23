package Recursividad;
//Transformar un numero a binario

public class Ejercicio096 {

	public static void main(String[] args) {
		int numero = 7;
		
		transformar(numero);
	}

	public static void transformar(int num) {
		if (num > 0) {
			transformar(num / 2);
			System.out.printf("%d", num % 2);
		}
	}
}
