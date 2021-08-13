package Ejercicio002;

public class Canguro extends Animal {
	private int salto;
	private int velocidad;

	public int getSalto() {
		return salto;
	}

	public void setSalto(int sal) {
		salto = sal;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int vel) {
		velocidad = vel;
	}

	public Canguro(int id, String fecNac, String die, String nom, int sal, int vel) {
		super(id, fecNac, die, nom);
		salto = sal;
		velocidad = vel;
	}

	public void habla() {
		System.out.printf(
				"Boing, Boing, soy un canguro y salto %d m y alcanzo una velocidad de %d m/s, mi nombre es %s\n",
				salto,
				velocidad, getNombre());
	}
}
