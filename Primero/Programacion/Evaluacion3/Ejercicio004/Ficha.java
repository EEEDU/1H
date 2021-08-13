package Ejercicio004;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ficha extends Rectangle {

	// Variables del objeto
	Image dibujo;
	int numero;

	public Ficha(int posX, int posY, Image dib, int numero) {
		super(posX, posY, 100, 100);

		dibujo = dib;
		this.numero = numero;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
