package EjercicioEx004;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ficha extends Rectangle {

	// Variables del objeto

	int posicionX, posicionY;

	Color color;

	public Ficha(int posX, int posY, Color col) {
		super(posX, posY, 50, 50);

		posicionX = posX;
		posicionY = posY;

		color = col;
	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.black);
		g.drawOval(x, y, width, height);
	}
}
