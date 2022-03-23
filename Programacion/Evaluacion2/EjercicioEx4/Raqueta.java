package EjercicioEx4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

//Raqueta
public class Raqueta extends Rectangle {

	double velocidad = 0.0;

	double x, y;
	double anchura, altura;

	public Raqueta(double x, double y, double PADDLE_WIDTH, double PADDLE_HEIGHT) {
		this.x = x;
		this.y = y;
		this.anchura = PADDLE_WIDTH;
		this.altura = PADDLE_HEIGHT;
	}

	void actualizar(double FT_STEP) {
		x += velocidad * FT_STEP;
	}

	void pararMovimiento() {
		velocidad = 0.0;
	}

	void moverIzquierda() {
		if (izquierda() > 0.0) {
			velocidad = -PADDLE_VELOCITY;
		} else {
			velocidad = 0.0;
		}
	}

	void moverDerecha() {
		if (derecha() < SCREEN_WIDTH) {
			velocidad = PADDLE_VELOCITY;
		} else {
			velocidad = 0.0;
		}
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) (izquierda()), (int) (arriba()), (int) anchura, (int) altura);
	}

}
