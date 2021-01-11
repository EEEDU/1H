package BuclesAnidados;
/*
 * En un array bidimensinal tenemos el numero de goles que han metido 5 futbolistas en las ultimas 4 temporadas 
 * mostrar la media de goles por año de cada futbolista
 */

public class Ejercicio042 {

	public static void main(String[] args) {
		
		int goles[][] = {{30, 32, 24, 44},
						 {20, 19, 33, 47},
						 {44, 31, 30, 22},
						 {22, 40, 21, 18},
						 {18, 25, 22, 18}};
		int media[] = new int[goles.length]; 
		String futbolistas[] = {"Jugador1", "Jugador2", "Jugador3", "Jugador4", "Jugador5"};
		
		for (int i = 0; i < goles.length; i++) {
			for (int j = 0; j < goles[i].length; j++) {
				media[i] += goles[i][j];
			}
			media[i] /= goles[i].length;
		}
		
		for (int i = 0; i < futbolistas.length; i++) {
			System.out.printf("La media del %s es igual a %d\n", futbolistas[i], media[i]);
		}

	}

}
