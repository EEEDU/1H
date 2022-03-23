package Ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta extends Rectangle {
	Color color;
	int vel;

	public Raqueta() {
		super(0, 540, 200, 20);

		color = Color.DARK_GRAY;
		vel = 8;

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}