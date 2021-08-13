package EjercicioEx8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota extends Rectangle {

	Color color;

	int limX = 900 - 30;

	Random random;

	public static final int DERECHA_ABAJO = 0;
	public static final int IZQUIERDA_ABAJO = 1;
	int direccion;

	int vel;

	public Pelota() {
		super((int) (Math.random() * 800) + 50, -30, 30, 30);

		random = new Random();
		color();

		direccion = random.nextInt(2);

		vel = 3;
	}

	public Color color() {
		return color = new Color(random.nextInt(200) + 55, random.nextInt(200) + 55, random.nextInt(200) + 55);
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar() {
		switch (direccion) {
		case DERECHA_ABAJO:
			x += vel;
			y += vel;
			if (x >= limX) {
				direccion = IZQUIERDA_ABAJO;
				color();
			}
			break;
		case IZQUIERDA_ABAJO:
			x -= vel;
			y += vel;
			if (x <= 0) {
				direccion = DERECHA_ABAJO;
				color();
			}
			break;
		}
	}
}
