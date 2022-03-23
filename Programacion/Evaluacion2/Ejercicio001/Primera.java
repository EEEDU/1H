package Ejercicio001;

public class Primera {
	public static void main(String[] args) {
		Casa casa1, casa2;
		casa1 = new Casa("C/Delicias, nª26, 3ºD", 128, 13);
		casa2 = new Casa("C/Gimeno vizarra, nª6, 3ªB", 69, 5);

		casa1.mostrar();
		casa2.mostrar();

		casa2.setNumHabitaciones(2);
		System.out.println("Dirección de casa1: " + casa1.getDireccion());
		casa2.mostrar();

		casa2.setNumHabitaciones(3);
		casa2.mostrar();

		Chalet chalet1, chalet2;
		chalet1 = new Chalet("Aqui al lado", 150, 13, 300, true);
		chalet2 = new Chalet("Romareda", 45, 3, 12);
		Chalet chalet3 = new Chalet("al lado de mi casa", 12, 43, 123, true, 12);

		chalet1.mostrar();

		chalet1.setPiscina(false);
		chalet1.mostrar();

		chalet2.setNumHabitaciones(23);
		chalet2.mostrar();

		chalet3.mostrar();
	}
}
