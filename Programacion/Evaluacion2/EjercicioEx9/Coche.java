package EjercicioEx9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Coche extends Rectangle {

	Color color;

	public Coche() {
		super(230, 750, 40, 70);

		color = Color.RED;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
