package Ejercicio002;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Puzle extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosPiezas;
	Image ayuda;


	// Crear objetos

	List<Pieza> piezas;
	List<Posicion> posiciones;

	// Crear variables
	int piezaCogida;
	int tiempo;

	boolean coger;
	boolean ganar;
	boolean perder;
	boolean necesitarAyuda;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1500, 600);
		noSeVe = imagen.getGraphics();

		random = new Random();

		dibujosPiezas = new Image[25];
		for (int i = 0; i < dibujosPiezas.length; i++) {
			dibujosPiezas[i] = getImage(getDocumentBase(), "Sprites2/" + (i + 1) + ".png");
		}

		ayuda = getImage(getDocumentBase(), "Sprites2/mapamundi3.png");

		posiciones = new ArrayList<Posicion>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				posiciones.add(new Posicion((j * 60) + 900, (i * 60) + 100));
			}
		}
		piezas = new ArrayList<Pieza>();
		for (int i = 0; i < 25; i++) {
			piezas.add(
					new Pieza((int) (Math.random() * 600) + 100, (int) (Math.random() * 400) + 100, dibujosPiezas[i]));
		}
		
		ganar = false;
		perder = false;
		necesitarAyuda = false;

		tiempo = 0;

		this.resize(1500, 600);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el ratos
	public void run() {
		do {
			// Todas las llamadas a los movimientos de los objetos

			if (!ganar) {
				tiempo += 20;
			}

			perder();
			ganar();

			colocar();

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
		noSeVe.fillRect(0, 0, 1500, 600);

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("Tiempo: " + tiempo / 1000, 50, 50);
		noSeVe.drawString("¡Corre! ¡Tienes 45 segundo para completarlo!", 200, 50);
		noSeVe.drawString("Pulsa A para recibir una ayuda", 970, 50);

		// Todas las llamadas a los metodos dibujar de los objetos
		if (necesitarAyuda) {
			noSeVe.drawImage(ayuda, 900, 100, 300, 300, this);
		}
		
		for (int i = 0; i < posiciones.size(); i++) {
			posiciones.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < piezas.size(); i++) {
			piezas.get(i).dibujar(noSeVe, this);
		}

		if (ganar) {
			noSeVe.drawString("Has ganado  :)", 300, 300);
			noSeVe.drawString("Tu tiempo ha sido: " + tiempo / 1000 + " segundos", 265, 320);
		}

		if (perder) {
			noSeVe.drawString("Has perdido  :(", 300, 300);
			noSeVe.drawString("Buen intento pero eres malisimo", 280, 320);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public void colocar() {
		for (int i = 0; i < piezas.size(); i++) {
			if (posiciones.get(i).contains(piezas.get(i).x + 30, piezas.get(i).y + 30)) {
				piezas.get(i).x = posiciones.get(i).x;
				piezas.get(i).y = posiciones.get(i).y;
			}
		}
	}

	public void ganar() {
		int numPiezasColocadas = 0;
		for (int i = 0; i < piezas.size(); i++) {
			if (piezas.get(i).x == posiciones.get(i).x && piezas.get(i).y == posiciones.get(i).y) {
				numPiezasColocadas++;
			}
		}
		if (numPiezasColocadas == 25) {
			ganar = true;
		}
	}

	public void perder() {
		if (tiempo / 1000 >= 45) {
			perder = true;
		}
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < piezas.size(); i++) {
			if (piezas.get(i).contains(x, y)) {
				piezaCogida = i;
			}
		}
		return true;
	}

	@Override
	public boolean mouseDrag(Event evt, int x, int y) {

		piezas.get(piezaCogida).y = y - 30;
		piezas.get(piezaCogida).x = x - 30;
		return true;
	}

	@Override
	public boolean mouseUp(Event evt, int x, int y) {
		coger = true;
		return true;
	}
	
	@Override
	public boolean keyDown(Event evt, int key) {
		if (key == 97 || key == 65) {
			necesitarAyuda = true;
		}
		return true;
	}

	@Override
	public boolean keyUp(Event evt, int key) {
		necesitarAyuda = false;
		return true;
	}

}