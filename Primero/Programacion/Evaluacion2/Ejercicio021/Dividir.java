package Ejercicio021;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Dividir extends Applet implements Runnable {

	List<Pelota> pelotas;

	Thread animacion;
	int numeroPelotas = 1;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		pelotas = new ArrayList<Pelota>();

		pelotas.add(new Pelota(0, 0, 200, 200));

		this.resize(900, 600);
	}

	private void crearPelotas(int posX, int posY, int anchura, int altura) {
		for (int i = 0; i < 2; i++) {
			pelotas.add(new Pelota(posX + (i * anchura / 2), posY, anchura / 2, altura / 2));
		}
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			for (int i = 0; i < pelotas.size(); i++) {
				pelotas.get(i).actualizar();
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);

		for (int i = 0; i < pelotas.size(); i++) {
			pelotas.get(i).dibujar(noSeVe);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < pelotas.size(); i++) {
			if (pelotas.get(i).contains(x, y)) {
				if (pelotas.get(i).width >= 25) {
					crearPelotas(pelotas.get(i).x, pelotas.get(i).y, pelotas.get(i).width, pelotas.get(i).height);
				}
				pelotas.remove(i);

			}
		}
		return true;
	}

}
