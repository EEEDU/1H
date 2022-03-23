package Ejercicio018;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Disparar extends Applet implements Runnable {

	List<Nube> nubes;
	Pistola pistola;
	List<Bala> balas;

	int numero_nubes;

	Thread animacion;

	int[] vidas;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 900);
		noSeVe = imagen.getGraphics();

		numero_nubes = 5;

		nubes = new ArrayList<Nube>();
		vidas = new int[numero_nubes];


		for (int i = 0; i < numero_nubes; i++) {
			nubes.add(new Nube(i * 100 + 100));
			vidas[i] = 3;
		}


		pistola = new Pistola();

		balas = new ArrayList<Bala>();
		crearBalas();


		this.resize(900, 900);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			chocar();
//			vidas_nubes(vidas);
			for (int i = 0; i < nubes.size(); i++) {
				nubes.get(i).actualizar();
			}
			for (int i = 0; i < balas.size(); i++) {
				balas.get(i).actualizar();
			}

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);

	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 900);

		for (int i = 0; i < nubes.size(); i++) {
			nubes.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < balas.size(); i++) {
			balas.get(i).dibujar(noSeVe);
		}

		pistola.dibujar(noSeVe);

		for (int i = 0; i < vidas.length; i++) {
			switch (vidas[i]) {
			case 2:
				nubes.get(i).setColor(Color.ORANGE);
				break;
			case 1:
				nubes.get(i).setColor(Color.YELLOW);
				break;
			case 0:
				break;

			default:
				break;
			}

			if (vidas[i] == 0) {
				nubes.remove(i);
				for (int j = i; j < vidas.length; j++) {
					vidas[j] = vidas[i + 1];

				}
			}
		}


		if (nubes.size() == 0) {
			noSeVe.drawString("¡Has ganado!", 425, 450);
		}
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseDown(Event evt, int x, int y) {

		crearBalas();
		return true;
	}

	public boolean mouseMove(Event evt, int x, int y) {
		pistola.x = x - 20;
		return true;
	}

	public boolean chocar() {
		for (int i = 0; i < balas.size(); i++) {
			for (int j = 0; j < nubes.size(); j++) {
				if (balas.get(i).intersects(nubes.get(j))) {
					balas.remove(i);
					vidas[j]--;
				}
			}
		}

		return true;
	}

//	public void vidas_nubes(int[] vidas) {
//		for (int i = 0; i < vidas.length; i++) {
//			switch (vidas[i]) {
//			case 2:
//				nubes.get(i).setColor(Color.ORANGE);
//				break;
//			case 1:
//				nubes.get(i).setColor(Color.YELLOW);
//				break;
//			case 0:
//				nubes.remove(i);
//				break;
//
//			default:
//				break;
//			}
//		}
//	}

	public void crearBalas() {
		balas.add(new Bala(pistola.x + 20));
	}

}
