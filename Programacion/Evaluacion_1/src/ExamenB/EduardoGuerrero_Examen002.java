package ExamenB;


public class EduardoGuerrero_Examen002 {

	public static void main(String[] args) {
		int[] notaMediaHistorica = { 8, 7, 9, 6, 9 };
		int[][] notaAlumnos = { { 6, 2, 10, 10 }, { 9, 10, 6, 10 }, { 4, 9, 10, 9 }, { 5, 6, 1, 6 }, { 6, 7, 8, 10 } };
		String[] nombreAlumnos = { "Pepe", "Jose", "Edu", "Ana" };
		String[] nombreAsignaturas = { "Sistemas", "Lenguaje de marcas", "Programación",
				"Bases de datos",
				"Entornos de desarrollo" };

		alumnosSuperanMedia(notaMediaHistorica, notaAlumnos, nombreAlumnos, nombreAsignaturas);
		System.out.println("--------------------------------------------------------");
		alumnosNoSuperanMedia(notaMediaHistorica, notaAlumnos, nombreAlumnos, nombreAsignaturas);
		System.out.println("--------------------------------------------------------");
		porcentajeMedias(notaMediaHistorica, notaAlumnos, nombreAlumnos);
		System.out.println("--------------------------------------------------------");
		alumnoSuperaAñoPasado(notaMediaHistorica, notaAlumnos, nombreAlumnos);
	}

	public static void alumnosSuperanMedia(int[] notaMediaHistorica, int[][] notaAlumnos,
			String[] nombreAlumnos,
			String[] nombreAsignaturas) {

		for (int i = 0; i < notaAlumnos[0].length; i++) {
			for (int j = 0; j < notaMediaHistorica.length; j++) {
				if (notaMediaHistorica[j] < notaAlumnos[j][i]) {
					System.out.println("El alumno " + nombreAlumnos[i] + " ha superado la media de la asignatura "
							+ nombreAsignaturas[j] + " la media es " + notaMediaHistorica[j]
							+ " el ha sacado "
							+ notaAlumnos[j][i]);
				}
			}
		}
	}

	public static void alumnosNoSuperanMedia(int[] notaMediaHistorica, int[][] notaAlumnos,
			String[] nombreAlumnos,
			String[] nombreAsignaturas) {
		for (int i = 0; i < notaMediaHistorica.length; i++) {
			for (int j = 0; j < notaAlumnos[i].length; j++) {
				if (notaMediaHistorica[i] > notaAlumnos[i][j]) {
					System.out.println("El alumno " + nombreAlumnos[j] + " no ha superado la media de la asignatura "
							+ nombreAsignaturas[i] + " la media es " + notaMediaHistorica[i]
							+ " el ha sacado "
							+ notaAlumnos[i][j]);
				}
			}
		}
	}

	public static void porcentajeMedias(int[] notaMediaHistorica, int[][] notaAlumnos, String[] nombreAlumnos) {
		int[] notaMediaAlumnos = new int[notaAlumnos[0].length];
		int mediaNotaMediaHistoria = 0;

		for (int i = 0; i < notaAlumnos[0].length; i++) {
			for (int j = 0; j < notaAlumnos.length; j++) {
				notaMediaAlumnos[i] += notaAlumnos[j][i];
			}
			notaMediaAlumnos[i] /= notaAlumnos.length;
		}

		for (int i = 0; i < notaMediaHistorica.length; i++) {
			mediaNotaMediaHistoria += notaMediaHistorica[i];
		}

		mediaNotaMediaHistoria /= notaMediaHistorica.length;

		for (int i = 0; i < notaMediaAlumnos.length; i++) {
			System.out.println("El porcenja de " + nombreAlumnos[i] + " es = "
					+ notaMediaAlumnos[i] * 100 / mediaNotaMediaHistoria + "%");
		}
	}

	public static void alumnoSuperaAñoPasado(int[] notaMediaHistorica, int[][] notaAlumnos, String[] nombreAlumnos) {
		int[] notaMediaAlumnos = new int[notaAlumnos[0].length];
		int mediaNotaMediaHistoria = 0;

		for (int i = 0; i < notaAlumnos[0].length; i++) {
			for (int j = 0; j < notaAlumnos.length; j++) {
				notaMediaAlumnos[i] += notaAlumnos[j][i];
			}
			notaMediaAlumnos[i] /= notaAlumnos.length;
		}

		for (int i = 0; i < notaMediaHistorica.length; i++) {
			mediaNotaMediaHistoria += notaMediaHistorica[i];
		}

		mediaNotaMediaHistoria /= notaMediaHistorica.length;

		for (int i = 0; i < notaMediaAlumnos.length; i++) {
			if (mediaNotaMediaHistoria < notaMediaAlumnos[i]) {
				System.out.println("El alumno " + nombreAlumnos[i] + " tiene mejor nota media que los años anteriores");
			}
		}
	}

}
