package Ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ladrillo extends Rectangle {
	Color color;

	public Ladrillo(int posX, int posY, int anchura, int altura, Color color) {
		super(posX, posY, anchura, altura);

		this.color = color;

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}
}
