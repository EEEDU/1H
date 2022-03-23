package EjercicioEx4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;

public class Arkanoid extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;

	/* CONSTANTS - constantes */

	// Dimensiones de la pantalla
	public static final int ANCHURA_PANTALLA = 800;
	public static final int ALTURA_PANTALLA = 600;

	// Dimensiones y velocidad de la pelota
	public static final double RADIO_PELOTA = 10.0;
	public static final double VELOCIDAD_PELOTA = 0.4;

	// Dimensiones y velocidad de la raqueta
	public static final double ANCHURA_RAQUETA = 100.0;
	public static final double ALTURA_RAQUETA = 20.0;
	public static final double VELOCIDAD_RAQUETA = 0.6;

	// Dimensiones de los ladrillos
	public static final double ANCHURA_LADRILLO = 60.0;
	public static final double ALTURA_LADRILLO = 20.0;

	// Columnas y filas
	public static final int COLUMNAS_LADRILLOS = 11;
	public static final int FILAS_LADRILLOS = 4;

	// Vidas del jugador
	public static final int VIDAS_JUGADOR = 5;

	// No lo he entendido muy bien creo que son el numero de rejillas y el numero de
	// pasos
	public static final double NUMERO_REJILLAS = 1.0;
	public static final double NUMERO_PASOS = 1.0;

	// Tema de la fuente
	private static final String FUENTE = "Courier New";

	/* GAME VARIABLES - variables de juego */

	// No se lo que hace
	private boolean volver_intentar = false;
	private boolean correr = true;

	// Crear los objetos de las clases en este orden: raqueta, pelota, ladrillos,
	// marcador
	public Raqueta raqueta = new Raqueta(ANCHURA_PANTALLA / 2, ALTURA_PANTALLA - 50, ANCHURA_RAQUETA, ALTURA_RAQUETA);
	public Pelota pelota = new Pelota(ANCHURA_PANTALLA / 2, ALTURA_PANTALLA / 2);
	public List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
	public Marcador marcador = new Marcador(VIDAS_JUGADOR, FUENTE, COLUMNAS_LADRILLOS, FILAS_LADRILLOS);
	// TODO Cambiar ScoreBoard a marcador en todo el codigo

	// Creo que crea dos double que tienen la anterior rejilla y la actual
	private double rejilla_anterior;
	private double rejilla_actual;

