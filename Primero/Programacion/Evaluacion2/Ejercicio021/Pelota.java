package Ejercicio021;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota extends Rectangle {

	Color color;

	int limX = 900, limY = 600;

	Random random;

	int direccion;

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;

	public Pelota(int posX, int posY, int anchura, int altura) {
		super(posX, posY, anchura, altura);

		color = Color.RED;

		random = new Random();

		direccion = random.nextInt(4);
	}

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public void actualizar() {
		switch (direccion) {
		case DERECHA_ARRIBA:
			x++;
			y--;
			if (x >= limX - width) {
				direccion = IZQUIERDA_ARRIBA;
			} else if (y <= 0) {
				direccion = DERECHA_ABAJO;
			}
			break;
		case DERECHA_ABAJO:
			x++;
			y++;
			if (x >= limX - width) {
				direccion = IZQUIERDA_ABAJO;
			} else if (y >= limY - height) {
				direccion = DERECHA_ARRIBA;
			}
			break;
		case IZQUIERDA_ARRIBA:
			x--;
			y--;
			if (x <= 0) {
				direccion = DERECHA_ARRIBA;
			} else if (y <= 0) {
				direccion = IZQUIERDA_ABAJO;
			}
			break;
		case IZQUIERDA_ABAJO:
			x--;
			y++;
			if (x <= 0) {
				direccion = DERECHA_ABAJO;
			} else if (y >= limY - height) {
				direccion = IZQUIERDA_ARRIBA;
			}
			break;
		}
	}
}
