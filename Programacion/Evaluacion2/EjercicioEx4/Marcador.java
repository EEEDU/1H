package EjercicioEx4;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Marcador {

	int puntuacion = 0;
	int vidas;
	boolean ganar = false;
	boolean perder = false;
	String text = "";
	double COUNT_BLOCKS_X, COUNT_BLOCKS_Y;

	Font font;

	Marcador(int PLAYER_LIVES, String FONT, double COUNT_BLOCKS_X, double COUNT_BLOCKS_Y) {
		font = new Font(FONT, Font.PLAIN, 12);
		text = "Welcome to Arkanoid Java version";
		vidas = PLAYER_LIVES;
		this.COUNT_BLOCKS_X = COUNT_BLOCKS_X;
		this.COUNT_BLOCKS_Y = COUNT_BLOCKS_Y;
	}

	void aumentar_marcador() {
		puntuacion++;
		if (puntuacion == (COUNT_BLOCKS_X * COUNT_BLOCKS_Y)) {
			ganar = true;
			text = "You have won! \nYour score was: " + puntuacion + "\n\nPress Enter to restart";
		} else {
			actualizarMarcador();
		}
	}

	void die() {
		vidas--;
		if (vidas == 0) {
			perder = true;
			text = "You have lost! \nYour score was: " + puntuacion + "\n\nPress Enter to restart";
		} else {
			actualizarMarcador();
		}
	}

	void actualizarMarcador() {
		text = "Score: " + puntuacion + "  Lives: " + vidas;
	}

	void draw(Graphics g, int SCREEN_WIDTH, int SCREEN_HEIGHT) {
		if (ganar || perder) {
			font = font.deriveFont(50f);
			FontMetrics fontMetrics = g.getFontMetrics(font);
			g.setColor(Color.WHITE);
			g.setFont(font);
			int titleHeight = fontMetrics.getHeight();
			int lineNumber = 1;
			for (String line : text.split("\n")) {
				int titleLen = fontMetrics.stringWidth(line);
				g.drawString(line, (SCREEN_WIDTH / 2) - (titleLen / 2),
						(SCREEN_HEIGHT / 4) + (titleHeight * lineNumber));
				lineNumber++;

			}
		} else {
			font = font.deriveFont(34f);
			FontMetrics fontMetrics = g.getFontMetrics(font);
			g.setColor(Color.WHITE);
			g.setFont(font);
			int titleLen = fontMetrics.stringWidth(text);
			int titleHeight = fontMetrics.getHeight();
			g.drawString(text, (SCREEN_WIDTH / 2) - (titleLen / 2), titleHeight + 5);

		}
	}

}