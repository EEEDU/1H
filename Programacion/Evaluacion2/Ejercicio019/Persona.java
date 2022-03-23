package Ejercicio019;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Persona extends Rectangle {

	Color color;

	public Persona() {
		super(450, 800, 20, 20);

		color = Color.RED;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);

	}

}