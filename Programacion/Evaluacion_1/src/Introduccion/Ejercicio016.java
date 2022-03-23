package Introduccion;
/*
 * Encontrar el m�nimo y el m�ximo de un vector
 */

public class Ejercicio016 {

	public static void main(String[] args) {
		
		int datos[] = {12, 234, 243, 3322, 3, 322, 5443};
		int max = datos[0], posMax = 0, min = datos[0], posMin = 0;
		
		for(int i = 1; i < datos.length; i++) {
			
			if(datos[i] < datos[posMin]) {
				min = datos[i];
				posMin = i;
			}
			
			if(datos[i] > datos[posMax]) {
				max = datos[i];
				posMax = i;
			}
			
		}
		
		System.out.printf("El maximo es %d y se encuentra en la posici�n %d \n", max, posMax + 1);
		System.out.printf("El maximo es %d y se encuentra en la posici�n %d \n", min, posMin + 1);
	}

}
