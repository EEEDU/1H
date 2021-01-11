package ExamenB;


public class EduardoGuerrero_Examen001 {

	public static void main(String[] args) {
		int[][] tabla = { { 1, 2, 3, 4, 5 }, { 5, 1, 2, 3, 4 }, { 4, 5, 1, 2, 3 }, { 3, 4, 5, 1, 2 },
				{ 2, 3, 4, 5, 1 } };
		int[] diagonal = new int[tabla.length];

		diagonal = sacarDiagonal(tabla);

		for (int i = 0; i < diagonal.length; i++) {
			System.out.println(diagonal[i]);
		}
	}

	public static int[] sacarDiagonal(int[][] tabla) {
		int[] diagonal = new int[tabla.length];
		for (int i = 0; i < diagonal.length; i++) {
			diagonal[i] = tabla[i][i];
		}
		return diagonal;
	}
}
