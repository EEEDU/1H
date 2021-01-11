package BuclesAnidados;
/* 
 * Mostrar el pico más alto en que peli y que dia fue y lo mismo con el pico más bajo
 */

public class Ejercicio034 {

	public static void main(String[] args) {
		
		int salas[][] = {{10, 20, 30, 40, 45, 12, 74}, {50, 60, 70, 80, 85, 65, 43}, {90, 100, 110, 120, 125, 108, 190}, {109, 200, 170, 160, 111, 190, 201}};
		String dia[] = {"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
		String peli[] = {"Peli1", "Peli2", "Peli3", "Peli4"};
		int max[] = {0, 0}, min[] = {0, 0}; //maxPeli == max[0] && maxDia == max[1]
		
		for (int i = 0; i < salas.length; i++) {
			
			for (int j = 1; j < salas[i].length; j++) {
				
				if (salas[max[0]][max[1]] < salas[i][j]) {
					max[0] = i;
					max[1] = j;
				}
				
				else if (salas[min[0]][min[1]] > salas[i][j]) {
					min[0] = i;
					min[1] = j;
				}
				
			}
			
		}
		
		System.out.printf("Se llego al pico más alto el día %s en la peli %s y se vendio %d \n", dia[max[1]], peli[max[0]], salas[max[0]][max[1]]);
		System.out.printf("Se llego al pico más bajo el día %s en la peli %s y se vendio %d \n", dia[min[1]], peli[min[0]], salas[min[0]][min[1]]);

	}

}
