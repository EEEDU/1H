package Ejercicio002;

public class SobreAnimales {

	public static void main(String[] args) {
		Perro animal1 = new Perro(1, "15/09/2002", "omnivoro", "Edu", "Labrador", true);
		Canguro animal2 = new Canguro(2, "16/12/2020", "herviboro", "Ana", 12, 43);
		animal1.habla();
		animal2.habla();
	}

}
