package ExamenB;


public class EduardoGuerrero_Examen004 {

	public static void main(String[] args) {
		String frase = "Hola que tal";
		String frase2 = alReves(frase);
		System.out.println(frase2);

	}

	public static String alReves(String f) {
		if (f.length() == 1) {
			return f;
		} else {
			return alReves(f.substring(1)) + f.charAt(0);
		}
	}
}
