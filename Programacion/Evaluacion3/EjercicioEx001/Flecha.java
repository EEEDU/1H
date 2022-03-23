package EjercicioEx001;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

public class Flecha extends Rectangle {

	// Variables del objeto
	Image dibujo;
	int vel;
	boolean rotar;
	AffineTransform trans = new AffineTransform();

	AffineTransform identity = new AffineTransform();

	public Flecha(Image dib) {
		super(275, 700, 50, 150);

		dibujo = dib;

		vel = 0;
		rotar = false;
	}

	public void actualizar() {
		y -= vel;
	}

	public void rotar() {
		if (rotar) {

			trans.setTransform(identity);
			trans.rotate(Math.toRadians(0.5));
		}
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.drawImage(dibujo, x, y, width, height, applet);
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate(45 * Math.PI / 180.0, getWidth() / 2, getHeight() / 2);
		g2d.drawImage(this.getImage(), 0, 0, 400, 400, this);
	}
}
