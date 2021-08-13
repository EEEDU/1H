package EjercicioEx004;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Dado extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Dado(int posX, int posY, Image dib) {
		super(posX, posY, 100, 100);

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
