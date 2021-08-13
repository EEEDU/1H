package Ejercicio023;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pasar extends Rectangle {

	Color color;
	int vel;

	public Pasar() {
		super(900, 0, 40, 600);

		color = Color.WHITE;
		vel = 5;

	}

	public void actualizar() {
		x -= vel;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
