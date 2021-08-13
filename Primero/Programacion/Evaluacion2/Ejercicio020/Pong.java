package Ejercicio020;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Pong extends Applet implements Runnable {

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;

	Pelota pelota;
	Raqueta raqueta1;
	Raqueta raqueta2;

	int puntos1;
	int puntos2;
	int velocidadRaqueta;

	boolean empezar;
	boolean sacar;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		pelota = new Pelota();

		raqueta1 = new Raqueta(50);
		raqueta2 = new Raqueta(830);

		empezar = false;
		sacar = true;
		puntos1 = 0;
		puntos2 = 0;
		velocidadRaqueta = 40;

		this.resize(900, 600);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();

			if (empezar) {
				pelota.actualizar(raqueta1.y + 40, raqueta2.y + 40, sacar);
			}

			chocar();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.BLACK);
		noSeVe.fillRect(0, 0, 900, 600);

		pelota.dibujar(noSeVe);
		raqueta1.dibujar(noSeVe);
		raqueta2.dibujar(noSeVe);


		if (!empezar) {
			noSeVe.drawString("Haz clic para jugar", 500, 200);
		}

		noSeVe.drawString("" + puntos1, 400, 20);
		noSeVe.drawString("" + puntos2, 500, 20);

		noSeVe.drawLine(450, 0, 450, 600);

		if (puntos1 >= 10) {
			noSeVe.drawString("Jugador 1 gana", 200, 300);
			pelota = null;
		}
		if (puntos2 >= 10) {
			noSeVe.drawString("Jugador 2 gana", 500, 300);
			pelota = null;
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		empezar = true;
		return true;
	}

	public boolean keyDown(Event evt, int key) {
		switch (key) {
		case 1004:
			raqueta2.actualizar(true, velocidadRaqueta);
			break;
		case 1005:
			raqueta2.actualizar(false, velocidadRaqueta);
			break;
		case 119:
			raqueta1.actualizar(true, velocidadRaqueta);
			break;
		case 115:
			raqueta1.actualizar(false, velocidadRaqueta);
			break;

		default:
			break;
		}

		if (!sacar && key == 32) {
			sacar = true;
		}


		return true;
	}

	public boolean chocar() {
		if (pelota.intersects(raqueta1)) {
			if (pelota.getDireccion() == IZQUIERDA_ABAJO) {
				pelota.setDireccion(DERECHA_ABAJO);
			}
			if (pelota.getDireccion() == IZQUIERDA_ARRIBA) {
				pelota.setDireccion(DERECHA_ARRIBA);
			}
		}

		if (pelota.intersects(raqueta2)) {
			if (pelota.getDireccion() == DERECHA_ABAJO) {
				pelota.setDireccion(IZQUIERDA_ABAJO);
			}
			if (pelota.getDireccion() == DERECHA_ARRIBA) {
				pelota.setDireccion(IZQUIERDA_ARRIBA);
			}
		}
		if (pelota.x >= pelota.getLimX() + pelota.vel) {
			puntos1++;
			velocidadRaqueta += 2;
			pelota.vel += 1;
			sacar = false;
			pelota.x = 780;
		} else if (pelota.x <= 0) {
			puntos2++;
			velocidadRaqueta += 2;
			pelota.vel += 1;
			sacar = false;
			pelota.x = 100;
		}
		return true;
	}
}

