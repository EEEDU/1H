package Ejemplo_programación_Examen2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Jugando extends Applet implements Runnable {
	public static final int NUM_BALAS = 20;
	Thread animacion;
	Image imagen;
	Graphics noseve;
	List<Bala> balas;
	Rectangle paleta;

	public void init() {
		imagen = createImage(300, 300);
		noseve = imagen.getGraphics();
		balas = new ArrayList<Bala>();
		for (int i = 0; i < NUM_BALAS; i++)
			balas.add(new Bala());
		paleta = new Rectangle(175, 280, 50, 10);
		resize(300, 300);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start(); // llama al método run
	}

	public void paint(Graphics g) {
		noseve.setColor(Color.black);
		noseve.fillRect(0, 0, 300, 300);
		noseve.setColor(Color.red);
		noseve.fillRect(paleta.x, paleta.y, paleta.width, paleta.height);
		for (int i = 0; i < balas.size(); i++)
			balas.get(i).dibujar(noseve);

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public void run() {
		while (true) {
			for (int i = 0; i < balas.size(); i++) {
				balas.get(i).actualizar();
				if (balas.get(i).intersects(paleta))
					animacion.stop();
			}
			repaint();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}
			;
		}
	}

	public boolean mouseMove(Event ev, int x, int y) {
		paleta.x = x - 25;
		return true;
	}
}