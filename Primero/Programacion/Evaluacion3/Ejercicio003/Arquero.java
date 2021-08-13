package Ejercicio003;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Arquero extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Arquero(Image dib) {
		super(50, 250, 100, 100);

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}