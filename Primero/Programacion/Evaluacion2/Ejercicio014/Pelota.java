package Ejercicio014;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota extends Rectangle {

	Color color;

	int limX = 400 - 30, limY = 300 - 30;
	Random random;

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;
	int direccion;

	int dimension;

	public Pelota() {
		super((int) (Math.random() * 250), (int) (Math.random() * 250), 0, 0);

		dimension = ((int) (Math.random() * 10) + 20);
		width = height = dimension;
		random = new Random();
		color();

		direccion = random.nextInt(4);

	}

	public Color color() {
		return color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar() {
		switch (direccion) {
		case DERECHA_ARRIBA:
			x++;
			y--;
			if (x >= limX) {
				direccion = IZQUIERDA_ARRIBA;
				color();

			} else if (y <= 0) {
				direccion = DERECHA_ABAJO;
				color();
			}
			break;
		case DERECHA_ABAJO:
			x++;
			y++;
			if (x >= limX) {
				direccion = IZQUIERDA_ABAJO;
				color();
			} else if (y >= limY) {
				direccion = DERECHA_ARRIBA;
				color();
			}
			break;
		case IZQUIERDA_ARRIBA:
			x--;
			y--;
			if (x <= 0) {
				direccion = DERECHA_ARRIBA;
				color();
			} else if (y <= 0) {
				direccion = IZQUIERDA_ABAJO;
				color();
			}
			break;
		case IZQUIERDA_ABAJO:
			x--;
			y++;
			if (x <= 0) {
				direccion = DERECHA_ABAJO;
				color();
			} else if (y >= limY) {
				direccion = IZQUIERDA_ARRIBA;
				color();
			}
			break;
		}
	}
}
