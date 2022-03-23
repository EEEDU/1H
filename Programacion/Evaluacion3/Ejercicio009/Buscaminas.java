package Ejercicio009;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buscaminas extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image dibujoMina;
	Image dibujoBloque;

	// Crear objetos

	List<Mina> minas;
	List<Numero> numeros;
	List<Bloque> bloques;

	// Crear variable

	Random random;

	int[] posicionMinas, numerosOrden;
	int[][] tablero;
	int cantidad;

	boolean perder, ganar;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(500, 500);
		noSeVe = imagen.getGraphics();

		random = new Random();
		
		cantidad = 99;

		posicionMinas = new int[40];
		numerosOrden = new int[cantidad];
		tablero = new int[10][10];
		
		perder = false;
		ganar = false;

		for (int i = 0; i < numerosOrden.length; i++) {
			numerosOrden[i] = i;
		}

		dibujoMina = getImage(getDocumentBase(), "Sprites9/mina.png");
		dibujoBloque = getImage(getDocumentBase(), "Sprites9/bloque.png");

		minas = new ArrayList<Mina>();
		for (int i = 0; i < 15; i++) {
			int numeroAleatorio = seleccionNumero();
			tablero[numeroAleatorio / 10][numeroAleatorio % 10] = -1;
			minas.add(new Mina((numeroAleatorio / 10) * 50, (numeroAleatorio % 10) * 50, dibujoMina));
		}

		numeros = new ArrayList<Numero>();
		ponerNumeros();

		bloques = new ArrayList<Bloque>();
		for (int i = 0; i < 100; i++) {
			bloques.add(new Bloque((i / 10) * 50, (i % 10) * 50, dibujoBloque, i));
		}

		this.resize(500, 500);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el rato
	public void run() {
		do {

			// Todas las llamadas a los movimientos de los objetos
			repaint();
			if (bloques.size() <= 15 && !perder) {
				ganar = true;
			}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	// Dibujar, cuanto mas abajo mas superpuesto
	public void paint(Graphics g) {

		// Pintar pantalla
		noSeVe.setColor(Color.LIGHT_GRAY);
		noSeVe.fillRect(0, 0, 500, 500);

		// Todas las llamadas a los metodos dibujar de los objetos

		for (int i = 0; i < minas.size(); i++) {
			minas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < numeros.size(); i++) {
			numeros.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < bloques.size(); i++) {
			bloques.get(i).dibujar(noSeVe, this);
		}

		if (perder) {
			noSeVe.setFont(new Font("Calibri", Font.PLAIN, 50));
			noSeVe.setColor(Color.WHITE);
			noSeVe.drawString("¡Eres un perdedor!", 50, 170);
			for (int i = 0; i < bloques.size(); i++) {
				bloques.remove(i);
			}
		}
		
		if (ganar) {
			noSeVe.setFont(new Font("Calibri", Font.PLAIN, 50));
			noSeVe.setColor(Color.WHITE);
			noSeVe.drawString("¡Eres un ganador!", 50, 170);
		}
	
		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public int seleccionNumero() {
		int numAle = random.nextInt(cantidad);
		int numeroAleatorio = numerosOrden[numAle];
		numerosOrden[numAle] = numerosOrden[cantidad - 1];
		cantidad--;
		return numeroAleatorio;
	}

	public void ponerNumeros() {
		for (int i = 0; i < 100; i++) {
			if (tablero[i / 10][i % 10] == -1) {
				// arr izq
				if (i / 10 != 0 && i % 10 != 0 && tablero[(i / 10) - 1][(i % 10) - 1] != -1) {
					tablero[(i / 10) - 1][(i % 10) - 1] += 1;
				}
				// arr
				if (i / 10 != 0 && tablero[(i / 10) - 1][i % 10] != -1) {
					tablero[(i / 10) - 1][i % 10] += 1;
				}
				// arr der
				if (i / 10 != 0 && i % 10 != 9 && tablero[(i / 10) - 1][(i % 10) + 1] != -1) {
					tablero[(i / 10) - 1][(i % 10) + 1] += 1;
				}
				// izq
				if (i % 10 != 0 && tablero[i / 10][(i % 10) - 1] != -1) {
					tablero[i / 10][(i % 10) - 1] += 1;
				}
				// der
				if (i % 10 != 9 && tablero[i / 10][(i % 10) + 1] != -1) {
					tablero[i / 10][(i % 10) + 1] += 1;
				}
				// aba izq
				if (i / 10 != 9 && i % 10 != 0 && tablero[(i / 10) + 1][(i % 10) - 1] != -1) {
					tablero[(i / 10) + 1][(i % 10) - 1] += 1;
				}
				// aba
				if (i / 10 != 9 && tablero[(i / 10) + 1][i % 10] != -1) {
					tablero[(i / 10) + 1][i % 10] += 1;
				}
				// aba der
				if (i / 10 != 9 && i % 10 != 9 && tablero[(i / 10) + 1][(i % 10) + 1] != -1) {
					tablero[(i / 10) + 1][(i % 10) + 1] += 1;
				}
			}
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (tablero[i][j] > 0) {
					numeros.add(new Numero(i * 50, j * 50, tablero[i][j]));
				}
			}
		}
	}

	// public void desplegar(int i, int j, int numBloque) {
	// if (tablero[i - 1][j] == 0) {
	// bloques.remove(numBloque);
	// desplegar(i - 1, j, numBloque - 10);
	// }
	// if (tablero[i][j + 1] == 0) {
	// bloques.remove(numBloque);
	// desplegar(i, j + 1, numBloque + 1);
	// }
	// if (tablero[i + 1][j] == 0) {
	// bloques.remove(numBloque);
	// desplegar(i + 1, j, numBloque + 10);
	// }
	// if (tablero[i][j - 1] == 0) {
	// bloques.remove(numBloque);
	// desplegar(i, j - 1, numBloque - 1);
	// }
	//
	// }

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < bloques.size(); i++) {
			if (bloques.get(i).contains(x, y)) {
				if (tablero[bloques.get(i).posicion / 10][bloques.get(i).posicion % 10] == -1) {
					perder = true;
				}
				else {
					bloques.remove(i);
					// if (tablero[bloques.get(i).posicion
					// / 10][bloques.get(i).posicion % 10] == 0) {
					// desplegar(bloques.get(i).posicion / 10,
					// bloques.get(i).posicion % 10, i);
					// }
				}
			}
		}
		return true;
	}

}