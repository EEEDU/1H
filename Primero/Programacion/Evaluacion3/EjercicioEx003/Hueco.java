package EjercicioEx003;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Hueco extends Rectangle {

	// Variables del objeto
	public Hueco(int posX, int posY) {
		super(posX, posY, 50, 50);

	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
