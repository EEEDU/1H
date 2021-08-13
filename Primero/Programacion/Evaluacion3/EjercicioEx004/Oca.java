package EjercicioEx004;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Oca extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosDados;
	Image dibujoTablero;

	// Crear objetos

	Tablero tablero;
	List<Dado> dados;
	List<Ficha> fichas;
	// Crear variable

	int fichaCogida;

	Random random;

	// NUMERO_JUEGADORES <= 4
	public final int NUMERO_JUGADORES = 2;

	Color[] colores = {Color.red, Color.blue, Color.green, Color.yellow};

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1200, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();

		fichaCogida = 0;

		dibujoTablero = getImage(getDocumentBase(), "SpritesEx4/tablero.png");
		dibujosDados = new Image[6];

		for (int i = 0; i < dibujosDados.length; i++) {
			dibujosDados[i] = getImage(getDocumentBase(),
					"SpritesEx4/dado" + (i + 1) + ".png");
		}


		tablero = new Tablero(dibujoTablero);

		dados = new ArrayList<Dado>();

		dados.add(new Dado(1000, 200, dibujosDados[0]));

		fichas = new ArrayList<Ficha>();

		for (int i = 0; i < NUMERO_JUGADORES; i++) {
			fichas.add(new Ficha(50 + (i * 100), 800, colores[i]));
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

		tablero.dibujar(noSeVe, this);

		for (int i = 0; i < fichas.size(); i++) {
			fichas.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < dados.size(); i++) {
			dados.get(i).dibujar(noSeVe, this);
		}
		g.drawImage(imagen, 0, 0, this);
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {

		if (dados.get(0).contains(x, y)) {
			lanzarDado();
		}
		for (int i = 0; i < fichas.size(); i++) {
			if (fichas.get(i).contains(x, y)) {
				fichaCogida = i;
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

	public void lanzarDado() {
		dados.remove(0);
		int numeroAleatorio = random.nextInt(4);
		dados.add(new Dado(1000, 200, dibujosDados[numeroAleatorio]));
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}
}