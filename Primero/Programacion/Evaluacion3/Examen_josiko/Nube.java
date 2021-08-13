package Examen_josiko;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Nube extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Nube(int posX, int posY, Image dib) {
		super(posX, posY, 75, 50);

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
