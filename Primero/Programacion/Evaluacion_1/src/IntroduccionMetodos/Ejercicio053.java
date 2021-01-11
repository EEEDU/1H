package IntroduccionMetodos;
/*
 * Indicar cuanto ha ganado en total cada empleado creando una metodo que solo coja un array unividimensional.
 *  */

public class Ejercicio053 {

	public static void main(String[] args) {
		int salario[][] = { { 700, 900, 1300, 800, 1000, 700 }, { 700, 1300, 800, 900, 750, 1450 },
				{ 800, 900, 1200, 850, 850, 1300 }, { 1200, 750, 800, 950, 1200, 800 } };
		String empleado[] = { "Empleado1", "Empleado2", "Empleado3", "Empleado4" };

		for (int i = 0; i < empleado.length; i++) {
			System.out.println("El empleado " + empleado[i] + " ha ganado " + suma(salario[i]));
		}
	}

	public static int suma(int[] vector) {
		int acum = 0;

		for (int i = 0; i < vector.length; i++) {
			acum += vector[i];
		}

		return acum;
	}
}
