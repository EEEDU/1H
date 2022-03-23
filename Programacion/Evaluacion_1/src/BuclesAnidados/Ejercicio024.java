package BuclesAnidados;
/*
 * Mostrar resultado de los datos multiplicados por los multiplos
 */

public class Ejercicio024 {

	public static void main(String[] args) {
		
		int datos[] = {10, 20, 30, 40, 50, 60};
		int mul[] = {3, 5, 7};
		
		for (int i = 0; i < datos.length; i++) {
			
			System.out.println("Las multiplicaciones del " + datos[i] + ": ");
			
			for (int j = 0; j < mul.length; j++) {
				System.out.println(datos[i] + " * " + mul[j] + " = " + (datos[i] * mul[j]));
			}
			
		}
		
	}

}			