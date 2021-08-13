package Ejercicio001;

public class Casa {
	private String direccion;
	private int numMetros;
	private int numHabitaciones;
	private int numBaños;
	// private es un modificador que sirve para encapsular, proteger

	// Metodo constructor (no devuelve nada) sirve para introducir datos
	public Casa(String dir, int numMet, int numHab) {
		direccion = dir;
		numMetros = numMet;
		numHabitaciones = numHab;
	}

	public Casa(String dir, int numMet, int numHab, int numBañ) {
		direccion = dir;
		numMetros = numMet;
		numHabitaciones = numHab;
		numBaños = numBañ;
	}

	/*
	 * get se utiliza como una funcion para poder utilizar una variable private en
	 * otra clase
	 */
	public String getDireccion() {
		return direccion;
	}

	public int getNumMetros() {
		return numMetros;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public int getNumBaños() {
		return numBaños;
	}

	/*
	 * set se utiliza como un metodo para poder modificar una variable private desde
	 * otra clase
	 */
	public void setDireccion(String dir) {
		direccion = dir;
	}

	public void setNumMetros(int numMet) {
		numMetros = numMet;
	}

	public void setNumHabitaciones(int numHab) {
		numHabitaciones = numHab;
	}

	public void setNumBaños(int numBañ) {
		numBaños = numBañ;
	}

	public void mostrar() {
		System.out.printf("Casa situada en %s con %d metros y %d habitaciones", direccion, numMetros, numHabitaciones);
		System.out.println();
	}
}
