package EjercicioEx2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Espacio extends Rectangle {

	public Espacio(int posX, int posY, int anchura, int altura) {
		super(posX, posY, anchura, altura);
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

}
