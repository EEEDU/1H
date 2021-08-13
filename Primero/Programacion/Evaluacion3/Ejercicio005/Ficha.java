package Ejercicio005;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ficha extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int posX, posY;
	int valor;

	public Ficha(int posX, int posY, Image dib, int val) {
		super(posX, posY, 60, 60);

		this.posX = posX;
		this.posY = posY;

		valor = val;

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
