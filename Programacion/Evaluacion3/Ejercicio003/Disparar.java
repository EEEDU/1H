package Ejercicio003;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Disparar extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image dibujoArquero;
	Image dibujoFlecha;
	Image[] dibujosGlobos;
	// Crear objetos

	Arquero arquero;
	List<Flecha> flechas;
	List<Globo> globos;

	// Crear variables

	int tiempo;
	int tiempoEspera;
	int puntuacion;
	int numFlechas;

	boolean poderDisparar;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		random = new Random();

		dibujosGlobos = new Image[4];
		for (int i = 0; i < dibujosGlobos.length; i++) {
			dibujosGlobos[i] = getImage(getDocumentBase(), "Sprites3/globo" + (i + 1) + ".jpg");
		}

		dibujoArquero = getImage(getDocumentBase(), "Sprites3/arquero.jpg");
		dibujoFlecha = getImage(getDocumentBase(), "Sprites3/flecha.jpg");

		globos = new ArrayList<Globo>();
		arquero = new Arquero(dibujoArquero);
		flechas = new ArrayList<Flecha>();

		tiempo = 0;
		tiempoEspera = 0;
		puntuacion = 0;
		numFlechas = 20;
		poderDisparar = true;

		this.resize(900, 600);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el ratos
	public void run() {
		do {

			tiempo += 20;

			if (tiempo % 1000 == 0) {
				crearGlobo();
			}

			tiempoEspera += 20;

			if (tiempoEspera >= 500) {
				poderDisparar = true;
			}

			// Todas las llamadas a los movimientos de los objetos

			for (int i = 0; i < flechas.size(); i++) {
				flechas.get(i).actualizar();
			}

			for (int i = 0; i < globos.size(); i++) {
				globos.get(i).actualizar();
			}

			perder();
			chocar();

			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	// Dibujar, cuanto mas abajo mas superpuesto
	public void paint(Graphics g) {

		// Pintar pantalla
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("Globos esplotados: " + puntuacion, 50, 50);
		noSeVe.drawString("Tienes " + numFlechas + " flechas", 300, 50);

		if (numFlechas == 0) {
			noSeVe.setColor(Color.BLACK);
			noSeVe.drawString("Has acertado " + puntuacion + " de 20", 425, 300);
		}

		// Todas las llamadas a los metodos dibujar de los objetos
		for (int i = 0; i < flechas.size(); i++) {
			flechas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < globos.size(); i++) {
			globos.get(i).dibujar(noSeVe, this);
		}

		arquero.dibujar(noSeVe, this);

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public void perder() {

	}

	public void crearFlecha() {
		if (poderDisparar && numFlechas > 0) {
			flechas.add(new Flecha(arquero.y, dibujoFlecha));
			tiempoEspera = 0;
			poderDisparar = false;
			numFlechas--;
		}

	}

	public void crearGlobo() {
		globos.add(new Globo((int) (Math.random() * 300) + 500, dibujosGlobos[(int) (Math.random() * 4)]));
	}

	public void chocar() {
		for (int i = 0; i < globos.size(); i++) {
			for (int j = 0; j < flechas.size(); j++) {
				if (globos.get(i).contains(flechas.get(j).x + 100, flechas.get(j).y + 25)) {
					globos.remove(i);
					puntuacion++;
				}
			}
		}

		for (int i = 0; i < globos.size(); i++) {
			if (globos.get(i).y <= -20) {
				globos.remove(i);
			}
		}

		for (int i = 0; i < flechas.size(); i++) {
			if (flechas.get(i).x >= 1000) {
				flechas.remove(i);
			}
		}
	}

	@Override
	public boolean mouseMove(Event evt, int x, int y) {
		arquero.y = y;
		return true;
	}

	@Override
	public boolean keyDown(Event evt, int key) {
		if (key == 32) {
			crearFlecha();
		}
		return true;
	}
}
