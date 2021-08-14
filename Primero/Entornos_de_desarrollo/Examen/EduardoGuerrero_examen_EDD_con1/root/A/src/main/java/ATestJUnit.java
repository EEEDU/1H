
public class ATestJUnit {

	/*
	 * Calcula el logaritmo en base dos de cualquier numero
	 */

	public static Integer log2n(Integer n) {
		return (n > 1) ? 1 + log2n(n / 2) : 0;
	}

	/*
	 * Indica si una cadena de texto es palindromo o no
	 */
	public static boolean isPalindromo(String frase) {
		frase = frase.replace(" ", "");
		System.out.print(frase);
		int fin = frase.length() - 1;
		int ini = 0;
		boolean espalin = true;

		while (ini < fin) {
			if (frase.charAt(ini) != frase.charAt(fin)) {
				espalin = false;
			}
			ini++;
			fin--;
		}
		return espalin;
	}

	/*
	 * obtiene el maximo comun divisor de dos numeros
	 */
	public static int obtener_mcd(Integer a, Integer b) {
		if (b.compareTo(0) == 0)
			return a;
		else
			return obtener_mcd(b, a % b);
	}

}
