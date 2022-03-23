package Ejercicio014;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Rebota extends Applet implements Runnable {

	List<Pelota> pelotas;

	Thread animacion;
	public static int cantidad = 10;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(400, 300);
		noSeVe = imagen.getGraphics();
		pelotas = new ArrayList<Pelota>();
		for (int i = 0; i < cantidad; i++) {
			pelotas.add(new Pelota());
		}
		this.resize(400, 300);
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
		noSeVe.fillRect(0, 0, 400, 300);
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
				pelotas.remove(i);
			}
		}
		return true;
	}
}
