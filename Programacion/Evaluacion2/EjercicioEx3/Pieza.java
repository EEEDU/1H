package EjercicioEx3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pieza extends Rectangle {
	Color color;

	int limX, limY;
	boolean dosPiezas;

	int posY2;
	int posX2;

	public static int velPieza = 15;

	public Pieza(int anchura, int altura, Color color, boolean dosPiezas) {
		super(270, 0, anchura, altura);

		this.color = color;

		if (color == Color.PINK) {
			posY2 = y + 30;
			posX2 = x + 30;
		}

		this.dosPiezas = dosPiezas;

		if (dosPiezas) {
			limX = 600 - width;
			limY = 900 - height * 2;
		} else {
			limX = 600 - width;
			limY = 900 - height;
		}
	}

	public void actualiza() {

		if (y != limY) {
			y += velPieza;
		}

	}

	public void dibujar(Graphics g) {
		if (dosPiezas) {
			g.setColor(color);
			if (color == Color.PINK) {
				g.fillRect(x, y, width, height);
				g.fillRect(x + 30, y + 30, width - 60, height);
			} else if (color == Color.ORANGE) {
				g.fillRect(x, y, width, height);
				g.fillRect(x, y + 30, width - 60, height);
			} else if (color == Color.BLUE) {
				g.fillRect(x, y, width, height);
				g.fillRect(x + 60, y + 30, width - 60, height);
			} else if (color == Color.RED) {
				g.fillRect(x, y, width, height);
				g.fillRect(x + 30, y + 30, width, height);
			} else if (color == Color.GREEN) {
				g.fillRect(x, y, width, height);
				g.fillRect(x - 30, y + 30, width, height);
			}
		} else {
			g.setColor(color);
			g.fillRect(x, y, width, height);
		}
	}

	public int getLimY() {
		return limY;
	}

	public void setLimY(int limY) {
		this.limY = limY;
	}

	public static int getVelPieza() {
		return velPieza;
	}

	public static void setVelPieza(int velPieza) {
		Pieza.velPieza = velPieza;
	}
}
