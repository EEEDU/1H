package Ejercicio017;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Palabra extends Rectangle {

	Color color;

	int velX;

	Random random;

	public String palabra;

	public Palabra(int posY, String palabra) {
		super(900, posY, 50, 20);

		color = Color.YELLOW;
		random = new Random();
		velX = (int) (Math.random() * 5) + 4;

		this.palabra = palabra;
	}

	public void actualizar() {
		if (x >= 0) {
			x -= velX;
		}
	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawString(palabra, x + 10, y + 15);
	}

}
