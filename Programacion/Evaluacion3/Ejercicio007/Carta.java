package Ejercicio007;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int posicionX, posicionY;
	int valor, palo, color;

	public Carta(int posX, int posY, Image dib, int val, int pal) {
		super(posX, posY, 100, 150);

		posicionX = posX;
		posicionY = posY;
		valor = val;
		palo = pal;
		color = (pal - 1) % 3;
		// palo = 1 --> trebol; palo = 2 --> picas;
		// palo = 3 --> corazones; palo = 4 -->picas
		// color = 0 --> negro; color = 1 --> rojo;

		dibujo = dib;
	}


	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
