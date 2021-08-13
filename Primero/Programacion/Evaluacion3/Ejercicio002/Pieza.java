package Ejercicio002;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle {

	// Variables del objeto
	Image dibujos;

	public Pieza(int posX, int posY, Image dib) {
		super(posX, posY, 60, 60);

		dibujos = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujos, x, y, width, height, applet);
		g.drawRect(x, y, width, height);
	}
}
