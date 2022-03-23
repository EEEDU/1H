package Ejercicio011;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class DosPuntos {

	public static final int LINEA = 0;
	public static final int OVALO = 1;
	public static final int RECTANGULO = 2;

	private int posInicioX, posInicioY, posFinX, posFinY, tipo;

	Color color;
	Random random;

	public DosPuntos(int inicioX, int inicioY, int finX, int finY, int tipo) {

		this.posInicioX = inicioX;
		this.posInicioY = inicioY;
		this.posFinX = finX;
		this.posFinY = finY;
		this.tipo = tipo;

		random = new Random();
		color = new Color(random.nextInt(200), random.nextInt(200), random.nextInt(200));
	}

	public DosPuntos(int inicioX, int inicioY, int tipo) {
		this(inicioX, inicioY, inicioX, inicioY, tipo);
	}

	public DosPuntos() {
		this(0, 0, LINEA);
	}

	public int getPosInicioX() {
		return posInicioX;
	}

	public void setPosInicioX(int posInicioX) {
		this.posInicioX = posInicioX;
	}

	public int getPosInicioY() {
		return posInicioY;
	}

	public void setPosInicioY(int posInicioY) {
		this.posInicioY = posInicioY;
	}

	public int getPosFinX() {
		return posFinX;
	}

	public void setPosFinX(int posFinX) {
		this.posFinX = posFinX;
	}

	public int getPosFinY() {
		return posFinY;
	}

	public void setPosFinY(int posFinY) {
		this.posFinY = posFinY;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public void dibujar(Graphics g) {
		int anchura = Math.abs(posFinX - posInicioX), altura = Math.abs(posFinY - posInicioY);
		g.setColor(color);

		switch (tipo) {
		case LINEA:
			g.drawLine(posInicioX, posInicioY, posFinX, posFinY);
			break;
		case OVALO:
			g.drawOval(posInicioX, posInicioY, anchura, altura);
			break;
		case RECTANGULO:
			g.drawRect(posInicioX, posInicioY, anchura, altura);
			break;
		}
	}
}
