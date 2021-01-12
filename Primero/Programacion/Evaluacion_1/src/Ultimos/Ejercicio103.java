package Ultimos;
/*
 * Tienes 7 productos ya hay que aplicar el porcentaje dependiendo de su producto
 */

public class Ejercicio103 {

	public static void main(String[] args) {
		int[] producto = { 10, 30, 60, 80, 90, 110, 200 };
		for (int i = 0; i < producto.length; i++) {
			if (producto[i] <= 50) {
				producto[i] -= (producto[i] * 10) / 100;
				System.out.println("A el producto " + (i + 1)
						+ " se le ha aplicado un descuento de 10% y su precio es:"
						+ producto[i]);
			} else if (producto[i] >= 50 && producto[i] <= 100) {
				producto[i] -= (producto[i] * 20) / 100;
				System.out.println("A el producto " + (i + 1)
						+ " se le ha aplicado un descuento de 20% y su precio es:"
						+ producto[i]);
			} else if (producto[i] >= 50) {
				producto[i] -= (producto[i] * 30) / 100;
				System.out.println("A el producto " + (i + 1)
						+ " se le ha aplicado un descuento de 30% y su precio es:"
						+ producto[i]);
			}
		}
	}

}
