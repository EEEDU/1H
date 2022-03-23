package EjercicioEx2;

import java.awt.Color;
import java.awt.Graphics;

public class Cruz extends Espacio {

	public Cruz(int posX, int posY, int anchura, int altura) {
		super(posX, posY, anchura, altura);
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(x + 10, y + 10, width - 20, height - 20);
	}

}
