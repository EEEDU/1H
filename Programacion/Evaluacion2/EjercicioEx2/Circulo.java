package EjercicioEx2;

import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Espacio {

	public Circulo(int posX, int posY, int anchura, int altura) {
		super(posX, posY, anchura, altura);
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x + 10, y + 10, width - 20, height - 20);
	}

}
