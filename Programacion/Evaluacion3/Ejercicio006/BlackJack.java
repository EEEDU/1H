package Ejercicio006;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlackJack extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[][] dibujoCartas;
	Image dibujoReverso;

	TextField apuesta;
	Panel panel;
	Label etiqueta;
	// Crear objetos

	List<Carta> cartas;
	List<Carta> reversos;
	List<Boton> botones;

	// Crear variable

	int longitudBaraja;
	int[] numCartas;
	int numCartasJugador;
	int numCartasCPU;
	int manoJugador;
	int manoCPU;
	// si ganar = 0 gana jugador ; si ganar = 1 gana cpu
	int ganar;
	int dinero;
	int numApuesta;

	boolean empezar;
	boolean terminar;
	boolean haberApuesta;
	boolean asCPU;
	boolean asJugador;
	boolean pasar;

	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1700, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();

		apuesta = new TextField("", 10);
		panel = new Panel();
		etiqueta = new Label("Introduce la apuesta", Label.RIGHT);
		panel.add(etiqueta);
		panel.add(apuesta);
		this.add("North", panel);

		empezar = false;
		terminar = false;
		asCPU = false;
		asJugador = false;
		haberApuesta = false;
		pasar = true;

		numCartasJugador = 0;
		numCartasCPU = 0;
		longitudBaraja = 51;
		manoJugador = 0;
		manoCPU = 0;
		ganar = 3;
		dinero = 1000000;

		numCartas = new int[longitudBaraja];
		for (int i = 0; i < numCartas.length; i++) {
			numCartas[i] = i + 1;
		}

		dibujoCartas = new Image[4][13];
		for (int i = 0; i < dibujoCartas[0].length; i++) {
			dibujoCartas[0][i] = getImage(getDocumentBase(), "Sprites6/" + (i + 1) + "_of_clubs.png");
		}
		for (int i = 0; i < dibujoCartas[1].length; i++) {
			dibujoCartas[1][i] = getImage(getDocumentBase(), "Sprites6/" + (i + 1) + "_of_diamonds.png");
		}
		for (int i = 0; i < dibujoCartas[2].length; i++) {
			dibujoCartas[2][i] = getImage(getDocumentBase(), "Sprites6/" + (i + 1) + "_of_hearts.png");
		}
		for (int i = 0; i < dibujoCartas[3].length; i++) {
			dibujoCartas[3][i] = getImage(getDocumentBase(), "Sprites6/" + (i + 1) + "_of_spades.png");
		}

		dibujoReverso = getImage(getDocumentBase(), "Sprites6/reverso.png");

		cartas = new ArrayList<Carta>();
		for (int i = 0; i < dibujoCartas.length; i++) {
			for (int j = 0; j < dibujoCartas[i].length; j++) {
				cartas.add(new Carta(200, 350, dibujoCartas[i][j], j + 1));
			}
		}
		cartas.add(new Carta(200, 350, dibujoReverso, 0));
		reversos = new ArrayList<Carta>();

		botones = new ArrayList<Boton>();

		botones.add(new Boton(1000, 200, 200, 200, "JUGAR", Color.RED));
		botones.add(new Boton(1400, 200, 200, 200, "PASAR", Color.BLUE));
		botones.add(new Boton(1200, 400, 200, 200, "REPETIR", Color.BLACK));

		this.resize(1700, 900);
	}

	// Llama al metodo run
	public void start() {
		animacion = new Thread(this);
		animacion.start();
	}

	// Se ejecuta todo el rato
	public void run() {
		do {

			// Todas las llamadas a los movimientos de los objetos
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
			}

		} while (true);
	}

	// Dibujar, cuanto mas abajo mas superpuesto
	public void paint(Graphics g) {

		// Pintar pantalla
		noSeVe.setColor(Color.WHITE);
		noSeVe.fillRect(0, 0, 1700, 900);

		// Todas las llamadas a los metodos dibujar de los objetos

		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < reversos.size(); i++) {
			reversos.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < botones.size(); i++) {
			botones.get(i).dibujar(noSeVe);
		}

		noSeVe.setColor(Color.black);
		if (ganar == 0) {
			noSeVe.drawString("Gana el jugador", 50, 50);
		}

		if (ganar == 1) {
			noSeVe.drawString("Gana la CPU", 50, 50);
		}

		if (ganar == 2) {
			noSeVe.drawString("EMPATE", 50, 50);
		}

		noSeVe.drawString(dinero + "€", 1500, 700);

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {
		if (cartas.get(52).contains(x, y) && empezar) {
			sacarCarta();
		}

		for (int i = 0; i < botones.size(); i++) {
			if (botones.get(i).contains(x, y)) {
				if (botones.get(i).frase == "JUGAR" && !empezar && haberApuesta) {
					empezar = true;
					sacarCarta();
					sacarCarta();
					darCarta();
					darCarta();
					dinero -= numApuesta;
					pasar = true;
				}
				if (botones.get(i).frase == "PASAR" && empezar) {
					for (int j = 0; j < reversos.size(); j++) {
						reversos.remove(j);
					}
					if (asCPU && manoCPU + 10 >= 19 && manoCPU + 10 <= 21) {
						manoCPU += 10;
					}
					while (manoCPU <= 17) {
						if (asCPU && manoCPU + 10 <= 17) {
							break;
						}
						darCartaFinal();
					}

					if (asJugador && manoJugador + 10 <= 21) {
						manoJugador += 10;
					}

					comprobar();

				}
				if (botones.get(i).frase == "REPETIR" && terminar) {
					apuesta.setEditable(true);
					empezar = false;
					for (int j = 0; j < cartas.size(); j++) {
						cartas.get(j).x = 200;
						cartas.get(j).y = 350;
						numCartasCPU = 0;
						numCartasJugador = 0;
						asCPU = false;
						asJugador = false;
						manoCPU = 0;
						manoJugador = 0;
					}
				}
			}
		}
		return true;
	}

	public void darCartaFinal() {
		int numero = elegirNumero(false);
		cartas.get(numero).x = 300 + (150 * (numCartasCPU - 1));
		cartas.get(numero).y = 100;
		manoCPU += cartas.get(numero).valor;
		if (cartas.get(numero).valor == 1) {
			asCPU = true;
		}
	}

	public void darCarta() {
		int numero = elegirNumero(false);
		cartas.get(numero).x = 300 + (150 * (numCartasCPU - 1));
		cartas.get(numero).y = 100;
		manoCPU += cartas.get(numero).valor;
		if (cartas.get(numero).valor == 1) {
			asCPU = true;
		}
		reversos.add(new Carta(300 + (150 * (numCartasCPU - 1)), 100, dibujoReverso, 0));
	}

	public void sacarCarta() {
		int numero = elegirNumero(true);
		cartas.get(numero).x = 300 + (150 * (numCartasJugador - 1));
		cartas.get(numero).y = 700;
		manoJugador += cartas.get(numero).valor;
		if (cartas.get(numero).valor == 1) {
			asJugador = true;
		}
	}

	public int elegirNumero(boolean jugador) {
		int numAleatorio = random.nextInt(longitudBaraja - 2);
		int cartaSacada = numCartas[numAleatorio];
		numCartas[numAleatorio] = numCartas[longitudBaraja - 1];
		longitudBaraja--;
		if (jugador) {
			numCartasJugador++;
		} else {
			numCartasCPU++;
		}
		return cartaSacada;

	}

	public void comprobar() {
		for (int j = 0; j < reversos.size(); j++) {
			reversos.remove(j);
		}
		if (manoJugador > manoCPU && manoJugador < 21) {
			ganar = 0;
			if (pasar) {
				if (manoJugador == 21) {
					dinero += numApuesta * 3;
				} else {
					dinero += numApuesta * 2;
				}
				pasar = false;
			}
		}
		else if (manoJugador > 21 && manoCPU < 21) {
			ganar = 1;
		}
		else if (manoCPU > manoJugador && manoCPU < 21) {
			ganar = 1;
		}
		else if (manoCPU > 21 && manoJugador < 21) {
			ganar = 0;
			if (pasar) {
				if (manoJugador == 21) {
					dinero += numApuesta * 3;
				} else {
					dinero += numApuesta * 2;
				}
				pasar = false;
			}
		}
		else if (manoJugador == manoCPU || (manoCPU > 21 && manoJugador > 21)) {
			ganar = 2;
			if (pasar) {
				dinero += numApuesta;
				pasar = false;
			}
		}
		else {
			ganar = 3;
		}
		terminar = true;
	}

	public boolean action(Event ev, Object ob) {
		if (ev.target instanceof TextField) {
			apuesta.setEditable(false);
			numApuesta = Integer.parseInt(apuesta.getText());
			if (numApuesta > dinero) {
				apuesta.setEditable(true);
			} else {
				haberApuesta = true;
			}
		}
		return true;
	}
}