package Ejemplo_programación_Examen2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle {
	private String palabra = "";
	private Color color = Color.yellow;
	int velX, velY;

	public Bala() {
		super((int) (Math.random() * 270), -(int) ((Math.random() * 300)), 10, 10);
		velX = ((int) (Math.random() * 11)) - 5;
		velY = (int) (Math.random() * 6) + 3;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar() {
		if ((x <= 0) || (x >= 290))
			velX = -velX;

		if (y > 300)
			y = -(int) ((Math.random() * 300));

		x += velX;
		y += velY;
	}
}