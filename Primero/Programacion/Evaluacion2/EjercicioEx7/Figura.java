package EjercicioEx7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Figura extends Rectangle {

	int numFigura;
	Random random;

	public Figura(int posX, int posY) {
		super(posX, posY, 100, 100);

		random = new Random();

		this.numFigura = random.nextInt(3);
	}


	public void dibujar(Graphics g) {
		if (numFigura == 0) {
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		} else if (numFigura == 1) {
			g.setColor(Color.GREEN);
			g.fillOval(x, y, width, height);
		} else if (numFigura == 2) {
			g.setColor(Color.ORANGE);
			g.fillRect(x, y, width, height / 2);
		}
	}
}
