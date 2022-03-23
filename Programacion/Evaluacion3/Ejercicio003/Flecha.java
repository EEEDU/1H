package Ejercicio003;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Flecha extends Rectangle {

	// Variables del objeto
	Image dibujo;
	int vel;

	public Flecha(int posY, Image dib) {
		super(50, posY, 100, 50);

		vel = 7;

		dibujo = dib;
	}

	public void actualizar() {
		x += vel;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
