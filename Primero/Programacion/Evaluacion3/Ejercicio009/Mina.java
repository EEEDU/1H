package Ejercicio009;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Mina extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int posicionX, posicionY;
	int numeroCarta;

	public Mina(int posX, int posY, Image dib) {
		super(posX, posY, 50, 50);

		posicionX = posX;
		posicionY = posY;

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
