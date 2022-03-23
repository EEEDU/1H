package Examen_josiko;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cielo extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image dibujoCohete;
	Image dibujoNube;

	// Crear objetos

	List<Cohete> cohetes;
	List<Nube> nubes;
	// Crear variable

	boolean coheteSuelo;
	boolean perder;

	int velCohete;
	int marcador;
	int tiempo;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1200, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();

		coheteSuelo = true;
		perder = false;

		velCohete = 0;
		marcador = 0;
		tiempo = 0;

		dibujoCohete = getImage(getDocumentBase(), "SpriteExamenJosiko/cohete.png");
		dibujoNube = getImage(getDocumentBase(), "SpriteExamenJosiko/nube.png");


		cohetes = new ArrayList<Cohete>();
		nubes = new ArrayList<Nube>();

		cohetes.add(new Cohete(275, 800, dibujoCohete));

		for (int i = 0; i < 5; i++) {
			nubes.add(new Nube(random.nextInt(550), random.nextInt(500), dibujoNube));
		}

		this.resize(600, 900);
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

			if (tiempo >= 5000) {
				crearNube();
				tiempo = 0;
			}
			// Todas las llamadas a los movimientos de los objetos
			repaint();
			chocarTecho();
			chocarNube();
			for (int i = 0; i < cohetes.size(); i++) {
				cohetes.get(i).despegar(velCohete);
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
		noSeVe.setColor(Color.BLUE);
		noSeVe.fillRect(0, 0, 600, 900);

		// Todas las llamadas a los metodos dibujar de los objetos+


		for (int i = 0; i < cohetes.size(); i++) {
			cohetes.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < nubes.size(); i++) {
			nubes.get(i).dibujar(noSeVe, this);
		}

		noSeVe.setColor(Color.WHITE);
		noSeVe.setFont(new Font("Calibri", Font.PLAIN, 24));
		noSeVe.drawString("" + marcador, 50, 50);

		if (perder) {
			noSeVe.setColor(Color.RED);
			noSeVe.setFont(new Font("Calibri", Font.BOLD, 50));
			noSeVe.drawString("Has perdido!", 200, 500);
		}
		g.drawImage(imagen, 0, 0, this);
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		velCohete = 10;
		coheteSuelo = false;
		return true;
	}

	@Override
	public boolean mouseMove(Event evt, int x, int y) {
		if (coheteSuelo && x > 0 && x < 550) {
			for (int i = 0; i < cohetes.size(); i++) {
				cohetes.get(i).x = x;
			}
		}
		return true;
	}

	public void chocarTecho() {
		for (int i = 0; i < cohetes.size(); i++) {
			if (cohetes.get(i).y <= 0) {
				eliminarCohete();
				crearCohete();
				marcador++;
			}
		}
	}

	public void eliminarCohete() {
		for (int i = 0; i < cohetes.size(); i++) {
			cohetes.remove(i);
		}
	}

	public void crearCohete() {
		coheteSuelo = true;
		velCohete = 0;
		cohetes.add(new Cohete(275, 800, dibujoCohete));
	}

	public void crearNube() {
		nubes.add(new Nube(random.nextInt(550), random.nextInt(500), dibujoNube));
	}

	public void chocarNube() {
		for (int i = 0; i < cohetes.size(); i++) {
			for (int j = 0; j < nubes.size(); j++) {
				if (cohetes.get(i).intersects(nubes.get(j))) {
					eliminarCohete();
					perder = true;
				}
			}
		}
	}
	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}
}
