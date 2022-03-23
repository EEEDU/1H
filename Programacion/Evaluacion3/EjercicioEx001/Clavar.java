package EjercicioEx001;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Clavar extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image dibujoArquero;
	Image dibujoFlecha;
	Image[] dibujosGlobos;

	AffineTransform identity = new AffineTransform();
	// Crear objetos

	Circulo circulo;
	List<Flecha> flechas;

	// Crear variables

	int tiempo;
	int tiempoEspera;
	int puntuacion;
	int numFlechas;
	int flechasInicio;

	boolean poderDisparar;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(600, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();

		tiempo = 0;
		tiempoEspera = 0;
		puntuacion = 0;
		numFlechas = flechasInicio = 20;
		poderDisparar = true;

		dibujoFlecha = getImage(getDocumentBase(), "SpritesEx1/flecha.jpg");

		circulo = new Circulo();
		flechas = new ArrayList<Flecha>();
		for (int i = 0; i < numFlechas; i++) {
			flechas.add(new Flecha(dibujoFlecha));
		}

		this.resize(600, 900);
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

			tiempoEspera += 20;

			if (tiempoEspera >= 500) {
				poderDisparar = true;
			}

			// Todas las llamadas a los movimientos de los objetos

			for (int i = 0; i < flechas.size(); i++) {
				flechas.get(i).actualizar();
				flechas.get(i).rotar();
			}

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
		noSeVe.fillRect(0, 0, 600, 900);

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("" + numFlechas, 295, 50);

		// Todas las llamadas a los metodos dibujar de los objetos
		for (int i = 0; i < flechas.size(); i++) {
			flechas.get(i).dibujar(noSeVe, this);
		}

//		Graphics2D g2d = (Graphics2D) g;
//		AffineTransform trans = new AffineTransform();
//		trans.setTransform(identity);
//		trans.rotate(Math.toRadians(45));
//		g2d.drawImage(flechas.get(0), trans, this);

		circulo.dibujar(noSeVe, this);

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public void chocar() {
		for (int i = 0; i < flechas.size(); i++) {
			if (flechas.get(i).contains(circulo.x + 100, circulo.y + 150)) {
				flechas.get(i).vel = 0;
				flechas.get(i).rotar = true;
			}
		}
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		flechas.get(numFlechas - flechasInicio).vel = 10;
		numFlechas--;
		return true;
	}
}

