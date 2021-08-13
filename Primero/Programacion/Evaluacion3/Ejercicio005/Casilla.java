package Ejercicio005;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle {

	// Variables del objeto
	int numCasilla;
	String frase;
	Color color;
	boolean esNumero;
	boolean esFrase;

	public Casilla(int posX, int posY, int anc, int alt, int numCas, boolean esRoj) {
		super(posX, posY, anc, alt);

		elegirColor(esRoj);
		esNumero = true;
		esFrase = false;
		numCasilla = numCas;
	}

	public Casilla(int posX, int posY, int anc, int alt, int numCas) {
		super(posX, posY, anc, alt);

		color = Color.GREEN;
		esNumero = true;
		esFrase = false;
		numCasilla = numCas;
	}

	public Casilla(int posX, int posY, int anc, int alt, boolean esRoj) {
		super(posX, posY, anc, alt);

		elegirColor(esRoj);
		esNumero = false;
		esFrase = false;
	}

	public Casilla(int posX, int posY, int anc, int alt, String fra) {
		super(posX, posY, anc, alt);

		color = Color.WHITE;
		esNumero = false;
		esFrase = true;
		frase = fra;
	}

	// Dibujar objeto
	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		g.setColor(Color.WHITE);
		if (esNumero) {
			g.setFont(new Font("Arial", Font.PLAIN, 24));
			g.drawString("" + numCasilla, x + (width / 2 - 10), y + height / 2 + 10);
		}
		if (esFrase) {
			g.setColor(Color.BLACK);
			g.drawString(frase, x + (width / 2 - 20), y + height / 2);
		}
	}

	public void elegirColor(boolean esRoj) {
		if (esRoj) {
			color = Color.RED;
		} else {
			color = Color.BLACK;
		}
	}
}