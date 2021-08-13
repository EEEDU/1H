package Ejercicio004;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Rompecabezas extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[] dibujosFichas;
	AudioClip error, acierto, exito;
	Button boton;
	// Crear objetos

	List<Ficha> fichas;
	List<Hueco> huecos;

	// Crear variables

	int tiempo;
	int numFicha;
	int[] ordenFicha;
	int distancia;
	int numero;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(500, 600);
		noSeVe = imagen.getGraphics();

		random = new Random();

		dibujosFichas = new Image[25];
		for (int i = 0; i < dibujosFichas.length; i++) {
			dibujosFichas[i] = getImage(getDocumentBase(), "Sprites4/botones/" + (i + 1) + ".gif");
		}

		numFicha = 24;
		ordenFicha = new int[24];
		for (int i = 0; i < ordenFicha.length; i++) {
			ordenFicha[i] = i + 1;
		}

		fichas = new ArrayList<Ficha>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				numero = elegirNumero() - 1;
				fichas.add(new Ficha(j * 100, 100 + i * 100, dibujosFichas[numero], numero));
			}
		}

		for (int i = 0; i < 4; i++) {
			numero = elegirNumero() - 1;
			fichas.add(new Ficha(400, 100 + i * 100, dibujosFichas[numero], numero));
		}
		fichas.add(new Ficha(400, 500, dibujosFichas[24], 24));

		try {
			error = getAudioClip(new URL(getCodeBase(), "Sprites4/sonidos/error.wav"));
			acierto = getAudioClip(new URL(getCodeBase(), "Sprites4/sonidos/correct.mp3"));
			exito = getAudioClip(new URL(getCodeBase(), "Sprites4/sonidos/exito.wav"));
		} catch (Exception e) {
			// TODO: handle exception
		}

		huecos = new ArrayList<Hueco>();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 4; j++) {
				huecos.add(new Hueco(j * 100, 100 + i * 100));
			}
		}
		for (int i = 0; i < 4; i++) {
			huecos.add(new Hueco(400, 100 + i * 100));
		}
		huecos.add(new Hueco(400, 500));

		boton = new Button("Comprobar");
		this.setLayout(new BorderLayout());
		this.add("North", boton);

		tiempo = 0;
		distancia = 0;

		this.resize(500, 600);
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
		noSeVe.fillRect(0, 0, 500, 600);

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("" + tiempo / 1000, 250, 50);
		// Todas las llamadas a los metodos dibujar de los objetos
		for (int i = 0; i < huecos.size(); i++) {
			huecos.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < fichas.size(); i++) {
			fichas.get(i).dibujar(noSeVe, this);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public int elegirNumero() {
		int numAleatorio = random.nextInt(numFicha);
		int numElegido = ordenFicha[numAleatorio];
		ordenFicha[numAleatorio] = ordenFicha[numFicha - 1];
		numFicha--;
		return numElegido;
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < fichas.size(); i++) {
			if (fichas.get(i).contains(x, y) && fichas.get(i).x == fichas.get(24).x) {
				moverFichasVertical(i, x, y);
			}
			else if (fichas.get(i).contains(x, y) && fichas.get(i).y == fichas.get(24).y) {
				moverFichasHorizontal(i, x, y);
			}
		}
		return true;
	}

	public void moverFichasVertical(int i, int x, int y) {
		if (fichas.get(24).contains(x, y + 100) || fichas.get(24).contains(x, y - 100)) {
			int posX, posY;
			posX = fichas.get(24).x;
			posY = fichas.get(24).y;
			fichas.get(24).x = fichas.get(i).x;
			fichas.get(24).y = fichas.get(i).y;
			fichas.get(i).x = posX;
			fichas.get(i).y = posY;
		}
		else {
			distancia = fichas.get(i).y - fichas.get(24).y;
			if (distancia > 0) {
				for (int j = 100; j <= distancia; j += 100) {
					for (int j2 = 0; j2 < fichas.size(); j2++) {
						if (fichas.get(j2).contains(x, y - (distancia - j))) {
							int posX, posY;
							posX = fichas.get(24).x;
							posY = fichas.get(24).y;
							fichas.get(24).x = fichas.get(j2).x;
							fichas.get(24).y = fichas.get(j2).y;
							fichas.get(j2).x = posX;
							fichas.get(j2).y = posY;
						}
					}
				}
			} else {
				for (int j = -100; j >= distancia; j -= 100) {
					for (int j2 = 0; j2 < fichas.size(); j2++) {
						if (fichas.get(j2).contains(x, y - (distancia - j))) {
							int posX, posY;
							posX = fichas.get(24).x;
							posY = fichas.get(24).y;
							fichas.get(24).x = fichas.get(j2).x;
							fichas.get(24).y = fichas.get(j2).y;
							fichas.get(j2).x = posX;
							fichas.get(j2).y = posY;
						}
					}
				}
			}

		}
	}

	public void moverFichasHorizontal(int i, int x, int y) {
		if (fichas.get(24).contains(x + 100, y) || fichas.get(24).contains(x - 100, y)) {
			int posX, posY;
			posX = fichas.get(24).x;
			posY = fichas.get(24).y;
			fichas.get(24).x = fichas.get(i).x;
			fichas.get(24).y = fichas.get(i).y;
			fichas.get(i).x = posX;
			fichas.get(i).y = posY;
		}
		else {
			distancia = fichas.get(i).x - fichas.get(24).x;
			if (distancia > 0) {
				for (int j = 100; j <= distancia; j += 100) {
					for (int j2 = 0; j2 < fichas.size(); j2++) {
						if (fichas.get(j2).contains(x - (distancia - j), y)) {
							int posX, posY;
							posX = fichas.get(24).x;
							posY = fichas.get(24).y;
							fichas.get(24).x = fichas.get(j2).x;
							fichas.get(24).y = fichas.get(j2).y;
							fichas.get(j2).x = posX;
							fichas.get(j2).y = posY;
						}
					}
				}
			} else {
				for (int j = -100; j >= distancia; j -= 100) {
					for (int j2 = 0; j2 < fichas.size(); j2++) {
						if (fichas.get(j2).contains(x - (distancia - j), y)) {
							int posX, posY;
							posX = fichas.get(24).x;
							posY = fichas.get(24).y;
							fichas.get(24).x = fichas.get(j2).x;
							fichas.get(24).y = fichas.get(j2).y;
							fichas.get(j2).x = posX;
							fichas.get(j2).y = posY;
						}
					}
				}
			}

		}
	}

	@Override
	public boolean action(Event evt, Object obj) {
		if (evt.target instanceof Button) {
			for (int i = 0; i < fichas.size(); i++) {
				if (huecos.get(i).intersects(fichas.get(fichas.get(i).numero))) {
					System.out.println("----------------");
					System.out.println(i + ", " + fichas.get(i).numero);

				}
				System.out.println(i + ", " + fichas.get(i).numero);
			}
		}
		return false;
	}
}
