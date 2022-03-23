package EjercicioEx8;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Esquivar extends Applet implements Runnable {
	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	List<Pelota> pelotas;
	Persona persona;

	int tiempo;
	int segundos;

	int repetirPelota;

	boolean perder;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		pelotas = new ArrayList<Pelota>();
		crearPelota();

		persona = new Persona();

		tiempo = 0;
		segundos = 0;

		repetirPelota = 800;

		perder = false;

		this.resize(900, 600);
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

			tiempo += 20;
			segundos += 20;

			if (tiempo >= repetirPelota) {
				tiempo = 0;
				crearPelota();
			}

			if (segundos % 3000 == 0 && segundos != 0 && repetirPelota > 100) {
				repetirPelota -= 100;
			}

			chocar();
			quitarPelota();
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

		persona.dibujar(noSeVe);

		if (perder) {
			persona = null;
			noSeVe.drawString("Has perdido", 400, 300);
			noSeVe.drawString("Has aguantado " + segundos / 1000 + " segundos", 360, 320);
		}

		noSeVe.drawString("Tiempo: " + segundos / 1000, 50, 50);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseMove(Event evt, int x, int y) {
		persona.x = x - 20;
		persona.y = y - 20;
		return true;
	}

	public void chocar() {
		for (int i = 0; i < pelotas.size(); i++) {
			if (persona.intersects(pelotas.get(i))) {
				perder = true;
			}
		}
	}

	public void quitarPelota() {
		for (int i = 0; i < pelotas.size(); i++) {
			if (pelotas.get(i).y >= 900) {
				pelotas.remove(i);
			}
		}
	}

	public void crearPelota() {
		pelotas.add(new Pelota());
	}
}
