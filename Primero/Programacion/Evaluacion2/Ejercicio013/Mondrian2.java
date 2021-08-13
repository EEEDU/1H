package Ejercicio013;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Mondrian2 extends Applet implements Runnable {

	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	int[] posX = { 0, 250, 80, 80, 100, 80, 2000, 0, 200 };
	int[] posY = { 0, 0, 160, 220, 10, 100, 0, 110, 55 };
	int[] anchura = { 90, 49, 100, 220, 90, 110, 45, 70, 60 };
	int[] altura = { 90, 190, 120, 90, 80, 90, 45, 200, 135 };
	Color[] color = { Color.YELLOW, Color.YELLOW, Color.YELLOW, Color.BLUE, Color.BLUE,
			Color.LIGHT_GRAY,
			Color.RED,
			Color.RED, Color.MAGENTA };

	Rectangulo[] rectangulos;

	public void init() {
		imagen = this.createImage(300, 300);
		noSeVe = imagen.getGraphics();
		rectangulos = new Rectangulo[9];

		for (int i = 0; i < rectangulos.length; i++) {
			rectangulos[i] = new Rectangulo(posX[i], posY[i], anchura[i], altura[i], color[i]);
		}

	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			for (int i = 0; i < rectangulos.length; i++) {
				rectangulos[i].actualizar();
			}
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 300, 300);

		for (int i = 0; i < rectangulos.length; i++) {
			rectangulos[i].dibujar(noSeVe);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}
}
