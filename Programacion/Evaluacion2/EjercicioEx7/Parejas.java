package EjercicioEx7;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Parejas extends Applet implements Runnable {
	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	List<Carta> cartas;
	List<Figura> figuras;

	public static final int CUADRADO = 0;
	public static final int CIRCULO = 1;
	public static final int RECTANGULO = 2;

	int numFigura;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();
		
		cartas = new ArrayList<Carta>();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 3; j++) {
				cartas.add(new Carta((j * 250) + 50, (i * 300) + 20));
			}
		}
		
		numFigura = 0;

		figuras = new ArrayList<Figura>();

		this.resize(900, 600);
	}


	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);

		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < figuras.size(); i++) {
			figuras.get(i).dibujar(noSeVe);
		}
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		for (int i = 0; i < cartas.size(); i++) {
			if (cartas.get(i).contains(x, y)) {
				if (cartas.get(i).color == Color.RED) {
					cartas.get(i).cambiarColor();
					crearFigura(cartas.get(i).x + 50, cartas.get(i).y + 75);

				} else if (cartas.get(i).color == Color.WHITE) {
					cartas.get(i).vueltaColor();
					for (int j = 0; j < figuras.size(); j++) {
						if (figuras.get(j).intersects(cartas.get(i))) {
							figuras.remove(j);
						}
					}
				}

			}
		}
		return true;
	}

	public void comprobarIgualdad() {
		if (figuras.size() == 2) {
			if (figuras.get(0).numFigura == figuras.get(1).numFigura) {
				for (int j = 0; j < cartas.size(); j++) {
					if (cartas.get(j).intersects(figuras.get(0))) {
						cartas.remove(j);
					}
				}
			}
		}

	}

	private void crearFigura(int posX, int posY) {
		figuras.add(new Figura(posX, posY));
	}
}
