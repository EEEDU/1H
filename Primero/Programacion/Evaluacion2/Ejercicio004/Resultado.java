package Ejercicio004;

public class Resultado {
	static private int resultado[][];

	public static void main(String[] args) {
		resultado = new int[6][8];
		Bombo bombo = new Bombo();
		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				resultado[i][j] = bombo.sacaBola();
			}
		}

		for (int i = 0; i < resultado.length; i++) {
			for (int j = 0; j < resultado[i].length; j++) {
				bombo.print(resultado[i][j]);
			}
			System.out.println();
		}
	}
}
