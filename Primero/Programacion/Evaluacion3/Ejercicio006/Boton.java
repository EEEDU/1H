package Ejercicio006;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Boton extends Rectangle {

	// Variables del objeto
	Image dibujo;

	int valor;
	String frase;
	Color color;

	public Boton(int posX, int posY, int anc, int alt, String fra, Color col) {
		super(posX, posY, anc, alt);

		frase = fra;
		color = col;
	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		g.setColor(color);
		g.fillOval(x, y, width, height);
		g.setColor(Color.white);
		g.drawString(frase, x + width / 4, y + height / 2);
	}
}
