package EjercicioEx7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Carta extends Rectangle {

	Color color;

	public Carta(int posX, int posY) {
		super(posX, posY, 200, 250);

		color = Color.RED;
	}

	public void cambiarColor() {
		color = Color.WHITE;
	}

	public void vueltaColor() {
		color = Color.RED;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.BLACK);
		g.drawRect(x, y, width, height);
	}

}
