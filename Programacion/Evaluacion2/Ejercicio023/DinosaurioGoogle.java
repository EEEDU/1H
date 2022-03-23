package Ejercicio023;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class DinosaurioGoogle extends Applet implements Runnable {
	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	Dinosaurio dinosaurio;
	List<Arbol> arboles;
	List<Pasar> pasar;
	
	int vel;

	int tiempo;
	int puntuacion;
	int puntuacionSalto;
	int saltoBueno;

	boolean perder;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		dinosaurio = new Dinosaurio();
		
		vel = 0;

		arboles = new ArrayList<Arbol>();
		crearArbol();


		pasar = new ArrayList<Pasar>();
		crearPasar();
		tiempo = 0;
		puntuacion = 0;
		puntuacionSalto = 0;
		saltoBueno = 0;

		perder = false;

		this.resize(900, 600);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			dinosaurio.actualizar(vel);

			for (int i = 0; i < arboles.size(); i++) {
				arboles.get(i).actualizar();
			}

			for (int i = 0; i < pasar.size(); i++) {
				pasar.get(i).actualizar();
			}

			tiempo += 20;
			if (tiempo == 2000) {
				crearArbol();
				crearPasar();
				tiempo = 0;
			}
			puntuacion += 20;
			chocar();
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

		for (int i = 0; i < pasar.size(); i++) {
			pasar.get(i).dibujar(noSeVe);
		}

		noSeVe.setColor(Color.BLACK);
		noSeVe.drawString("Tiempo: " + puntuacion / 1000, 50, 50);
		noSeVe.drawString("Puntuacion: " + puntuacionSalto / 17, 50, 100);

		dinosaurio.dibujar(noSeVe);



		for (int i = 0; i < arboles.size(); i++) {
			arboles.get(i).dibujar(noSeVe);
		}

		if (perder) {
			dinosaurio = null;
			noSeVe.setColor(Color.BLACK);
			noSeVe.drawString("Has perdido", 400, 300);
			noSeVe.drawString("Has sobrevivido " + puntuacion / 1000 + " segundos", 350, 340);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean keyDown(Event evt, int key) {
		if (key == 32) {
			vel = 10;
			if (!perder) {
				saltoBueno++;
				System.out.println(saltoBueno);
			}
		}

		return true;
	}

//	public boolean keyUp(Event evt, int key) {
//
//		if (key == 32) {
//			vel = -10;
//		}
//		return true;
//	}

	private void chocar() {
		if (dinosaurio.y > 500) {
			dinosaurio.y = 500;
			vel = 0;
			dinosaurio.setSubir(true);
		}

		for (int i = 0; i < arboles.size(); i++) {
			if (dinosaurio.intersects(arboles.get(i))) {
				perder = true;
			}

			if (arboles.get(i).x <= -40) {
				arboles.remove(i);
			}
		}

		for (int i = 0; i < pasar.size(); i++) {
			if (dinosaurio.intersects(pasar.get(i))) {
				puntuacionSalto++;
			}
		}
	}

	public void crearArbol() {
		arboles.add(new Arbol());
	}

	public void crearPasar() {
		pasar.add(new Pasar());
	}


}
