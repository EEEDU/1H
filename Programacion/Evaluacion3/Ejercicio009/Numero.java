package Ejercicio009;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Numero extends Rectangle {

	// Variables del objeto

	int posicionX, posicionY;
	int numero;

	Color color;

	public Numero(int posX, int posY, int num) {
		super(posX, posY, 50, 50);

		posicionX = posX;
		posicionY = posY;

		numero = num;

		switch (num) {
			case 1 :
				color = Color.GREEN;
				break;
			case 2 :
				color = Color.YELLOW;
				break;
			case 3 :
				color = Color.ORANGE;
				break;
			default :
				color = Color.RED;
				break;
		}
	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("" + numero, x + 10, y + height - 5);
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
	}
}
