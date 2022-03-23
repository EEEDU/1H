package EjercicioEx5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Alfil extends Rectangle {

	Color color;
	public int[] posicionX;
	public int[] posicionY;

	public Alfil(int posX, int posY, Color color) {
		super(posX, posY, 100, 100);

		this.color = color;
		posicionX = new int[] { posX + 50, posX + 30, posX + 70 };
		posicionY = new int[] { posY + 10, posY + 90, posY + 90 };

	}

	public void dibujar(Graphics g) {

		g.setColor(color);
		g.fillPolygon(posicionX, posicionY, posicionX.length);
	}

}

