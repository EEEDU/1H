package EjercicioEx8;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Persona extends Rectangle {

	Color color;

	public Persona() {
		super(450, 300, 40, 40);

		color = Color.BLACK;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
