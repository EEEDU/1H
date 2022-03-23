package BuclesAnidados;
/*
 * Mostrar por pantalla el empleado que mas cobra y su salario medio, lo mismo con el que menos
 * Mostrar por pantalla el mes que mas cobra y su salario medio, lo mismo con el que menos
 */

public class Ejercicio037 {

	public static void main(String[] args) {

		int salario[][] = {{700, 900, 1300, 800, 1000, 700},
						   {700, 1300, 800, 900, 750, 1450},
						   {800, 900, 1200, 850, 850, 1300},
						   {1200, 750, 800, 950, 1200, 800}};
		String empleado[] = {"Empleado1", "Empleado2", "Empleado3", "Empleado4"};
		String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
		int acum[][] = {{0, 0, 0, 0}, 
						{0, 0, 0, 0, 0, 0}}; //acumEmpleado[] == acum[0] && acumMes[] == acum[1]
		int max[] = {0, 0}, min[] = {0, 0}; //maxEmpleado[] == acum[0] && maxMes[] == acum[1]
		
		for (int i = 0; i < salario.length; i++) {
			
			for (int j = 0; j < salario[i].length; j++) {
				acum[0][i] += salario[i][j];
				acum[1][j] += salario[i][j];
			}
			
		}
		
		for (int i = 0; i < acum.length; i++) {
			
			for (int j = 0; j < acum[i].length; j++) {
				
				if (acum[i][max[i]] < acum[i][j]) {
					max[i] = j;
				}
				
				else if (acum[i][min[i]] > acum[i][j]) {
					min[i] = j;
				}
				
			}
			
		}
		
		System.out.printf("El empleado mejor pagado es %s con una media de salario de %d \n", empleado[max[0]], acum[0][max[0]] / acum[1].length);
		System.out.printf("El empleado peor pagado es %s con una media de salario de %d \n\n", empleado[min[0]], acum[0][min[0]] / acum[1].length);

		System.out.printf("El mes que mejor se paga es %s con una media de salario de %d \n", mes[max[1]], acum[1][max[1]] / acum[0].length);
		System.out.printf("El mes que peor se paga es %s con una media de salario de %d \n", mes[min[1]], acum[1][min[1]] / acum[0]. length);

	}

}
