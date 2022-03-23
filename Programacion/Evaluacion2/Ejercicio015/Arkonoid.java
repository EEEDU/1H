package Ejercicio015;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;



public class Arkonoid extends Applet implements Runnable {

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;
	public static final int DERECHA = 0;
	public static final int IZQUIERDA = 1;

	Pelota2 pelota;
	List<Ladrillo> ladrillos;
	Raqueta raqueta;

	List<Pelota2> corazones;
	int posXCorazones = 10, posYCorazones = 5, anchuraCorazones = 10, alturaCorazones = 10;
	int vidas;

	public static int numLadrillos = 60;
	int posX = 5, posY = 20;
	int aumentarVel = 0;

	Color[] color = { Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE };

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(900, 600);
		noSeVe = imagen.getGraphics();

		pelota = new Pelota2();

		ladrillos = new ArrayList<Ladrillo>();
		for (int i = 0; i < numLadrillos; i++) {
			if (i % 10 == 0 && i != 0) {
				posY = posY + 40;
				posX = 5;
			}
			ladrillos.add(new Ladrillo(posX, posY, 80, 30, color[i / 10]));
			posX = posX + 90;
		}

		raqueta = new Raqueta();
		
		corazones = new ArrayList<Pelota2>();
		for (int i = 0; i < 3; i++) {
			corazones.add(new Pelota2(posXCorazones + (i * 15), posYCorazones, anchuraCorazones, alturaCorazones));
		}
		vidas = 3;
		this.resize(900, 600);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();
			pelota.actualizar();
			chocar();
			perder();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 900, 600);
		pelota.dibujar(noSeVe);
		for (int i = 0; i < ladrillos.size(); i++) {
			ladrillos.get(i).dibujar(noSeVe);
		}
		raqueta.dibujar(noSeVe);
		for (int i = 0; i < corazones.size(); i++) {
			corazones.get(i).dibujar(noSeVe);
		}
		if (ladrillos.size() == 0) {
			pelota = null;
			noSeVe.drawString("¡HAS GANADO!", 400, 300);
		}
		if (vidas == 0) {
			pelota = null;
			noSeVe.drawString("¡HAS PERDIDO!", 400, 300);
		}
		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	public boolean mouseMove(Event evt, int x, int y) {
		raqueta.setLocation(x, 540);

		return true;
	}

	public boolean chocar() {
		for (int i = 0; i < ladrillos.size(); i++) {
			if (pelota.intersects(ladrillos.get(i))) {
				ladrillos.remove(i);
				if (pelota.getDireccion() == DERECHA_ARRIBA) {
					pelota.setDireccion(DERECHA_ABAJO);
					aumentarVel++;
				} else if (pelota.getDireccion() == IZQUIERDA_ARRIBA) {
					pelota.setDireccion(IZQUIERDA_ABAJO);
					aumentarVel++;
				} else if (pelota.getDireccion() == DERECHA_ABAJO) {
					pelota.setDireccion(DERECHA_ARRIBA);
					aumentarVel++;
				} else if (pelota.getDireccion() == IZQUIERDA_ABAJO) {
					pelota.setDireccion(IZQUIERDA_ARRIBA);
					aumentarVel++;
				}
				if (aumentarVel % 10 == 0 && aumentarVel != 0) {
					pelota.setVel(pelota.getVel() + 1);
				}
			}
		}
		if (pelota.intersects(raqueta)) {
			if (pelota.getDireccion() == DERECHA_ABAJO) {
				pelota.setDireccion(DERECHA_ARRIBA);
			}
			if (pelota.getDireccion() == IZQUIERDA_ABAJO) {
				pelota.setDireccion(IZQUIERDA_ARRIBA);
			}
		}
		return true;
	}

	public void perder() {
		if (pelota.getY() >= pelota.getLimY()) {
			switch (vidas) {
			case (3):
				corazones.remove(vidas - 1);
				vidas--;
				break;
			case (2):
				corazones.remove(vidas - 1);
				vidas--;
				break;
			case (1):
				corazones.remove(vidas - 1);
				vidas--;
				break;

			}
		}
	}


}
