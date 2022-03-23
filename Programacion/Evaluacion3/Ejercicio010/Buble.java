package Ejercicio010;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Buble extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosPelotas;

	// Crear objetos

	List<Pelota> pelotas;

	// Crear variable

	Random random;

	int numRandom;
	int velX, velY;
	int contador;
	int[] bolasBorar;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1200, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();
		velX = velY = 0;
		bolasBorar = new int[100];

		dibujosPelotas = new Image[4];
		for (int i = 0; i < dibujosPelotas.length; i++) {
			dibujosPelotas[i] = getImage(getDocumentBase(),
					"Sprites10/pelotas/" + (i + 1) + ".png");
		}

		pelotas = new ArrayList<Pelota>();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 24; j++) {
				numRandom = random.nextInt(4);
				pelotas.add(
						new Pelota(j * 50, i * 50, dibujosPelotas[numRandom]));
			}
		}

		numRandom = random.nextInt(4);
		pelotas.add(new Pelota(600 - 25, 800, dibujosPelotas[numRandom]));
		this.resize(1200, 900);
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

			pelotas.get(pelotas.size() - 1).obtenerVel(velX, velY);
			pelotas.get(pelotas.size() - 1).mover();
			intersectar();
			comprobarPared();
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
		noSeVe.fillRect(0, 0, 1200, 900);

		// Todas las llamadas a los metodos dibujar de los objetos

		for (int i = 0; i < pelotas.size(); i++) {
			pelotas.get(i).dibujar(noSeVe, this);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		calcularVelocidad(x, y);
		return true;
	}

	public void calcularVelocidad(int x, int y) {
		velX = (x - 575) / 40;
		velY = (y - 800) / 40;
	}

	public void intersectar() {
		for (int i = 0; i < pelotas.size() - 1; i++) {
			if (pelotas.get(pelotas.size() - 1).intersects(pelotas.get(i))) {
				velX = velY = 0;
				if (pelotas.get(pelotas.size() - 1).x >= pelotas.get(i).x
						+ 30) {
					pelotas.get(pelotas.size() - 1).x = pelotas.get(i).x + 50;
				} else {
					pelotas.get(pelotas.size() - 1).x = pelotas.get(i).x;
				}
				if (pelotas.get(pelotas.size() - 1).y < pelotas.get(i).y + 40) {
					pelotas.get(pelotas.size() - 1).y = pelotas.get(i).y;
					if (pelotas.get(pelotas.size() - 1).x > pelotas.get(i).x) {
						pelotas.get(pelotas.size() - 1).x = pelotas.get(i).x
								+ 50;
					} else {
						pelotas.get(pelotas.size() - 1).x = pelotas.get(i).x
								- 50;
					}
				} else {
					pelotas.get(pelotas.size() - 1).y = pelotas.get(i).y + 50;
				}

				// comprobarEliminar(pelotas.size() - 1, i);
				// borrar();
				crearPelota();
			}
		}
	}

	public void comprobarPared() {
		if (pelotas.get(pelotas.size() - 1).x + 50 >= 1200) {
			velX -= Math.abs(velX) * 2;
		}
		if (pelotas.get(pelotas.size() - 1).x <= 0) {
			velX += Math.abs(velX) * 2;
		}
	}

	public void crearPelota() {
		pelotas.add(new Pelota(575, 800, dibujosPelotas[random.nextInt(4)]));
	}

	// public void comprobarEliminar(int bola1, int bola2) {
	// if (pelotas.get(bola1).dibujo == pelotas.get(bola2).dibujo) {
	// if (contador == 0) {
	// bolasBorar[contador] = bola1;
	// }
	// contador += 1;
	// bolasBorar[contador] = bola2;
	//
	// comprobarEliminar(bola2, bola2 - 1);
	// comprobarEliminar(bola2, bola2 - 24);
	// comprobarEliminar(bola2, bola2 + 1);
	// }
	// }
	// public void borrar() {
	// if (contador >= 3) {
	// for (int i = 0; i < bolasBorar.length; i++) {
	// if (bolasBorar[i] != 0) {
	// pelotas.remove(bolasBorar[i]);
	// }
	// }
	// } else {
	// for (int i = 0; i < bolasBorar.length; i++) {
	// bolasBorar[i] = 0;
	// }
	// }
	// contador = 0;
	// }
}