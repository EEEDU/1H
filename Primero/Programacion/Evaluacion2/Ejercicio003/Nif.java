package Ejercicio003;

public class Nif {
	public int dni;
	public char letra;
	public static char tabla[] = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
			'V', 'H', 'L', 'C', 'K', 'E' };

	public Nif(int dni, char let) throws NifException {
		this.dni = dni;
		if (let != tabla[dni % 23]) {
			throw new NifException("La letra es incorrecta");
		}
		letra = tabla[dni % 23];
	}

	public Nif(int dni) {
		this.dni = dni;
		letra = tabla[dni % 23];
	}

	public void print() {
		System.out.println("El DNI es " + dni + letra);
	}
}
