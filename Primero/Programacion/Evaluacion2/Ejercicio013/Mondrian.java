package Ejercicio013;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

public class Mondrian extends Applet implements Runnable {

	public static final int ARRIBA = 0;
	public static final int ABAJO = 1;
	public static final int IZQUIERDA = 2;
	public static final int DERECHA = 3;
	int direccion;
	Thread animacion;
	int posX, posY;
	Image imagen;
	Graphics noSeVe;

	public void init() {
		posX = 80;
		posY = 100;
		direccion = DERECHA;
		imagen = this.createImage(300, 300);
		noSeVe = imagen.getGraphics();
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			actualizar();
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
			}
			
		} while (true);
	}

	public void actualizar() {
		switch (direccion) {
		case ARRIBA:
			posY--;
			if (posY <= 50) {
				direccion = IZQUIERDA;
			}
			break;
		case ABAJO:
			posY++;
			if (posY >= 150) {
				direccion = DERECHA;
			}
			break;
		case DERECHA:
			posX++;
			if (posX >= 150) {
				direccion = ARRIBA;
			}
			break;
		case IZQUIERDA:
			posX--;
			if (posX <= 50) {
				direccion = ABAJO;
			}
			break;
		}
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 300, 300);
		noSeVe.setColor(Color.YELLOW);
		noSeVe.fillRect(0, 0, 90, 90);
		noSeVe.fillRect(250, 0, 40, 190);
		noSeVe.fillRect(200, 10, 20, 20);
		noSeVe.setColor(Color.BLUE);
		noSeVe.fillRect(80, 200, 220, 90);
		noSeVe.fillRect(100, 10, 90, 80);
		noSeVe.setColor(Color.LIGHT_GRAY);
		noSeVe.fillRect(posX, posY, 110, 90);
		noSeVe.setColor(Color.RED);
		noSeVe.fillRect(100, 100, 45, 45);
		noSeVe.fillRect(0, 110, 70, 200);
		noSeVe.setColor(Color.MAGENTA);
		noSeVe.fillRect(200, 55, 60, 135);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}
}
