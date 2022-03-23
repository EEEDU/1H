package Ejercicio019;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Carretera extends Applet implements Runnable {

	List<Coche> cochesDerecha;
	List<Coche> cochesIzquierda;
	Persona persona;

	boolean perder;
	int puntuacion;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 900);
		noSeVe = imagen.getGraphics();

		cochesDerecha = new ArrayList<Coche>();
		cochesIzquierda = new ArrayList<Coche>();

		crearCochesIzquierda(200);
		crearCochesIzquierda(240);
		crearCochesIzquierda(440);
		crearCochesIzquierda(480);

		crearCochesDerecha(320);
		crearCochesDerecha(360);
		crearCochesDerecha(560);
		crearCochesDerecha(600);

		perder = false;
		puntuacion = 0;

		persona = new Persona();

		this.resize(900, 900);
	}

	public void crearCochesDerecha(int posY) {
		cochesDerecha.add(new Coche(0, posY, false, puntuacion));
	}

	public void crearCochesIzquierda(int posY) {
		cochesIzquierda.add(new Coche(900, posY, true, puntuacion));
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
/*			milisegundo += tiempo;
 * 			if(milisegundos > 500) {
 * 				crearCoche();
 * 				milisegundo = 0;
 * 			}
 * */
			
			repaint();
			chocar();
			for (int i = 0; i < cochesDerecha.size(); i++) {
				cochesDerecha.get(i).actualizar();
			}
			for (int i = 0; i < cochesIzquierda.size(); i++) {
				cochesIzquierda.get(i).actualizar();
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

		noSeVe.setColor(Color.LIGHT_GRAY);
		noSeVe.fillRect(0, 190, 900, 80);
		noSeVe.fillRect(0, 310, 900, 80);
		noSeVe.fillRect(0, 430, 900, 80);
		noSeVe.fillRect(0, 550, 900, 80);

		noSeVe.setColor(Color.WHITE);
		noSeVe.drawLine(0, 230, 900, 230);
		noSeVe.drawLine(0, 350, 900, 350);
		noSeVe.drawLine(0, 470, 900, 470);
		noSeVe.drawLine(0, 590, 900, 590);

		for (int i = 0; i < cochesDerecha.size(); i++) {
			cochesDerecha.get(i).dibujar(noSeVe);
		}
		for (int i = 0; i < cochesIzquierda.size(); i++) {
			cochesIzquierda.get(i).dibujar(noSeVe);
		}

		persona.dibujar(noSeVe);

		if (perder) {
			noSeVe.setColor(Color.BLACK);
			noSeVe.drawString("¡TE HAN ATROPELLADO!", 425, 409);
			noSeVe.drawString("Tu puntuacion ha sido: " + puntuacion, 427, 425);
			persona = null;
		}

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("Puntutacion: " + puntuacion, 20, 20);
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

//	public boolean mouseDown(Event evt, int x, int y) {
//		persona.y -= 40;
//		return true;
//	}

	@Override
	public boolean keyDown(Event evt, int key) {
		switch (key) {
		case 1004:
			persona.y -= 40;
			break;
		case 1005:
			persona.y += 40;
			break;
		case 1006:
			persona.x -= 40;
			break;
		case 1007:
			persona.x += 40;
			break;

		default:
			break;
		}
		return true;
	}

	public boolean chocar() {
		for (int i = 0; i < cochesDerecha.size(); i++) {
			if (cochesDerecha.get(i).intersects(persona)) {
				perder = true;
			}
			if (cochesDerecha.get(i).x >= 900) {
				int posY = cochesDerecha.get(i).y;
				cochesDerecha.remove(i);
				crearCochesDerecha(posY);
			}
		}

		for (int i = 0; i < cochesIzquierda.size(); i++) {
			if (cochesIzquierda.get(i).intersects(persona)) {
				perder = true;
			}
			if (cochesIzquierda.get(i).x <= -50) {
				int posY = cochesIzquierda.get(i).y;
				cochesIzquierda.remove(i);
				crearCochesIzquierda(posY);
			}
		}

		if (persona.y <= 0) {
			persona.y = 800;
			puntuacion++;
		}

		return true;
	}





}