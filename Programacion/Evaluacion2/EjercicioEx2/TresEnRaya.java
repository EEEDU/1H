package EjercicioEx2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class TresEnRaya extends Applet implements Runnable {

	List<Circulo> circulos;
	List<Cruz> cruces;
	List<Espacio> espacios;

	int[] posX = { 150, 350, 550 };
	int[] posY = { 150, 350, 550 };
	int anchura;
	int altura;
	boolean circulo;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 900);
		noSeVe = imagen.getGraphics();

		anchura = 200 - 2;
		altura = 200 - 2;
		circulo = true;

		circulos = new ArrayList<Circulo>();
		circulos.add(new Circulo(100, 20, 50, 50));
		cruces = new ArrayList<Cruz>();
		cruces.add(new Cruz(100, 60, 50, 50));

		espacios = new ArrayList<Espacio>();
		for (int i = 0; i < posX.length; i++) {
			for (int j = 0; j < posX.length; j++) {
				espacios.add(new Espacio(posX[i] + 1, posY[j] + 1, anchura, altura));
			}
		}
		this.resize(900, 900);
	}

	public void crearCirculo(int posX, int posY) {
		circulos.add(new Circulo(posX, posY, anchura, altura));
	}

	public void crearCruz(int posX, int posY) {
		cruces.add(new Cruz(posX, posY, anchura, altura));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 900);

		noSeVe.setColor(Color.BLACK);
		if (circulo) {
			noSeVe.drawString("==>", 80, 50);
		} else {
			noSeVe.drawString("==>", 80, 90);
		}

		for (int i = 0; i < circulos.size(); i++) {
			circulos.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < cruces.size(); i++) {
			cruces.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < espacios.size(); i++) {
			espacios.get(i).dibujar(noSeVe);
		}

		// Tablero de juego
		noSeVe.setColor(Color.black);
		noSeVe.drawLine(posX[1], posY[0], posX[1], posY[2] + 200);
		noSeVe.drawLine(posX[2], posY[0], posX[2], posY[2] + 200);
		noSeVe.drawLine(posX[0], posY[1], posX[2] + 200, posY[1]);
		noSeVe.drawLine(posX[0], posY[2], posX[2] + 200, posY[2]);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < espacios.size(); i++) {
			if (espacios.get(i).contains(x, y)) {
				if (circulo) {
					crearCirculo(espacios.get(i).x, espacios.get(i).y);
					circulo = false;
				} else {
					crearCruz(espacios.get(i).x, espacios.get(i).y);
					circulo = true;
				}
				espacios.remove(i);
			}
		}
		return true;
	}

}
