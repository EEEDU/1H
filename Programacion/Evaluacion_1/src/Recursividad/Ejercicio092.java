package Recursividad;
// Hacer la traza de este ejercicio recursivo

public class Ejercicio092 {

	public static void main(String[] args) {
		mostrarFrase(5);
	}

	public static void mostrarFrase(int num) {
		if (num > 0) {
			System.out.println("mostrarFrase (" + num + ")");
			mostrarFrase(num - 1);
			System.out.println("mostrarFrase (" + num + ")");
		}
	}
}
