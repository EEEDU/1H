package Ejercicio005;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Casino extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image dibujoRuleta;
	Image[] dibujoFichas;

	Button boton;
	// Crear objetos

	Ruleta ruleta;
	List<Casilla> casillas;
	List<Ficha> fichas;

	// Crear variable
	int tiempo;
	int numCasilla;
	int[] numRojos = { 1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36 };
	int[] numNegros = { 2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35 };
	int[] numFichas;
	int[] numApuesta;
	int numRuleta;
	int bola;
	int fichaCogida;

	boolean esRojo;
	boolean ganar;
	boolean coger;
	boolean tramposo;
	boolean moviendo;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1700, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();
		tiempo = 0;
		numCasilla = 1;
		numFichas = new int[10];
		for (int i = 0; i < numFichas.length; i++) {
			numFichas[i] = 10 - i;
		}
		numApuesta = new int[100];
		for (int i = 0; i < numApuesta.length; i++) {
			numApuesta[i] = 50;
		}
		numRuleta = 1;
		bola = 0;
		fichaCogida = 0;

		esRojo = false;
		ganar = false;
		coger = true;
		tramposo = false;

		dibujoRuleta = getImage(getDocumentBase(), "Sprites5/ruleta.png");

		dibujoFichas = new Image[10];
		for (int i = 0; i < dibujoFichas.length; i++) {
			dibujoFichas[i] = getImage(getDocumentBase(), "Sprites5/Fichas/ficha" + (i + 1) + ".png");
		}

		ruleta = new Ruleta(dibujoRuleta);

		casillas = new ArrayList<Casilla>();
		casillas.add(new Casilla(900, 49, 303, 50, 0));
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < numRojos.length; k++) {
					if (numCasilla == numRojos[k]) {
						esRojo = true;
					}
					if (numCasilla == numNegros[k]) {
						esRojo = false;
					}
				}
				casillas.add(new Casilla(900 + (100 * j) + j, 100 + (60 * i) + i, 100, 60, numCasilla, esRojo));
				numCasilla++;
			}
		}

		for (int i = 0; i < 2; i++) {
			casillas.add(new Casilla(1203, 100 + (100 * i) + i, 200, 100, esRojo));
			esRojo = false;

		}
		casillas.add(new Casilla(1203, 303, 200, 100, "PAR"));
		casillas.add(new Casilla(1203, 404, 200, 100, "IMPAR"));

		fichas = new ArrayList<Ficha>();
		for (int i = 0; i < dibujoFichas.length; i++) {
			fichas.add(new Ficha(1500, 60 + i * 75, dibujoFichas[i], i));
		}

		boton = new Button("TIRAR");
		this.setLayout(new BorderLayout());
		this.add("North", boton);

		this.resize(1700, 900);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el rato
	public void run() {
		do {

			tiempo += 20;

			if (tiempo % 1000 == 0) {
			}


			// Todas las llamadas a los movimientos de los objetos
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
		noSeVe.fillRect(0, 0, 1700, 900);

		// Todas las llamadas a los metodos dibujar de los objetos

		ruleta.dibujar(noSeVe, this);

		for (int i = 0; i < casillas.size(); i++) {
			casillas.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < fichas.size(); i++) {
			fichas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < numFichas.length; i++) {
			noSeVe.setColor(Color.BLACK);
			noSeVe.drawString("X " + numFichas[i], 1570, 100 + i * 75);
		}

		noSeVe.drawString("La bola esta en: " + bola, 650, 150);

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public void comprobar() {
		for (int i = 0; i < numApuesta.length; i++) {
			if (numApuesta[i] == 37) {
				for (int j = 0; j < numRojos.length; j++) {
					if (numRojos[j] == numRuleta) {
						ganar(fichas.get(i).valor, "rojo");
					}
				}
			}
			if (numApuesta[i] == 38) {
				for (int j = 0; j < numNegros.length; j++) {
					if (numNegros[j] == numRuleta) {
						ganar = true;
						ganar(i, "negro");
					}
				}
			}
			if (numApuesta[i] == 39) {
				if (numRuleta % 2 == 0) {
					ganar = true;
					ganar(i, "par");
				}
			}
			if (numApuesta[i] == 40) {
				if (numRuleta % 2 != 0) {
					ganar = true;
					ganar(i, "impar");
				}
			}
			if (numApuesta[i] == numRuleta) {
				ganar = true;
				ganar(i, "");
			}
			if (numApuesta[i] == 50) {

			}
			else {
				perder(i);
			}
			if (i > 100) {
				numRuleta -= numRuleta;
			}
		}
	}

	public void ganar(int i, String situacion) {
		if (numRuleta != 0 && situacion == "") {
			numFichas[i] *= 3;
		}
		if (numRuleta == 0) {
			numFichas[i] *= 5;
		}
		if (situacion == "rojo") {
			numFichas[i] += 3;
		}
		if (situacion == "negro") {
			numFichas[i] += 3;
		}
		if (situacion == "par") {
			numFichas[i] += 3;
		}
		if (situacion == "impar") {
			numFichas[i] += 3;
		}
	}

	public void perder(int i) {
		if (fichas.get(i).x != 1500) {
			numApuesta[i] = 50;
		}
		fichas.get(i).x = fichas.get(i).posX;
		fichas.get(i).y = fichas.get(i).posY;
	}

	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < fichas.size(); i++) {
			if (fichas.get(i).contains(x, y) && coger) {
				if (numFichas[fichas.get(i).valor] > 0) {
					fichaCogida = i;
					coger = false;
					
					if (numFichas[fichas.get(i).valor] > 1) {
						fichas.add(new Ficha(fichas.get(
								fichaCogida).posX,
							fichas.get(fichaCogida).posY,
								dibujoFichas[fichas.get(fichaCogida).valor], fichas.get(fichaCogida).valor));
					}
				}
				else {
					tramposo = true;
				}
				if (x < 1500) {
					moviendo = true;
				}
			}
		}
		return true;
	}

	@Override
	public boolean mouseDrag(Event evt, int x, int y) {

		fichas.get(fichaCogida).y = y - 30;
		fichas.get(fichaCogida).x = x - 30;

		return true;
	}

	@Override
	public boolean mouseUp(Event evt, int x, int y) {
		for (int j = 0; j < casillas.size(); j++) {
			if (casillas.get(j).contains(fichas.get(fichaCogida).x + 30, fichas.get(fichaCogida).y + 30)) {
				numApuesta[fichaCogida] = j;
			}
		}

		coger = true;
		if (tramposo) {
			fichas.get(fichaCogida).x = fichas.get(fichaCogida).posX;
			fichas.get(fichaCogida).y = fichas.get(fichaCogida).posY;
			tramposo = false;
		}
		if (numApuesta[fichaCogida] == 50 || fichas.get(fichaCogida).x >= 1500) {
			fichas.get(fichaCogida).x = fichas.get(fichaCogida).posX;
			fichas.get(fichaCogida).y = fichas.get(fichaCogida).posY;
			numApuesta[fichaCogida] = 50;
			numFichas[fichas.get(fichaCogida).valor]++;
		}
		if (moviendo) {
			numFichas[fichas.get(fichaCogida).valor]++;
			moviendo = false;
		}
		numFichas[fichas.get(fichaCogida).valor]--;
		return true;
	}

	public boolean action(Event evt, Object obj) {
		if (evt.target instanceof Button) {
			numRuleta = random.nextInt(36);
			bola = numRuleta;
			ganar = false;
			comprobar();
		}
		return false;
	}
}