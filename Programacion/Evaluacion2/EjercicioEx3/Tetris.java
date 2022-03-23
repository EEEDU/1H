package EjercicioEx3;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// http://panamahitek.com/listas-multidimensionales-en-java/

public class Tetris extends Applet implements Runnable {

	List<List<Pieza>> piezas;
	
	List<Pieza> cian;
	List<Pieza> amarillo;
	List<Pieza> rosa;
	List<Pieza> naranja;
	List<Pieza> azul;
	List<Pieza> rojo;
	List<Pieza> verde;

	Random random;

	int numAleatorio;

	public int anchuraCuadrado, alturaCuadrado;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(600, 900);
		noSeVe = imagen.getGraphics();

		anchuraCuadrado = alturaCuadrado = 30;

		piezas = new ArrayList<List<Pieza>>();
		
		for (int i = 0; i < 7; i++) {
			piezas.add(new ArrayList<Pieza>());
		}
		
		
		cian = piezas.get(0);
		amarillo = piezas.get(1);
		rosa = piezas.get(2);
		naranja = piezas.get(3);
		azul = piezas.get(4);
		rojo = piezas.get(5);
		verde = piezas.get(6);

		random = new Random();

		elegirFigura();

		this.resize(600, 900);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			chocar();
			for (int i = 0; i < cian.size(); i++) {
				cian.get(i).actualiza();
			}
			for (int i = 0; i < amarillo.size(); i++) {
				amarillo.get(i).actualiza();
			}
			for (int i = 0; i < rosa.size(); i++) {
				rosa.get(i).actualiza();
			}
			for (int i = 0; i < naranja.size(); i++) {
				naranja.get(i).actualiza();
			}
			for (int i = 0; i < azul.size(); i++) {
				azul.get(i).actualiza();
			}
			for (int i = 0; i < rojo.size(); i++) {
				rojo.get(i).actualiza();
			}
			for (int i = 0; i < verde.size(); i++) {
				verde.get(i).actualiza();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 600, 900);

		for (int i = 0; i < cian.size(); i++) {
			cian.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < amarillo.size(); i++) {
			amarillo.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < rosa.size(); i++) {
			rosa.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < naranja.size(); i++) {
			naranja.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < azul.size(); i++) {
			azul.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < rojo.size(); i++) {
			rojo.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < verde.size(); i++) {
			verde.get(i).dibujar(noSeVe);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean chocar() {
		for (int i = 0; i < cian.size(); i++) {
			if (cian.get(i).y == 870 - cian.get(i).height) {
				elegirFigura();
			}
			for (int j = 0; j < piezas.size(); j++) {
				for (int k = 0; k < piezas.get(i).size(); k++) {
					if (cian.get(i).intersects(piezas.get(j).get(k))) {
						cian.get(i).setVelPieza(0);
					}
				}
			}

		}
		for (int i = 0; i < amarillo.size(); i++) {
			if (amarillo.get(i).y == 870 - amarillo.get(i).height) {
				elegirFigura();
			}
		}
		for (int i = 0; i < rosa.size(); i++) {
			if (rosa.get(i).y == 870 - rosa.get(i).height * 2) {
				elegirFigura();

			}
		}
		for (int i = 0; i < naranja.size(); i++) {
			if (naranja.get(i).y == 870 - naranja.get(i).height * 2) {
				elegirFigura();
			}
		}
		for (int i = 0; i < azul.size(); i++) {
			if (azul.get(i).y == 870 - azul.get(i).height * 2) {
				elegirFigura();
			}
		}
		for (int i = 0; i < rojo.size(); i++) {
			if (rojo.get(i).y == 870 - rojo.get(i).height * 2) {
				elegirFigura();
			}
		}
		for (int i = 0; i < verde.size(); i++) {
			if (verde.get(i).y == 870 - verde.get(i).height * 2) {
				elegirFigura();
			}
		}
		return true;
	}

	public void elegirFigura() {
		numAleatorio = (int) (Math.random() * 7);
		switch (numAleatorio) {
		case 0:
			crearCian();
			break;
		case 1:
			crearAmarillo();
			break;
		case 2:
			crearRosa();
			break;
		case 3:
			crearNaranja();
			break;
		case 4:
			crearAzul();
			break;
		case 5:
			crearRojo();
			break;
		case 6:
			crearVerde();
			break;

		}
	}

	public void crearCian() {
		cian.add(new Pieza(anchuraCuadrado * 4, alturaCuadrado * 1, Color.CYAN, false));
	}

	public void crearAmarillo() {
		amarillo.add(new Pieza(anchuraCuadrado * 2, alturaCuadrado * 2, Color.YELLOW, false));
	}

	public void crearRosa() {
		rosa.add(new Pieza(anchuraCuadrado * 3, alturaCuadrado * 1, Color.PINK, true));
	}

	public void crearNaranja() {
		naranja.add(new Pieza(anchuraCuadrado * 3, alturaCuadrado * 1, Color.ORANGE, true));
	}

	public void crearAzul() {
		azul.add(new Pieza(anchuraCuadrado * 3, alturaCuadrado * 1, Color.BLUE, true));
	}

	public void crearRojo() {
		rojo.add(new Pieza(anchuraCuadrado * 2, alturaCuadrado * 1, Color.RED, true));
	}

	public void crearVerde() {
		verde.add(new Pieza(anchuraCuadrado * 2, alturaCuadrado * 1, Color.GREEN, true));

	}
	
	

}
