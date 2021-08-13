package Ejercicio015;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Pelota2 extends Rectangle {

	Color color;

	int vel;
	int limX, limY;
	Random random;

	public static final int DERECHA_ARRIBA = 0;
	public static final int DERECHA_ABAJO = 1;
	public static final int IZQUIERDA_ARRIBA = 2;
	public static final int IZQUIERDA_ABAJO = 3;
	int direccion;

	boolean inicioDireccion;
	int dimension;

	public Pelota2() {
		super((int) (Math.random() * 500) + 20, (int) (Math.random() * 100) + 400, 0, 0);

		dimension = 30;
		limX = 900 - dimension;
		limY = 600 - dimension;
		width = height = dimension;
		random = new Random();
		color = Color.BLACK;
		vel = 10;

		inicioDireccion = random.nextBoolean();

		if (inicioDireccion) {
			direccion = DERECHA_ARRIBA;
		} else {
			direccion = IZQUIERDA_ARRIBA;
		}
	}

	public Pelota2(int posX, int posY, int anchura, int altura) {
		super(posX, posY, anchura, altura);

		color = Color.RED;
	}

	

	public void dibujar(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}



	public void actualizar() {
		switch (direccion) {
		case DERECHA_ARRIBA:
			x = x + vel;
			y = y - vel;
			if (x >= limX) {
				direccion = IZQUIERDA_ARRIBA;
			} else if (y <= 0) {
				direccion = DERECHA_ABAJO;
			}
			break;
		case DERECHA_ABAJO:
			x = x + vel;
			y = y + vel;
			if (x >= limX) {
				direccion = IZQUIERDA_ABAJO;
			} else if (y >= limY) {
				direccion = DERECHA_ARRIBA;
			}
			break;
		case IZQUIERDA_ARRIBA:
			x = x - vel;
			y = y - vel;
			if (x <= 0) {
				direccion = DERECHA_ARRIBA;
			} else if (y <= 0) {
				direccion = IZQUIERDA_ABAJO;
			}
			break;
		case IZQUIERDA_ABAJO:
			x = x - vel;
			y = y + vel;
			if (x <= 0) {
				direccion = DERECHA_ABAJO;
			} else if (y >= limY) {
				direccion = IZQUIERDA_ARRIBA;
			}
			break;
		}
	}

	public int getDireccion() {
		return direccion;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getLimX() {
		return limX;
	}

	public void setLimX(int limX) {
		this.limX = limX;
	}

	public int getLimY() {
		return limY;
	}

	public void setLimY(int limY) {
		this.limY = limY;
	}

	public int getVel() {
		return vel;
	}

	public void setVel(int vel) {
		this.vel = vel;
	}

}
