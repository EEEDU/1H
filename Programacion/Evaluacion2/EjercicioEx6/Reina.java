package EjercicioEx6;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Reina extends Rectangle {

	Color color;

	public Reina(int posX, int posY) {
		super(posX, posY, 100, 100);

		color = Color.black;

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillOval(x + 20, y + 20, width - 40, height - 40);

	}

}

