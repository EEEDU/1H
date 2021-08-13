package EjercicioEx9;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Carretera extends Applet implements Runnable {
	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	Coche coche;
	List<Obstaculo> obstaculos;

	Random random;
	int[] posX = { 30, 130, 230, 330, 430 };

	int tiempo;
	int intervalo;

	boolean perder;

	int puntos;

	public void init() {
		imagen = this.createImage(500, 900);
		noSeVe = imagen.getGraphics();

		coche = new Coche();

		obstaculos = new ArrayList<Obstaculo>();

		crearObstaculo();

		random = new Random();

		tiempo = 0;
		intervalo = 2000;

		perder = false;

		puntos = 0;

		this.resize(500, 900);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			tiempo += 20;

			if (tiempo % intervalo == 0 && tiempo != 0) {
				crearObstaculo();
			}

			if (tiempo % 5000 == 0 && tiempo != 0) {
				intervalo -= 200;
			}

			for (int i = 0; i < obstaculos.size(); i++) {
				obstaculos.get(i).actualizar();
			}
			destruirObstaculo();
			chocar();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 500, 900);
		noSeVe.setColor(Color.LIGHT_GRAY);
		noSeVe.fillRect(0, 0, 500, 900);
		noSeVe.setColor(Color.WHITE);
		noSeVe.drawLine(100, 0, 100, 900);
		noSeVe.drawLine(200, 0, 200, 900);
		noSeVe.drawLine(300, 0, 300, 900);
		noSeVe.drawLine(400, 0, 400, 900);

		coche.dibujar(noSeVe);

		for (int i = 0; i < obstaculos.size(); i++) {
			obstaculos.get(i).dibujar(noSeVe);
		}

		if (perder) {
			coche = null;
		}

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("puntos: " + puntos / 2, 20, 50);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean keyUp(Event evt, int key) {
		if (key == 97 && coche.x >= 100) {
			coche.x -= 100;
		}
		if (key == 100 && coche.x <= 400) {
			coche.x += 100;
		}
		return true;
	}

	public void crearObstaculo() {
		obstaculos.add(new Obstaculo(posX[(int) (Math.random() * 2)]));
		obstaculos.add(new Obstaculo(posX[(int) (Math.random() * 3) + 2]));
	}

	public void chocar() {
		for (int i = 0; i < obstaculos.size(); i++) {
			if (coche.intersects(obstaculos.get(i))) {
				perder = true;
			}
		}
	}

	public void destruirObstaculo() {
		for (int i = 0; i < obstaculos.size(); i++) {
			if (obstaculos.get(i).y >= 900) {
				obstaculos.remove(i);
				puntos++;
			}
		}
	}

}
