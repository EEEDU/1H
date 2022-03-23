package Ejercicio022;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Asteroide extends Rectangle {

	Color color;


	Random random;

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;
	int direccion;

	int dimension;

	public Asteroide() {
		super((int) (Math.random() * 1000) + 900, (int) (Math.random() * 700) + 600, 50, 50);

		random = new Random();
		color();

	}

	public Color color() {
		return color = new Color(random.nextInt(155), random.nextInt(155), random.nextInt(155));
	}

	public void actualizar() {

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}


}
