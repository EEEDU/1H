package EjercicioEx5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Peon extends Rectangle {

	Color color;

	public Peon(int posX, int posY, Color color) {
		super(posX, posY, 100, 100);

		this.color = color;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillOval(x + 20, y + 20, width - 40, height - 40);

	}

}
