package Ejercicio005;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ovalo {
	int posX, posY, anchura, altura;
	Color color;
	Random random;

	public Ovalo() {
		random = new Random();
		inicializar();
	}

	public void inicializar() {
		posX = random.nextInt(200);
		posY = random.nextInt(200);
		anchura = random.nextInt(100);
		altura = random.nextInt(100);
		color = new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(posX, posY, anchura, altura);
	}
}

