package EjercicioEx003;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosCabeza;
	Image dibujoBloque;

	// Crear objetos

	Cabeza cabeza;
	List<Hueco> huecos;

	// Crear variable

	Random random;

	public final int DERECHA = 0;
	public final int ABAJO = 1;
	public final int IZQUIERDA = 2;
	public final int ARRIBA = 3;

	int direccion;

	// int[][] tablero;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1200, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();
		
		direccion = DERECHA;

		// tablero = new int[12][9];

		dibujosCabeza = new Image[4];

		for (int i = 0; i < dibujosCabeza.length; i++) {
			dibujosCabeza[i] = getImage(getDocumentBase(),
					"SpritesEx3/cabeza" + (i + 1) + ".png");
		}

		cabeza = new Cabeza(100, 100, dibujosCabeza);
		
		huecos = new ArrayList<Hueco>();
		
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 18; j++) {
				huecos.add(new Hueco(i * 50, j * 50));
			}
			
		}

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
			// tablero[1200 / cabeza.x][900 / cabeza.y] = -1;
			// Todas las llamadas a los movimientos de los objetos
			cabeza.mover(direccion);
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
		noSeVe.fillRect(0, 0, 1200, 900);

		// Todas las llamadas a los metodos dibujar de los objetos+

		for (int i = 0; i < huecos.size(); i++) {
			huecos.get(i).dibujar(noSeVe);
		}

		cabeza.dibujar(noSeVe, this);
		g.drawImage(imagen, 0, 0, this);
	}

	@Override
	public boolean keyDown(Event evt, int key) {
		switch (key) {
			case 97 :
				direccion = IZQUIERDA;
				cabeza.x /= 50;
				cabeza.x *= 50;
				break;
			case 115 :
				direccion = ABAJO;
				cabeza.y /= 50;
				cabeza.y *= 50;
				break;
			case 100 :
				direccion = DERECHA;
				cabeza.x /= 50;
				cabeza.x *= 50;
				break;
			case 119 :
				direccion = ARRIBA;
				cabeza.y /= 50;
				cabeza.y *= 50;
				break;
			default :
				break;
		}
		return true;
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

}