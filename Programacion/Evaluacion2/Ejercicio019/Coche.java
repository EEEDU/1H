package Ejercicio019;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Coche extends Rectangle {

	Color color;

	int velX;

	Random random;

	boolean izquierda;

	public Coche(int posX, int posY, boolean izquierda, int puntuacion) {
		super(posX, posY, 50, 20);

		random = new Random();
		color = new Color(random.nextInt(155), random.nextInt(155), random.nextInt(155));

		velX = (int) (Math.random() * (7 + puntuacion)) + (6 + puntuacion);

		this.izquierda = izquierda;

	}


	public void actualizar() {
		if (izquierda) {
			if (x >= -50) {
				x -= velX;
			}
		} else {
			if (x <= 900) {
				x += velX;
			}
		}
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