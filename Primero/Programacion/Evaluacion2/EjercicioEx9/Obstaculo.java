package EjercicioEx9;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Obstaculo extends Rectangle {

	Color color;

	Random random;

	int vel;

	public Obstaculo(int posX) {
		super(posX, 0, 40, 70);

		random = new Random();

		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
		vel = 5;

	}

	public void actualizar() {
		y += vel;
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
