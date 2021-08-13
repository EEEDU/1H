package Ejercicio005;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ruleta extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Ruleta(Image dib) {
		super(100, 100, 700, 700);

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}