package Ejercicio010;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pelota extends Rectangle {

	// Variables del objeto
	Image dibujo;

	double velX, velY;

	public Pelota(int posX, int posY, Image dib) {
		super(posX, posY, 50, 50);

		velX = velY = 0;

		dibujo = dib;
	}

	public void obtenerVel(double velX, double velY) {
		this.velX = velX;
		this.velY = velY;
	}

	public void mover() {
		x += velX;
		y += velY;


	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
