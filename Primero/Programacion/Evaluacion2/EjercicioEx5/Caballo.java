package EjercicioEx5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Caballo extends Rectangle {

	Color color;

	public Caballo(int posX, int posY, Color color) {
		super(posX, posY, 100, 100);

		this.color = color;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillRect(x + 10, y + 10, width - 70, height - 20);
		g.fillRect(x + 10, y + 10, width - 20, height - 70);

	}

}

