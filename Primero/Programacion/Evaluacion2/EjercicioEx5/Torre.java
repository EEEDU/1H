package EjercicioEx5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Torre extends Rectangle {

	Color color;

	public Torre(int posX, int posY, Color color) {
		super(posX, posY, 100, 100);

		this.color = color;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x + 25, y + 10, width - 50, height - 20);

	}

}
