package ExamenA;

public class ExamenA002 {

	public static void main(String[] args) {
		int[] capacidadMaxima = { 34, 23, 45, 65, 87 };
		int[][] numComensales = { { 12, 13, 33, 34, 25, 23, 23 }, { 11, 13, 23, 4, 15, 23, 13 },
				{ 42, 11, 33, 43, 5, 45, 23 }, { 12, 54, 23, 65, 23, 2, 23 }, { 72, 84, 33, 55, 33, 23, 83 } };
		String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo" };

		porcentajeSalaDia(capacidadMaxima, numComensales, diasSemana);
		System.out.println("---------------------------------------------------");
		porcentajeSalaSemana(capacidadMaxima, numComensales, diasSemana);
		System.out.println("---------------------------------------------------");
		porcentajeDiaSemana(capacidadMaxima, numComensales, diasSemana);
		System.out.println("---------------------------------------------------");
		porcentajeSemana(capacidadMaxima, numComensales, diasSemana);
	}

	public static void porcentajeSalaDia(int[] capacidadMaxima, int[][] numComensales, String[] diasSemana) {
		for (int i = 0; i < numComensales.length; i++) {
			for (int j = 0; j < numComensales[i].length; j++) {
				System.out.println("Sala " + (i + 1) + " el " + diasSemana[j] + " el porcentaje es de "
						+ (numComensales[i][j] * 100 / capacidadMaxima[i] + "%"));
			}
			System.out.println();
		}
	}

	public static void porcentajeSalaSemana(int[] capacidadMaxima, int[][] numComensales, String[] diasSemana) {
		int[] acumNumComensales = new int[numComensales.length];

		for (int i = 0; i < numComensales.length; i++) {
			for (int j = 0; j < numComensales[i].length; j++) {
				acumNumComensales[i] += numComensales[i][j];
			}
		}

		for (int i = 0; i < acumNumComensales.length; i++) {
			acumNumComensales[i] /= numComensales[i].length;
		}

		for (int i = 0; i < numComensales.length; i++) {
			System.out.println("En la sala " + (i + 1) + " hubo un porcentaje de "
					+ (acumNumComensales[i] * 100 / capacidadMaxima[i] + "%"));
			System.out.println();
		}
	}

	public static void porcentajeDiaSemana(int[] capacidadMaxima, int[][] numComensales, String[] diasSemana) {
		int[] acumNumComensales = new int[numComensales[0].length];
		int acumCapacidadMaxima = 0;

		for (int i = 0; i < numComensales.length; i++) {
			for (int j = 0; j < numComensales[i].length; j++) {
				acumNumComensales[j] += numComensales[i][j];
			}
			acumCapacidadMaxima += capacidadMaxima[i];
		}

		acumCapacidadMaxima /= capacidadMaxima.length;

		for (int i = 0; i < acumNumComensales.length; i++) {
			acumNumComensales[i] /= numComensales.length;
		}

		for (int i = 0; i < acumNumComensales.length; i++) {
			System.out.println("El" + diasSemana[i]
					+ " hubo un porcentaje de "
					+ (acumNumComensales[i] * 100 / acumCapacidadMaxima + "%"));
			System.out.println();
		}
	}

	public static void porcentajeSemana(int[] capacidadMaxima, int[][] numComensales, String[] diasSemana) {
		int acumCapacidadMaxima = 0;
		int[] acumNumComensalesVector = new int[numComensales.length];
		int acumNumComensales = 0;
		
		for (int i = 0; i < numComensales.length; i++) {
			for (int j = 0; j < numComensales[i].length; j++) {
				acumNumComensalesVector[i] += numComensales[i][j];
			}
		}

		for (int i = 0; i < acumNumComensalesVector.length; i++) {
			acumNumComensalesVector[i] /= numComensales[0].length;
			acumNumComensales += acumNumComensalesVector[i];
		}

		acumNumComensales /= acumNumComensalesVector.length;

		for (int i = 0; i < capacidadMaxima.length; i++) {
			acumCapacidadMaxima += capacidadMaxima[i];
		}

		acumCapacidadMaxima /= capacidadMaxima.length;

		System.out.println("El porcentaje semanal es " + (acumNumComensales * 100 / acumCapacidadMaxima) + "%");
	}
}
