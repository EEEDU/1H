package Recursividad;
/*
 * Ejercicio UNI
 * Mostrar por pantalla el trimestre con mas nacimientos
 * Mostrar por pantalla el mes con mas muertes o emigraciones
 * Mostrar por pantalla en cuatas personas han nacido e inmigrado y las muertes y emigraciones
 */
public class Ejercicio098 {

	public static void main(String[] args) {
		String[] movimientos = { "Nacimientos", "muertes", "emigraciones", "inmigraciones" };
		int[][] movPoblacion = { { 3, 10, 0, 0 }, { 3, 1, 2, 1 }, { 1, 4, 2, 2 }, { 1, 1, 2, 1 }, { 2, 2, 0,
				2 },
				{ 3, 2, 4, 1 }, { 4, 2, 1, 0 }, { 3, 4, 2, 1 }, { 1, 4, 2, 2 }, { 1, 1, 2, 1 }, { 2, 2, 2, 2 },
				{ 0, 2, 4, 1 } };

		nacimientosTrimestre(movPoblacion, movimientos);
		System.out.println("-------------------------------------------------------------");
		bajasMes(movPoblacion, movimientos);
		System.out.println("-------------------------------------------------------------");
		subidasBajadas(movPoblacion, movimientos);

	}

	public static void nacimientosTrimestre(int[][] movPoblacion, String[] movimientos) {
		int[] acumTriNacimiento = new int[movPoblacion.length / 3];
		int triMayor = 0;
		
		for (int i = 0; i < movPoblacion.length; i++) {
			acumTriNacimiento[i / 3] += movPoblacion[i][0];
		}

		for (int i = 1; i < acumTriNacimiento.length; i++) {
			if (acumTriNacimiento[i] > acumTriNacimiento[triMayor]) {
				triMayor = i;
			}
		}
		for (int i = 0; i < acumTriNacimiento.length; i++) {
			System.out.println("El trimestre " + (i + 1) + " hubo " + acumTriNacimiento[i] + " nacimientos");
		}
		System.out.printf("\nEl trimestre con mas %s es el %d \n", movimientos[0], triMayor + 1);
	}

	public static void bajasMes(int[][] movPoblacion, String[] movimientos) {
		int[] acumMesBajas = new int[movPoblacion.length];
		int mesMayor = 0;

		for (int i = 0; i < movPoblacion.length; i++) {
			acumMesBajas[i] = movPoblacion[i][1] + movPoblacion[i][2];
		}

		for (int i = 1; i < acumMesBajas.length; i++) {
			if (acumMesBajas[i] > acumMesBajas[mesMayor]) {
				mesMayor = i;
			}
		}
		for (int i = 0; i < acumMesBajas.length; i++) {
			System.out.println("Las " + movimientos[1] + " y " + movimientos[2] + "en el mes " + (i + 1) + " es de "
					+ acumMesBajas[i]);
		}

		System.out.printf("\nEl mes com mas %s y %s es el %d\n", movimientos[1], movimientos[2], mesMayor + 1);
	}

	public static void subidasBajadas(int[][] movPoblacion, String[] movimientos) {
		int acumSubidas = 0;
		int acumBajas = 0;

		for (int i = 0; i < movPoblacion.length; i++) {
			acumSubidas += movPoblacion[i][0] + movPoblacion[i][3];
			acumBajas += movPoblacion[i][1] + movPoblacion[i][2];
		}

		System.out.printf("Las subidas: %s o %s son %d en todo el años\n", movimientos[0],
				movimientos[3],
				acumSubidas);
		System.out.printf("Las bajas: %s o %s son %d en todo el años\n", movimientos[1], movimientos[2], acumBajas);

		if (acumSubidas > acumBajas) {
			System.out.printf("La poblacion sube: %d", (acumSubidas - acumBajas));
		} else {
			System.out.printf("La poblacion baja: %d", (acumBajas - acumSubidas));
		}
	}
}
