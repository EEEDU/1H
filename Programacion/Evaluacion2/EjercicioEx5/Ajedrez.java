package EjercicioEx5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Ajedrez extends Applet implements Runnable {

	List<Cuadrado> cuadrados;

	List<Torre> torresBlancas;
	List<Torre> torresNegras;
	Torre moviendoTorre;

	List<Caballo> caballosBlancos;
	List<Caballo> caballosNegros;
	Caballo moviendoCaballo;

	List<Alfil> alfilesBlancos;
	List<Alfil> alfilesNegros;
	Alfil moviendoAlfil;

	List<Peon> peonesBlancos;
	List<Peon> peonesNegros;
	Peon moviendoPeon;

	Reina reinaBlanca;
	Reina reinaNegra;
	Reina moviendoReina;

	Rey reyBlanco;
	Rey reyNegro;
	Rey moviendoRey;

	int posX = 0, posY = 0;

	Thread animacion;

	Image imagen;
	Graphics noSeVe;

	public void init() {
		imagen = this.createImage(800, 800);
		noSeVe = imagen.getGraphics();

		crearTablero();
		crearNegras();
		crearBlancas();

		this.resize(800, 800);
	}

	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	public void run() {
		do {
			repaint();

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
			}

		} while (true);

	}

	public void paint(Graphics g) {
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 800, 800);

		for (int i = 0; i < cuadrados.size(); i++) {
			cuadrados.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < torresBlancas.size(); i++) {
			torresBlancas.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < torresNegras.size(); i++) {
			torresNegras.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < caballosBlancos.size(); i++) {
			caballosBlancos.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < caballosNegros.size(); i++) {
			caballosNegros.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < alfilesBlancos.size(); i++) {
			alfilesBlancos.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < alfilesNegros.size(); i++) {
			alfilesNegros.get(i).dibujar(noSeVe);
		}

		reinaBlanca.dibujar(noSeVe);
		reinaNegra.dibujar(noSeVe);

		reyBlanco.dibujar(noSeVe);
		reyNegro.dibujar(noSeVe);

		for (int i = 0; i < peonesNegros.size(); i++) {
			peonesNegros.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < peonesBlancos.size(); i++) {
			peonesBlancos.get(i).dibujar(noSeVe);
		}

		g.drawImage(imagen, 0, 0, this);
	}

	public void update(Graphics g) {
		paint(g);
	}

	private void crearTablero() {
		cuadrados = new ArrayList<Cuadrado>();

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 4; j++) {
				if (i % 2 == 0) {
					cuadrados.add(new Cuadrado(posX, posY, Color.LIGHT_GRAY));
					posX += 100;

					cuadrados.add(new Cuadrado(posX, posY, Color.DARK_GRAY));
					posX += 100;
				}
				if (i % 2 == 1) {
					cuadrados.add(new Cuadrado(posX, posY, Color.DARK_GRAY));
					posX += 100;

					cuadrados.add(new Cuadrado(posX, posY, Color.LIGHT_GRAY));
					posX += 100;
				}
			}
			posX = 0;
			posY += 100;
		}
	}

	private void crearNegras() {
		torresNegras = new ArrayList<Torre>();
		caballosNegros = new ArrayList<Caballo>();
		alfilesNegros = new ArrayList<Alfil>();
		reinaNegra = new Reina(300, 0, Color.BLACK);
		reyNegro = new Rey(400, 0, Color.BLACK);
		peonesNegros = new ArrayList<Peon>();

		for (int i = 0; i < 2; i++) {
			torresNegras.add(new Torre(i * 700, 0, Color.BLACK));
			caballosNegros.add(new Caballo((i * 500) + 100, 0, Color.BLACK));
			alfilesNegros.add(new Alfil((i * 300) + 200, 0, Color.BLACK));
		}

		for (int i = 0; i < 8; i++) {
			peonesNegros.add(new Peon((i * 100), 100, Color.BLACK));
		}
	}

	private void crearBlancas() {
		torresBlancas = new ArrayList<Torre>();
		caballosBlancos = new ArrayList<Caballo>();
		alfilesBlancos = new ArrayList<Alfil>();
		reinaBlanca = new Reina(300, 700, Color.WHITE);
		reyBlanco = new Rey(400, 700, Color.WHITE);
		peonesBlancos = new ArrayList<Peon>();

		for (int i = 0; i < 2; i++) {
			torresBlancas.add(new Torre(i * 700, 700, Color.WHITE));
			caballosBlancos.add(new Caballo((i * 500) + 100, 700, Color.WHITE));
			alfilesBlancos.add(new Alfil((i * 300) + 200, 700, Color.WHITE));
		}

		for (int i = 0; i < 8; i++) {
			peonesBlancos.add(new Peon((i * 100), 600, Color.WHITE));
		}
	}

	@Override
	public boolean mouseDrag(Event evt, int x, int y) {
		moverPeon(x, y);
		moverTorre(x, y);
		moverCaballo(x, y);
		return true;
	}

	public boolean mouseUp(Event evt, int x, int y) {
		colocarPeon(x, y);
		colocarTorre(x, y);
		colocarCaballo(x, y);
		return true;
	}

	// Peon
	private void moverPeon(int x, int y) {
		for (int i = 0; i < peonesBlancos.size(); i++) {
			if (peonesBlancos.get(i).contains(x, y)) {
				peonesBlancos.get(i).y = y - 50;
				peonesBlancos.get(i).x = x - 50;
			}
		}

		for (int i = 0; i < peonesNegros.size(); i++) {
			if (peonesNegros.get(i).contains(x, y)) {
				peonesNegros.get(i).y = y - 50;
				peonesNegros.get(i).x = x - 50;
			}
		}
	}

	private void colocarPeon(int x, int y) {
		for (int i = 0; i < peonesBlancos.size(); i++) {
			if (peonesBlancos.get(i).contains(x, y)) {
				peonesBlancos.get(i).x = (x / 100) * 100;
				peonesBlancos.get(i).y = (y / 100) * 100;
			}
		}

		for (int i = 0; i < peonesNegros.size(); i++) {
			if (peonesNegros.get(i).contains(x, y)) {
				peonesNegros.get(i).x = (x / 100) * 100;
				peonesNegros.get(i).y = (y / 100) * 100;
			}
		}
	}

	// Torre
	private void moverTorre(int x, int y) {
		for (int i = 0; i < torresBlancas.size(); i++) {
			if (torresBlancas.get(i).contains(x, y)) {
				torresBlancas.get(i).y = y - 50;
				torresBlancas.get(i).x = x - 50;
			}
		}

		for (int i = 0; i < torresNegras.size(); i++) {
			if (torresNegras.get(i).contains(x, y)) {
				torresNegras.get(i).y = y - 50;
				torresNegras.get(i).x = x - 50;
			}
		}
	}

	private void colocarTorre(int x, int y) {
		for (int i = 0; i < torresBlancas.size(); i++) {
			if (torresBlancas.get(i).contains(x, y)) {
				torresBlancas.get(i).x = (x / 100) * 100;
				torresBlancas.get(i).y = (y / 100) * 100;
			}
		}

		for (int i = 0; i < torresNegras.size(); i++) {
			if (torresNegras.get(i).contains(x, y)) {
				torresNegras.get(i).x = (x / 100) * 100;
				torresNegras.get(i).y = (y / 100) * 100;
			}
		}
	}

	// Caballo
	private void moverCaballo(int x, int y) {
		for (int i = 0; i < caballosBlancos.size(); i++) {
			if (caballosBlancos.get(i).contains(x, y)) {
				caballosBlancos.get(i).y = y - 50;
				caballosBlancos.get(i).x = x - 50;
			}
		}

		for (int i = 0; i < caballosNegros.size(); i++) {
			if (caballosNegros.get(i).contains(x, y)) {
				caballosNegros.get(i).y = y - 50;
				caballosNegros.get(i).x = x - 50;
			}
		}
	}

	private void colocarCaballo(int x, int y) {
		for (int i = 0; i < caballosBlancos.size(); i++) {
			if (caballosBlancos.get(i).contains(x, y)) {
				caballosBlancos.get(i).x = (x / 100) * 100;
				caballosBlancos.get(i).y = (y / 100) * 100;
			}
		}

		for (int i = 0; i < caballosNegros.size(); i++) {
			if (caballosNegros.get(i).contains(x, y)) {
				caballosNegros.get(i).x = (x / 100) * 100;
				caballosNegros.get(i).y = (y / 100) * 100;
			}
		}
	}

	// Alfil
	private void moverAlfil(int x, int y) {
		for (int i = 0; i < alfilesBlancos.size(); i++) {
			if (alfilesBlancos.get(i).contains(x, y)) {
				alfilesBlancos.get(i).y = y - 50;
				alfilesBlancos.get(i).x = x - 50;
			}
		}

		for (int i = 0; i < alfilesNegros.size(); i++) {
			if (alfilesNegros.get(i).contains(x, y)) {
				alfilesNegros.get(i).y = y - 50;
				alfilesNegros.get(i).x = x - 50;
			}
		}
	}

	private void colocarAlfil(int x, int y) {
		for (int i = 0; i < alfilesBlancos.size(); i++) {
			if (alfilesBlancos.get(i).contains(x, y)) {
				alfilesBlancos.get(i).x = (x / 100) * 100;
				alfilesBlancos.get(i).y = (y / 100) * 100;
			}
		}

		for (int i = 0; i < alfilesNegros.size(); i++) {
			if (alfilesNegros.get(i).contains(x, y)) {
				alfilesNegros.get(i).x = (x / 100) * 100;
				alfilesNegros.get(i).y = (y / 100) * 100;
			}
		}
	}

	// Reina
	private void moverReina(int x, int y) {
		if (reinaBlanca.contains(x, y)) {
			reinaBlanca.y = y - 50;
			reinaBlanca.x = x - 50;
		}

		if (reinaNegra.contains(x, y)) {
			reinaNegra.y = y - 50;
			reinaNegra.x = x - 50;
		}
	}

	private void colocarReina(int x, int y) {
		if (reinaBlanca.contains(x, y)) {
			reinaBlanca.x = (x / 100) * 100;
			reinaBlanca.y = (y / 100) * 100;
		}

		if (reinaNegra.contains(x, y)) {
			reinaNegra.x = (x / 100) * 100;
			reinaNegra.y = (y / 100) * 100;
		}
	}

	// Rey
	private void moverRey(int x, int y) {
		if (reyBlanco.contains(x, y)) {
			reyBlanco.y = y - 50;
			reyBlanco.x = x - 50;
			}

			if (reyNegro.contains(x, y)) {
				reyNegro.y = y - 50;
				reyNegro.x = x - 50;
			}
		}

		private void colocarRey(int x, int y) {
			if (reyBlanco.contains(x, y)) {
				reyBlanco.x = (x / 100) * 100;
				reyBlanco.y = (y / 100) * 100;
			}

			if (reyNegro.contains(x, y)) {
				reyNegro.x = (x / 100) * 100;
				reyNegro.y = (y / 100) * 100;
			}
		}
}