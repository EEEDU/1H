package ExamenA;

public class ExamenA004 {

	public static void main(String[] args) {
		String frase = "Hola";
		int posicion = frase.length() - 1;

		alReves(frase, posicion);
	}

	public static void alReves(String f, int pos) {
		if (pos >= 0) {
			System.out.printf("%s", f.charAt(pos));
			alReves(f, pos - 1);
		}
	}
}
