package IntroduccionMetodos;
/*
 * TODO Tipos de metodos
 * Calculos con tablas, para de parametros a funciones.
 * 1. Realizar una funcion que reciba todos los salarios y que devuelva un vector, con el acumulado de lo que ha cobrado cada empleado.
 * 2. Realizar lo mismo pero la funcion no tiene que devolver nada.
 * 3. Lo mismo pero con los meses
 */


public class Ejercicio049 {

	public static void main(String[] args) {
		int salario[][] = { { 700, 900, 1300, 800, 1000, 700 }, { 700, 1300, 800, 900, 750, 1450 },
				{ 800, 900, 1200, 850, 850, 1300 }, { 1200, 750, 800, 950, 1200, 800 } };
		String empleado[] = { "Empleado1", "Empleado2", "Empleado3", "Empleado4" };
		String mes[] = { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio" };

		int acumEmpleado[] = salarioEmpleado(salario);
		int acumEmpleado2[] = new int[salario.length];
		salarioEmpleado2(salario, acumEmpleado2);

		System.out.printf("Salario de los empleados con el primer metodo\n");
		for (int i = 0; i < empleado.length; i++) {
			System.out.println("El " + empleado[i] + " ha cobrado: " + acumEmpleado[i]);
		}

		System.out.printf("\nSalario de los empleados con el segundo metodo\n");
		for (int i = 0; i < empleado.length; i++) {
			System.out.println("El " + empleado[i] + " ha cobrado: " + acumEmpleado2[i]);
		}

		int acumMes[] = salarioMes(salario);
		int acumMes2[] = new int[salario[0].length];
		salarioMes2(salario, acumMes2);

		System.out.printf("\nSalario de los meses con el primer metodo\n");
		for (int i = 0; i < mes.length; i++) {
			System.out.println("El " + mes[i] + " ha cobrado: " + acumMes[i]);
		}

		System.out.printf("\nSalario de los empleados con el segundo vector\n");
		for (int i = 0; i < mes.length; i++) {
			System.out.println("El " + mes[i] + " ha cobrado: " + acumMes2[i]);
		}
	}
	
	public static int[] salarioEmpleado(int[][] sueldo) {
		int acumEmpleado[] = new int[sueldo.length];

		for (int i = 0; i < sueldo.length; i++) {
			for (int j = 0; j < sueldo[i].length; j++) {
				acumEmpleado[i] += sueldo[i][j];
			}
		}

		return acumEmpleado;
	}

	public static void salarioEmpleado2(int[][] sueldo, int[] acumEmpleado) {
		for (int i = 0; i < sueldo.length; i++) {
			for (int j = 0; j < sueldo[i].length; j++) {
				acumEmpleado[i] += sueldo[i][j];
			}
		}
	}

	public static int[] salarioMes(int[][] sueldo) {
		int acumMes[] = new int[sueldo[0].length];

		for (int i = 0; i < sueldo.length; i++) {
			for (int j = 0; j < sueldo[i].length; j++) {
				acumMes[j] += sueldo[i][j];
			}
		}

		return acumMes;
	}

	public static void salarioMes2(int[][] sueldo, int[] acumMes) {
		for (int i = 0; i < sueldo.length; i++) {
			for (int j = 0; j < sueldo[i].length; j++) {
				acumMes[j] += sueldo[i][j];
			}
		}
	}

}
