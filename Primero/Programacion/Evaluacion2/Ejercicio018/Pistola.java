package Ejercicio018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pistola extends Rectangle {

	Color color;

	public Pistola() {
		super(450, 800, 40, 40);

		color = Color.GRAY;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.fillRect(x + 10, y - 10, width - 20, height - 10);

	}

}