package Introduccion;
/*
 * Vector que va a calcular la media de los datos
 */

public class Ejercicio019 {

	public static void main(String[] args) {
		
		float datos[] = {4, 8, 6, 2, 10, 4};
		float media = 0;
		
		for(int i = 0; i < datos.length; i++) {
			
			media += datos[i];
			
		}
		media /= datos.length;
		
		System.out.printf("La media es:  %.2f \n", media);
		
		for(int i = 0; i < datos.length; i++) {
			
			if(datos[i] > media) {
				System.out.printf("%.2f es superior a la media\n", datos[i]);
			}
			
		}
	}

}
