package EjercicioEx4;

import java.awt.Color;
import java.awt.Graphics;

import EjercicioEx4.Arkanoid.GameObject;


public class Pelota extends GameObject {

	double x, y;
	double radius = BALL_RADIUS;
	double velocityX = BALL_VELOCITY;
	double velocityY = BALL_VELOCITY;

	Pelota(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int) izquierda(), (int) arriba(), (int) radius * 2, (int) radius * 2);
	}

	void update(Marcador scoreBoard, Raqueta paddle) {
		x += velocityX * FT_STEP;
		y += velocityY * FT_STEP;

		if (izquierda() < 0)
			velocityX = BALL_VELOCITY;
		else if (derecha() > SCREEN_WIDTH)
			velocityX = -BALL_VELOCITY;
		if (arriba() < 0) {
			velocityY = BALL_VELOCITY;
		} else if (abajo() > SCREEN_HEIGHT) {
			velocityY = -BALL_VELOCITY;
			x = paddle.x;
			y = paddle.y - 50;
			scoreBoard.die();
		}

	}

	double izquierda() {
		return x - radius;
	}

	double derecha() {
		return x + radius;
	}

	double arriba() {
		return y - radius;
	}

	double abajo() {
		return y + radius;
	}

}