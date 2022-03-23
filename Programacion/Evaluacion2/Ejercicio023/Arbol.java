package Ejercicio023;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Arbol extends Rectangle {

	Color color;
	int vel;

	public Arbol() {
		super(900, 530, 40, 70);

		color = Color.GREEN;
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
