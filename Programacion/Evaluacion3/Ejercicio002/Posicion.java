package Ejercicio002;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Posicion extends Rectangle {

	// Variables del objeto

	public Posicion(int posX, int posY) {
		super(posX, posY, 60, 60);

	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}
}