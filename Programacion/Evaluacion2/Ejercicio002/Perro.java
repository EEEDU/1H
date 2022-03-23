package Ejercicio002;

public class Perro extends Animal {
	private String raza;
	private boolean peligrosidad;

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raz) {
		raza = raz;
	}

	public boolean peligrosidad() {
		return peligrosidad;
	}

	public void setPeligrosidad(boolean pel) {
		this.peligrosidad = pel;
	}

	public Perro(int id, String fecNac, String die, String nom, String raz, boolean pel) {
		super(id, fecNac, die, nom);
		raza = raz;
		peligrosidad = pel;
	}

	public void habla() {
		System.out.printf("Guau, guau, soy un perro de raza %s, nacie el %s y me llamo %s\n", raza,
				getFechaNacimiento(),
				getNombre());
	}
}
