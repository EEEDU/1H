package Ejercicio016;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flappy extends Applet implements Runnable {

	Random random;

	int posY, posX, altura;
	int puntuacion;
	boolean perder;

	Pajaro pajaro;
	List<Tuberia> tuberias_arriba;
	List<Tuberia> tuberias_abajo;
	List<Tuberia> tuberias_puntos;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();
		
		random = new Random();
		perder = false;
		puntuacion = 0;
		
		pajaro = new Pajaro();
		tuberias_arriba = new ArrayList<Tuberia>();
		tuberias_abajo = new ArrayList<Tuberia>();
		tuberias_puntos = new ArrayList<Tuberia>();

		for (int i = 0; i < 2; i++) {
			altura = random.nextInt(200) + 100;
			tuberias_arriba.add(new Tuberia(900 + i * 450, 0, altura));
			tuberias_abajo.add(new Tuberia(900 + i * 450, altura + 200, 1000));
			tuberias_puntos.add(new Tuberia(900 + i * 450, 0, 600));
		}

		this.resize(900, 600);
	}

	public void crearTuberia() {
		altura = random.nextInt(200) + 100;
		tuberias_arriba.add(new Tuberia(900, 0, altura));
		tuberias_abajo.add(new Tuberia(900, altura + 200, 1000));
		tuberias_puntos.add(new Tuberia(900, 0, 600));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			chocar();
			pajaro.actualizar();
			for (int i = 0; i < tuberias_arriba.size(); i++) {
				tuberias_arriba.get(i).actualizar();
				tuberias_abajo.get(i).actualizar();
				tuberias_puntos.get(i).actualizar();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);

	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);

		pajaro.dibujar(noSeVe);
		for (int i = 0; i < tuberias_arriba.size(); i++) {
			tuberias_arriba.get(i).dibujar(noSeVe);
			tuberias_abajo.get(i).dibujar(noSeVe);
		}
		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("Puntuación: " + (puntuacion / 20), 10, 10);

		if (perder) {
			pajaro = null;
			noSeVe.setColor(Color.BLACK);
			noSeVe.drawString("¡HAS PERDIDO!", 400, 300);
			noSeVe.drawString("Tu puntuación ha sido: " + (puntuacion / 20), 375, 320);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public boolean mouseDown(Event evt, int x, int y) {
		pajaro.y -= 100;

		return true;
	}

	public boolean chocar() {
		for (int i = 0; i < tuberias_arriba.size(); i++) {
			if (pajaro.intersects(tuberias_arriba.get(i)) || pajaro.intersects(tuberias_abajo.get(i))
					|| pajaro.y >= 600 - pajaro.height) {
				perder = true;
			}

			if (tuberias_arriba.get(i).x <= 0 && tuberias_arriba.get(i).x > -7) {
				tuberias_abajo.remove(i);
				tuberias_arriba.remove(i);
				tuberias_puntos.remove(i);
				crearTuberia();
			}

			if (pajaro.intersects(tuberias_puntos.get(i))) {
				puntuacion++;
				if (puntuacion % 100 == 0 && puntuacion != 0) {
					tuberias_arriba.get(i).setVelX(tuberias_arriba.get(i).getVelX() + 10);
					tuberias_abajo.get(i).setVelX(tuberias_abajo.get(i).getVelX() + 10);
					tuberias_puntos.get(i).setVelX(tuberias_puntos.get(i).getVelX() + 10);
				}
			}
		}

		return true;
	}


	public void update(Graphics g) {
		paint(g);
	}

}
