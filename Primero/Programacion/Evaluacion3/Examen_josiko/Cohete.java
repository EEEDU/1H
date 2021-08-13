package Examen_josiko;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Cohete extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Cohete(int posX, int posY, Image dib) {
		super(posX, posY, 100, 100);

		dibujo = dib;
	}

	public void despegar(int vel) {
		y -= vel;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
