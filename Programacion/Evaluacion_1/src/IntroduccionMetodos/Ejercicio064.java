package IntroduccionMetodos;
/*
 * realizar funcion que reciba dos cadenas de char,
 * tiene que devolver un entero por cada vez que repite la char pequeña en char
 * 
 * nn se repite 4 veces en nnnnn
 */
public class Ejercicio064 {

	public static void main(String[] args) {
		char cadenaPrincipal[] = { 'n', 'n', 'n', 'n', 'n' };
		char cadenaSecundaria[] = { 'n', 'n' };

		System.out.println(
				"La cadena secundaria se repite " + numeroRepeticiones(cadenaPrincipal, cadenaSecundaria) + " veces");
	}

	public static int numeroRepeticiones(char[] cadena1, char[] cadena2) {
		int acum = 0;

		for (int i = 0; i <= (cadena1.length - cadena2.length); i++) {
			if (cadena1[i] == cadena2[0]) {
				int j = 1;
				while ((j < cadena2.length) && (cadena1[i + j] == cadena2[j])) {
					j++;
				}
				if (j == (cadena2.length)) {
					acum++;
				}
			}
		}

		return acum;
	}

}
