package Introduccion;
/*
 * Modificar un vector de enteros combirtiendo los negativos en positivos y los positivos los multiplicais por 2
 */

public class Ejercicio018 {

	public static void main(String[] args) {
		
		int datos[] = {45, -7, 22, -111, 0, -98};
		
		for(int i = 0; i < datos.length; i++) {
			
			if(datos[i] > 0) {
				datos[i] *= 2;
			}
			
			else{
				datos[i] *= -1;
			}
			
			System.out.printf("El número %d es : %d \n", i + 1, datos[i]);
			
		}

	}

}
