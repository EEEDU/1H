package Introduccion;
/*
 * Mostrar por pantalla el valor mas alto del vector y en que posici�n esta
 */

public class Ejercicio015 {

	public static void main(String[] args) {
		
		int datos[] = {12, 234, 243, 3322, 3, 322, 5443};
		int max = datos[0], posMax = 0;
		
		for(int i = 1; i < datos.length; i++) {
			
			if(datos[i] > datos[posMax]) {
				max = datos[i];
				posMax = i;
			}
		}
		System.out.printf("El dato m�s grande es: %d\nEsta en la posici�n: %d", max, posMax + 1);
	}

}