package Ejercicio016;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pajaro extends Rectangle {

	Color color;
	int velY;

	public Pajaro() {
		super(180, 280, 40, 40);

		color = Color.BLUE;
		velY = 5;

	}

	public void actualizar() {
		y += velY;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

}
