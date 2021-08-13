package EjercicioEx002;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;


public class JuegoDamas extends Applet implements Runnable {

	List<Cuadrado> cuadrados;

	List<Dama> damasB;
	List<Dama> damasN;

	int posX = 0, posY = 0;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(800, 800);
		noSeVe = imagen.getGraphics();

		crearTablero();
		crearDamas();

		this.resize(800, 800);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);

	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 800, 800);

		for (int i = 0; i < cuadrados.size(); i++) {
			cuadrados.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < damasB.size(); i++) {
			damasB.get(i).dibujar(noSeVe);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	private void crearTablero() {
		cuadrados = new ArrayList<Cuadrado>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (i % 2 == 0) {
					cuadrados.add(new Cuadrado(posX, posY, Color.LIGHT_GRAY));
					posX += 100;

					cuadrados.add(new Cuadrado(posX, posY, Color.DARK_GRAY));
					posX += 100;
				}
				if (i % 2 == 1) {
					cuadrados.add(new Cuadrado(posX, posY, Color.DARK_GRAY));
					posX += 100;

					cuadrados.add(new Cuadrado(posX, posY, Color.LIGHT_GRAY));
					posX += 100;
				}
			}
			posX = 0;
			posY += 100;
		}
	}

	private void crearDamas() {
		damasB = new ArrayList<Dama>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				damasB.add(new Dama(Guer(i * 200), (j * 100), Color.WHITE));
			}
		}
		damasN = new ArrayList<Dama>();
	}



	@Override
	public boolean mouseDrag(Event evt, int x, int y) {
		return true;
	}

	public boolean mouseUp(Event evt, int x, int y) {
		return true;
	}
}