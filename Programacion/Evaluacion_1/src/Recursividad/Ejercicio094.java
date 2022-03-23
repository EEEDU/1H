package Recursividad;
//Contar el numero de campanadas que hay desde las 12 de la noche hasta la hora actual
//Hacer con un metodo y con recursividad

public class Ejercicio094 {

	public static void main(String[] args) {
		int hora = 14;
		int campanadas = 0;
		int nCampanadas = numeroCampanadas(hora);

		for (int i = 1; i <= hora; i++) {
			if (i > 12) {
				campanadas += i - 12;
			} else {
				campanadas += i;
			}
		}

		System.out.println(campanadas);
		System.out.println(nCampanadas);
	}

	public static int numeroCampanadas(int h) {
		if (h == 1) {
			return h;
		} else {
			if (h > 12) {
				return h - 12 + numeroCampanadas(h - 1);
			} else {
				return h + numeroCampanadas(h - 1);
			}
		}
	}

}
