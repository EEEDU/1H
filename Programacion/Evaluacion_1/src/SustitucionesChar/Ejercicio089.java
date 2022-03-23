package SustitucionesChar;
//Ir metiendo en frase1 y frase2 la frase alternando

public class Ejercicio089 {

	public static void main(String[] args) {
		String frase = "Habia una vez un circo ";
		String frase1 = "";
		String frase2 = "";
		boolean enFrase1 = true;
		int inicio = 0;
		int fin = frase.indexOf(' ', 0);

		while (fin != -1) {
			if (enFrase1) {
				frase1 = frase1.concat(frase.substring(inicio, fin + 1));
				enFrase1 = false;
			} else {
				frase2 = frase2.concat(frase.substring(inicio, fin + 1));
				enFrase1 = true;
			}
			inicio = fin + 1;
			fin = frase.indexOf(' ', inicio);
		}

		System.out.println(frase1);
		System.out.println(frase2);
	}

}
