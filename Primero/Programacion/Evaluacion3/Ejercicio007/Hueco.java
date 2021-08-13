package Ejercicio007;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hueco extends Rectangle {

	// Variables del objeto

	int posicionX, posicionY;
	int palo;

	public Hueco(int posX, int pal) {
		super(700 + posX, 100, 100, 150);

		posicionX = posX;
		palo = pal;
		// palo = 1 --> trebol; palo = 2 --> picas;
		// palo = 3 --> corazones; palo = 4 -->picas

	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
