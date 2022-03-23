package Ejercicio018;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle {

	Color color;

	int velY;

	public Bala(int posX) {
		super(posX, 800, 5, 10);

		color = Color.BLACK;

		velY = 5;

	}

	public void actualizar() {
		y -= velY;
	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x, y, width, height);

	}

}