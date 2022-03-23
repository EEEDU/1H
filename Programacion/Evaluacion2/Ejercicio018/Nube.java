package Ejercicio018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Nube extends Rectangle {

	Color color;

	int velX;

	Random random;

	boolean izquierda;

	public Nube(int posY) {
		super((int) (Math.random() * 900), posY, 50, 20);

		color = Color.RED;
		random = new Random();
		velX = (int) (Math.random() * 5) + 4;

		izquierda = true;

	}

	public void actualizar() {
		if (izquierda) {
			if (x >= 0) {
				x -= velX;
			} else {
				izquierda = false;
			}
		} else {
			if (x <= 900 - width) {
				x += velX;
			} else {
				izquierda = true;
			}
		}
	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);

	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}