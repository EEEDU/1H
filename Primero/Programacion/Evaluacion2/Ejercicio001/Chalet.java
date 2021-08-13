package Ejercicio001;

public class Chalet extends Casa {
	// Chalet es una subclase de Casa (extends)
	// Hereda todo lo que tiene la clase Casa
	private int metrosJardin;
	private boolean piscina;

	public Chalet(String dir, int numMet, int numHab, int metJar, boolean piscina) {
		super(dir, numMet, numHab);
		// se tienen que poner en el mismo orden que en la superclase(Casa)
		metrosJardin = metJar;
		// this.piscina sirve para distingir la variable de la clase
		this.piscina = piscina;
	}

	public Chalet(String dir, int numMet, int numHab, int metJar) {
		super(dir, numMet, numHab);
		metrosJardin = metJar;
	}

	public Chalet(String dir, int numMet, int numHab, int metJar, boolean pis, int numBañ) {
		super(dir, numMet, numHab, numBañ);
		metrosJardin = metJar;
		piscina = pis;
	}


	public int getMetJardin() {
		return metrosJardin;
	}

	public boolean getPiscina() {
		return piscina;
	}

	public void setMetJardin(int metJar) {
		metrosJardin = metJar;
	}

	public void setPiscina(boolean pis) {
		piscina = pis;
	}

	public void mostrar() {
		if (piscina) {
			System.out.printf(
					"El chalet esta en %s tiene %d metros cuadrados con %d habitaciones y %d baños, ademas tiene %d metros en el jardin y tiene piscina\n",
					getDireccion(), getNumMetros(), getNumHabitaciones(), getNumBaños(), metrosJardin);
		} else {
			System.out.printf(
					"El chalet esta en %s tiene %d metros cuadrados con %d habitaciones y %d baños, ademas tiene %d metros en el jardin y no tiene piscina\n",
					getDireccion(), getNumMetros(), getNumHabitaciones(), getNumBaños(), metrosJardin);
		}
	}
}
