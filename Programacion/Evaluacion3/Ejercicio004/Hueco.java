package Ejercicio004;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hueco extends Rectangle {

	public Hueco(int posX, int posY) {
		super(posX, posY, 50, 50);

	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x + 25, y + 25, width, height);
	}
}

