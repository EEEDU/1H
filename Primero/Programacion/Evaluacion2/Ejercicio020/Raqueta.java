package Ejercicio020;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta extends Rectangle {
	Color color;

	public Raqueta(int posX) {
		super(posX, 50, 20, 100);

		color = Color.WHITE;

	}

	public void actualizar(boolean arriba, int vel) {
		if (arriba) {
			if (y <= 0) {
				vel = 0;
			}
			y = y - vel;
		} else {
			if (y >= 500) {
				vel = 0;
			}
			y = y + vel;
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
