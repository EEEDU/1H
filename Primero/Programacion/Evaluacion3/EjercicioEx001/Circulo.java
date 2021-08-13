package EjercicioEx001;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Circulo extends Rectangle {

	// Variables del objeto
	Image dibujo;
	int vel;

	public Circulo() {
		super(200, 200, 200, 200);
	}

	// Dibujar objeto
	public void dibujar(Graphics g, Applet applet) {
		g.setColor(Color.BLACK);
		g.fillOval(x, y, width, height);
	}
}
