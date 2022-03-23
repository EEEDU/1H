package EjercicioEx5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rey extends Rectangle {

	Color color;

	public Rey(int posX, int posY, Color color) {
		super(posX, posY, 100, 100);

		this.color = color;

	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x + 25, y + 40, width - 50, height - 50);
		g.fillRect(x + 45, y + 10, width - 90, height - 60);
		g.fillRect(x + 25, y + 20, width - 50, height - 90);
	}

}

