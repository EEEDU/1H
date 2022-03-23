package Ejercicio003;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Globo extends Rectangle {

	// Variables del objeto
	Image dibujo;
	int vel;

	public Globo(int posX, Image dib) {
		super(posX, 600, 60, 60);

		vel = 3;

		dibujo = dib;
	}

	public void actualizar() {
		y -= vel;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
