package EjercicioEx4;

import java.awt.Color;
import java.awt.Graphics;

import EjercicioEx4.Arkanoid.Rectangle;

public class Ladrillo extends Rectangle {

	boolean destroyed = false;

	Ladrillo(double x, double y) {
		this.x = x;
		this.y = y;
		this.anchura = BLOCK_WIDTH;
		this.altura = BLOCK_HEIGHT;
	}

	void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect((int) izquierda(), (int) arriba(), (int) anchura, (int) altura);
	}
}