//	abstract class GameObject {
//		abstract double izquierda();
//
//		abstract double derecha();
//
//		abstract double arriba();
//
//		abstract double abajo();
//	}
//
//	class Rectangle extends GameObject {
//
//		double x, y;
//		double anchura;
//		double altura;
//
//		double izquierda() {
//			return x - anchura / 2.0;
//		}
//
//		double derecha() {
//			return x + anchura / 2.0;
//		}
//
//		double arriba() {
//			return y - altura / 2.0;
//		}
//
//		double abajo() {
//			return y + altura / 2.0;
//		}
//
//	}
//
//	class ScoreBoard {
//
//		int score = 0;
//		int lives = PLAYER_LIVES;
//		boolean win = false;
//		boolean gameOver = false;
//		String text = "";
//
//		Font font;
//
//		ScoreBoard() {
//			font = new Font(FONT, Font.PLAIN, 12);
//			text = "Welcome to Arkanoid Java version";
//		}
//
//		void increaseScore() {
//			score++;
//			if (score == (COUNT_BLOCKS_X * COUNT_BLOCKS_Y)) {
//				win = true;
//				text = "You have won! \nYour score was: " + score + "\n\nPress Enter to restart";
//			} else {
//				updateScoreboard();
//			}
//		}
//
//		void die() {
//			lives--;
//			if (lives == 0) {
//				gameOver = true;
//				text = "You have lost! \nYour score was: " + score + "\n\nPress Enter to restart";
//			} else {
//				updateScoreboard();
//			}
//		}
//
//		void updateScoreboard() {
//			text = "Score: " + score + "  Lives: " + lives;
//		}
//
//		void draw(Graphics g) {
//			if (win || gameOver) {
//				font = font.deriveFont(50f);
//				FontMetrics fontMetrics = g.getFontMetrics(font);
//				g.setColor(Color.WHITE);
//				g.setFont(font);
//				int titleHeight = fontMetrics.getHeight();
//				int lineNumber = 1;
//				for (String line : text.split("\n")) {
//					int titleLen = fontMetrics.stringWidth(line);
//					g.drawString(line, (SCREEN_WIDTH / 2) - (titleLen / 2),
//							(SCREEN_HEIGHT / 4) + (titleHeight * lineNumber));
//					lineNumber++;
//
//				}
//			} else {
//				font = font.deriveFont(34f);
//				FontMetrics fontMetrics = g.getFontMetrics(font);
//				g.setColor(Color.WHITE);
//				g.setFont(font);
//				int titleLen = fontMetrics.stringWidth(text);
//				int titleHeight = fontMetrics.getHeight();
//				g.drawString(text, (SCREEN_WIDTH / 2) - (titleLen / 2), titleHeight + 5);
//
//			}
//		}
//
//	}

	class Raqueta extends Rectangle {

		double velocidad = 0.0;

		public Raqueta(double x, double y) {
			this.x = x;
			this.y = y;
			this.anchura = ANCHURA_RAQUETA;
			this.altura = ALTURA_RAQUETA;
		}

		void actualizar() {
			x += velocidad * NUMERO_PASOS;
		}

		void pararMovimiento() {
			velocidad = 0.0;
		}

		void moverIzquierda() {
			if (izquierda() > 0.0) {
				velocidad = -VELOCIDAD_RAQUETA;
			} else {
				velocidad = 0.0;
			}
		}

		void moverDerecha() {
			if (derecha() < ANCHURA_PANTALLA) {
				velocidad = VELOCIDAD_RAQUETA;
			} else {
				velocidad = 0.0;
			}
		}

		void dibujar(Graphics g) {
			g.setColor(Color.RED);
			g.fillRect((int) (izquierda()), (int) (arriba()), (int) anchura, (int) altura);
		}

	}

	class Ladrillo extends Rectangle {

		boolean destruido = false;

		Ladrillo(double x, double y) {
			this.x = x;
			this.y = y;
			this.anchura = ANCHURA_LADRILLO;
			this.altura = ALTURA_LADRILLO;
		}

		void dibujar(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillRect((int) izquierda(), (int) arriba(), (int) anchura, (int) altura);
		}
	}

	class Pelota extends GameObject {

		double x, y;
		double radio = RADIO_PELOTA;
		double velocidadX = VELOCIDAD_PELOTA;
		double velodidadY = VELOCIDAD_PELOTA;

		Pelota(int x, int y) {
			this.x = x;
			this.y = y;
		}

		void draw(Graphics g) {
			g.setColor(Color.RED);
			g.fillOval((int) izquierda(), (int) arriba(), (int) radio * 2, (int) radio * 2);
		}

		void actualizar(Marcador marcador, Raqueta raqueta) {
			x += velocidadX * NUMERO_PASOS;
			y += velodidadY * NUMERO_PASOS;

			if (izquierda() < 0)
				velocidadX = VELOCIDAD_PELOTA;
			else if (derecha() > ANCHURA_PANTALLA)
				velocidadX = -VELOCIDAD_PELOTA;
			if (arriba() < 0) {
				velodidadY = VELOCIDAD_PELOTA;
			} else if (abajo() > ALTURA_PANTALLA) {
				velodidadY = -VELOCIDAD_PELOTA;
				x = raqueta.x;
				y = raqueta.y - 50;
				marcador.die();
			}

		}

		double izquierda() {
			return x - radio;
		}

		double derecha() {
			return x + radio;
		}

		double arriba() {
			return y - radio;
		}

		double abajo() {
			return y + radio;
		}

	}

	boolean intersectar(GameObject mA, GameObject mB) {
		return mA.derecha() >= mB.izquierda() && mA.izquierda() <= mB.derecha() && mA.abajo() >= mB.arriba() && mA.arriba() <= mB.abajo();
	}

	void colisionar(Raqueta mRaqueta, Pelota mPelota) {
		if (!intersectar(mRaqueta, mPelota))
			return;
		mPelota.velodidadY = -VELOCIDAD_PELOTA;
		if (mPelota.x < mRaqueta.x)
			mPelota.velocidadX = -VELOCIDAD_PELOTA;
		else
			mPelota.velocidadX = VELOCIDAD_PELOTA;
	}

	void colisionar(Ladrillo mLadrillo, Pelota mPelota, Marcador marcador) {
		if (!intersectar(mLadrillo, mPelota))
			return;

		mLadrillo.destruido = true;

		marcador.aumentar_marcador();

		double chocarIzquierda = mPelota.derecha() - mLadrillo.izquierda();
		double chocarDerecha = mLadrillo.derecha() - mPelota.izquierda();
		double chocarArriba = mPelota.abajo() - mLadrillo.arriba();
		double chocarAbajo = mLadrillo.abajo() - mPelota.arriba();

		boolean pelotaDesdeIzquierda = chocarIzquierda < chocarDerecha;
		boolean pelotaDesdeDerecha = chocarArriba < chocarAbajo;

		double minChocarY = pelotaDesdeIzquierda ? chocarIzquierda : chocarDerecha;
		double minChocarX = pelotaDesdeDerecha ? chocarArriba : chocarAbajo;

		if (minChocarY < minChocarX) {
			mPelota.velocidadX = pelotaDesdeIzquierda ? -VELOCIDAD_PELOTA : VELOCIDAD_PELOTA;
		} else {
			mPelota.velodidadY = pelotaDesdeDerecha ? -VELOCIDAD_PELOTA : VELOCIDAD_PELOTA;
		}
	}

	void inicializarLadrillos(List<Ladrillo> ladrillos) {
		// desasignar ladrillos viejos
		ladrillos.clear();

		for (int iX = 0; iX < COLUMNAS_LADRILLOS; ++iX) {
			for (int iY = 0; iY < FILAS_LADRILLOS; ++iY) {
				ladrillos.add(
						new Ladrillo((iX + 1) * (ANCHURA_LADRILLO + 3) + 22, (iY + 2) * (ALTURA_LADRILLO + 3) + 20));
			}
		}
	}

	public Arkanoid() {

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setUndecorated(false);
		this.setResizable(false);
		this.setSize(ANCHURA_PANTALLA, ALTURA_PANTALLA);
		this.setVisible(true);
		this.addKeyListener(this);
		this.setLocationRelativeTo(null);

		this.createBufferStrategy(2);

		inicializarLadrillos(ladrillos);

	}

	void run() {

		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = bf.getDrawGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());

		correr = true;

		while (correr) {

			long tiempo1 = System.currentTimeMillis();

			if (!marcador.perder && !marcador.ganar) {
				volver_intentar = false;
				update();
				dibujarEscena(pelota, ladrillos, marcador);

				// to simulate low FPS
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			} else {
				if (volver_intentar) {
					volver_intentar = false;
					inicializarLadrillos(ladrillos);
					marcador.vidas = VIDAS_JUGADOR;
					marcador.puntuacion = 0;
					marcador.ganar = false;
					marcador.perder = false;
					marcador.actualizarMarcador();
					pelota.x = ANCHURA_PANTALLA / 2;
					pelota.y = ALTURA_PANTALLA / 2;
					raqueta.x = ANCHURA_PANTALLA / 2;
				}
			}

			long tiempo2 = System.currentTimeMillis();
			double tiempoTranscurrido = tiempo2 - tiempo1;

			rejilla_anterior = tiempoTranscurrido;

			double segundos = tiempoTranscurrido / 1000.0;
			if (segundos > 0.0) {
				double fps = 1.0 / segundos;
				this.setTitle("FPS: " + fps);
			}

		}

		this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

	}

	private void update() {

		rejilla_actual += rejilla_anterior;

		for (; rejilla_actual >= NUMERO_REJILLAS; rejilla_actual -= NUMERO_REJILLAS) {

			pelota.actualizar(marcador, raqueta);
			raqueta.actualizar(NUMERO_PASOS);
			colisionar(raqueta, pelota);

			Iterator<Ladrillo> it = ladrillos.iterator();
			while (it.hasNext()) {
				Ladrillo ladrillos = it.next();
				colisionar(ladrillos, pelota, marcador);
				if (ladrillos.destruido) {
					it.remove();
				}
			}

		}
	}

	private void dibujarEscena(Pelota pelota, List<Ladrillo> ladrillos, Marcador marcador) {
		// Code for the drawing goes here.
		BufferStrategy bf = this.getBufferStrategy();
		Graphics g = null;

		try {

			g = bf.getDrawGraphics();

			g.setColor(Color.black);
			g.fillRect(0, 0, getWidth(), getHeight());

			pelota.draw(g);
			raqueta.dibujar(g);
			for (Ladrillo brick : ladrillos) {
				brick.dibujar(g);
			}
			marcador.draw(g, ANCHURA_PANTALLA, ALTURA_PANTALLA);

		} finally {
			g.dispose();
		}

		bf.show();

		Toolkit.getDefaultToolkit().sync();

	}

	@Override
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
			correr = false;
		}
		if (event.getKeyCode() == KeyEvent.VK_ENTER) {
			volver_intentar = true;
		}
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			raqueta.moverIzquierda();
			break;
		case KeyEvent.VK_RIGHT:
			raqueta.moverDerecha();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			raqueta.pararMovimiento();
			break;
		default:
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

	public static void main(String[] args) {
		new Arkanoid().run();
	}

}