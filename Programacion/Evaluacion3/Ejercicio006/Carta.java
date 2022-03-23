package Ejercicio006;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int posicionX, posicionY;
	int valor;

	public Carta(int posX, int posY, Image dib, int val) {
		super(posX, posY, 100, 150);

		posicionX = posX;
		posicionY = posY;
		valor = val;

		if (valor > 10) {
			valor = 10;
		}

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
