package Ejercicio002;

public class Animal {
	private int ID;
	private String fechaNacimiento;
	private String dieta;
	private String nombre;

	public Animal(int id, String fecNac, String die, String nom) {
		ID = id;
		fechaNacimiento = fecNac;
		dieta = die;
		nombre = nom;
	}

	public String getDieta() {
		return dieta;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public int getID() {
		return ID;
	}

	public String getNombre() {
		return nombre;
	}

	public void setDieta(String die) {
		dieta = die;
	}

	public void setFechaNacimiento(String fecNac) {
		fechaNacimiento = fecNac;
	}

	public void setID(int id) {
		ID = id;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public void habla() {

	}
}
