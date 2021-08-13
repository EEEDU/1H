package Ejercicio008;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int posicionX, posicionY;
	int numeroCarta;

	public Carta(int posX, int posY, Image dib, int num) {
		super(posX, posY, 150, 150);

		posicionX = posX;
		posicionY = posY;
		numeroCarta = num;

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
		g.drawRect(x, y, width, height);
	}
}
