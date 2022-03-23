package EjercicioEx6;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class OchoReinas extends Applet implements Runnable {

	List<Reina> reinas;

	public int posX, posY;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(800, 800);
		noSeVe = imagen.getGraphics();

		reinas = new ArrayList<Reina>();
		for (int i = 0; i < 8; i++) {
			reinas.add(new Reina(i * 100, 0));
		}

		posX = posY = 0;

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
//		noSeVe.setColor(Color.WHITE);
//		noSeVe.fillRect(0, 0, 800, 800);

for (int i = 0; i < reinas.size(); i++) {
	reinas.get(i).dibujar(noSeVe);
}
		pintarTablero();

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void pintarTablero() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (i % 2 == 0) {
					noSeVe.setColor(Color.LIGHT_GRAY);
					noSeVe.fillRect(posX, posY, 100, 100);
					posX += 100;

					noSeVe.setColor(Color.DARK_GRAY);
					noSeVe.fillRect(posX, posY, 100, 100);
					posX += 100;
				}
				if (i % 2 == 1) {
					noSeVe.setColor(Color.DARK_GRAY);
					noSeVe.fillRect(posX, posY, 100, 100);
					posX += 100;

					noSeVe.setColor(Color.LIGHT_GRAY);
					noSeVe.fillRect(posX, posY, 100, 100);
					posX += 100;
				}
			}
			posX = 0;
			posY += 100;
		}
	}

}