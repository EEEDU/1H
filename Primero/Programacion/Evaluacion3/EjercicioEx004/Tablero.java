package EjercicioEx004;


import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Tablero extends Rectangle {

	// Variables del objeto
	Image dibujo;

	public Tablero(Image dib) {
		super(0, 0, 900, 900);

		dibujo = dib;
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}
}
