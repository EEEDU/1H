package Ejercicio008;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Memory extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujoCartas;
	Image dibujoReverso;

	// Crear objetos

	List<Carta> cartas;
	List<Carta> reversos;

	// Crear variable
	int cantidad, cont;
	int numero1, numero2;
	int tiempo;
	int posX1, posY1, posX2, posY2;
	int[] numerosAleatorios, numerosOrden;

	boolean primera, inicioCrono, poderLevantar;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1000, 1000);
		noSeVe = imagen.getGraphics();

		random = new Random();

		cantidad = 16;
		cont = 0;
		tiempo = 0;
		posX1 = posX2 = posY1 = posY2 = 0;

		primera = true;
		inicioCrono = false;
		poderLevantar = true;
		numerosOrden = new int[16];
		numerosAleatorios = new int[16];
		for (int i = 0; i < numerosOrden.length; i++) {
			numerosOrden[i] = (i / 2) + 1;
		}
		desordenNumeros();

		dibujoCartas = new Image[8];
		for (int i = 0; i < dibujoCartas.length; i++) {
			dibujoCartas[i] = getImage(getDocumentBase(), "Sprites8/img" + (i + 1) + ".png");
		}
		dibujoReverso = getImage(getDocumentBase(), "Sprites8/reverso.png");

		cartas = new ArrayList<Carta>();
		reversos = new ArrayList<Carta>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				cartas.add(new Carta(100 + (200 * j), 100 + (200 * i),
						dibujoCartas[numerosAleatorios[cont] - 1],
						numerosAleatorios[cont]));
				reversos.add(new Carta(100 + (200 * j), 100 + (200 * i), dibujoReverso, numerosAleatorios[cont]));
				cont++;
			}
		}

		this.resize(1000, 1000);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el rato
	public void run() {
		do {

			if (inicioCrono) {
				tiempo += 20;
				System.out.println(tiempo);
			}
			if (tiempo >= 1000) {
				reversos.add(new Carta(posX1, posY1, dibujoReverso, numero1));
				reversos.add(new Carta(posX2, posY2, dibujoReverso, numero2));
				inicioCrono = false;
				poderLevantar = true;
				tiempo = 0;
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
		noSeVe.fillRect(0, 0, 1000, 1000);

		// Todas las llamadas a los metodos dibujar de los objetos

		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < reversos.size(); i++) {
			reversos.get(i).dibujar(noSeVe, this);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public void desordenNumeros() {
		for (int i = 0; i < numerosOrden.length; i++) {
			int numAle = random.nextInt(cantidad);
			numerosAleatorios[i] = numerosOrden[numAle];
			numerosOrden[numAle] = numerosOrden[cantidad - 1];
			cantidad--;
		}

	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		if (poderLevantar) {
			for (int i = 0; i < reversos.size(); i++) {
				if (reversos.get(i).contains(x, y)) {
					if (primera) {
						numero1 = reversos.get(i).numeroCarta;
						posX1 = reversos.get(i).posicionX;
						posY1 = reversos.get(i).posicionY;
						numero2 = 0;
						reversos.remove(i);
						primera = false;
					} else {
						numero2 = reversos.get(i).numeroCarta;
						posX2 = reversos.get(i).posicionX;
						posY2 = reversos.get(i).posicionY;
						if (numero1 == numero2) {
							reversos.remove(i);
						} else {
							reversos.remove(i);
							inicioCrono = true;
							poderLevantar = false;
						}
						primera = true;
					}
				}
			}
		}

		return true;
	}
}