package IntroduccionMetodos;
/*
 * Manipular funciones o metodos.
 */

public class Ejercicio046 {

	public static void main(String[] args) {
		//Los nombres de ls funciones empiezan por minuscula y no se puede empezar ni con numero ni signos
		//void: significa que no devuelve nada
		//public static: son modificadores
		//(String[] args): espera recibir un vecto de string
		
		String palabra;
		
		escribir();
		hablar("Buenos días");
		animalHabla("Me llamo conchita", "muuuu");
		palabra = concatenar("Hola Don Pepito", "Hola Don Jose");
		System.out.println(palabra);
		System.out.println("El resultado de suma es: " + suma(23, 4));
	}

	public static void escribir() {
		System.out.println("hola");	
	}
	
	public static void hablar(String frase) {
		System.out.println(frase);
	}

	public static void animalHabla(String frase, String onomatopeya) {
		System.out.println(frase + ". " + onomatopeya);
	}
	
	public static String concatenar(String frase1, String frase2) {
		return frase1 + ". " + frase2;
		//return: devolver String
	}
	
	public static int suma(int a, int b) {
		return a+b;
	}
}
