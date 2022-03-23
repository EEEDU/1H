package Ejercicio016;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Tuberia extends Rectangle {

	Color color;
	Random random;
	int velX;

	public Tuberia(int posX, int posY, int altura) {
		super(posX, posY, 100, altura);

		color = Color.GREEN;
		velX = 7;

	}

	public void actualizar() {
		x -= velX;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

}
