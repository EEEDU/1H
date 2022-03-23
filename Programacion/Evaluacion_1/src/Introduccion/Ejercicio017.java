package Introduccion;
/*
 * Cambiar el orden de los datos de un vector 
 */

public class Ejercicio017 {

	public static void main(String[] args) {
		
		int datos[] = {10, 20, 30, 40, 50, 60};
		int x;
				
		for(int i = 0; i < (datos.length) / 2; i++) {
			
			x = datos[i];
			datos[i] = datos[(datos.length - 1) - i];
			datos[(datos.length - 1) - i] = x;
					
		}
		
		System.out.println("El orden de los datos es: ");

		for(int i = 0; i < datos.length; i++) {
			
			System.out.println(datos[i]);
			
		}
	
	}

}
