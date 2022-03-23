package Ejercicio007;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solitario extends Applet implements Runnable {

	// Crear de pantalla
	Thread animacion;
	Image imagen;
	Graphics noSeVe;

	Image[][] dibujoCartas;
	Image dibujoReverso;

	// Crear objetos

	List<Carta> cartas;
	List<Carta> reversos;
	List<Hueco> huecos;

	// Crear variable
	int numCarta, numRandom, i, contadorMazo, cartaMazo;
	int cogida, columnaCogida, filaCogida;
	int[] ordenCarta, mazoAbajo, mazoArriba, vista;
	int[][] columnas;
	int[][] columnasReverso;

	boolean posicionada;
	Random random;

	// Incializar todas la variables
	public void init() {
		imagen = this.createImage(1700, 900);
		noSeVe = imagen.getGraphics();

		random = new Random();

		posicionada = false;

		contadorMazo = 0;
		numCarta = 52;
		mazoAbajo = new int[25];
		vista = new int[52];
		ordenCarta = new int[52];

		for (int i = 0; i < ordenCarta.length; i++) {
			ordenCarta[i] = i + 1;
		}

		columnas = new int[7][14];
		columnasReverso = new int[7][7];

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
		reversos = new ArrayList<Carta>();
		huecos = new ArrayList<Hueco>();
		for (int i = 0; i < dibujoCartas.length; i++) {
			for (int j = 0; j < dibujoCartas[i].length; j++) {
				numRandom = elegirNumero() - 1;
				cartas.add(new Carta(200, 100,
						dibujoCartas[Math.abs(numRandom / 13)][Math.abs(numRandom / (Math.abs(numRandom / 13) + 1))],
						Math.abs(numRandom / (Math.abs(numRandom / 13) + 1)) + 1, Math.abs(numRandom / 13) + 1));
			}
		}
		reversos.add(new Carta(200, 100, dibujoReverso, 0, 0));
		i = 0;
		for (int j = 0; j < 7; j++) {
			for (int k = 0; k < 7 - j; k++) {
				cartas.get(i).x = 200 + (200 * j);
				cartas.get(i).y = 300 + (50 * k);
				if (k < 7 - j - 1) {
					reversos.add(new Carta(200 + (200 * j), 300 + (50 * k), dibujoReverso, 0, 0));
					columnasReverso[j][k] = i;
				}
				
				if (k >= 7 - j - 1) {
					columnas[j][k] = i;
				}

				System.out.println(columnas[j][k]);
				i++;
			}
		}


		for (int i = 0; i < 4; i++) {
			huecos.add(new Hueco(200 * i, i + 1));
		}

		for (int j = 0; j < cartas.size(); j++) {
			if (cartas.get(j).x == 200 && cartas.get(j).y == 100) {
				contadorMazo++;
				mazoAbajo[contadorMazo] = j;
			}
		}
		contadorMazo = 0;
		System.out.println(contadorMazo + "dddddddddd");

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
		for (int i = 0; i < huecos.size(); i++) {
			huecos.get(i).dibujar(noSeVe);
		}

		for (int i = 0; i < cartas.size(); i++) {
			cartas.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < reversos.size(); i++) {
			reversos.get(i).dibujar(noSeVe, this);
		}

		for (int i = 0; i < columnas.length; i++) {
			for (int j = 0; j < columnas[i].length; j++) {
				if (columnas[i][j] != 0) {
					cartas.get(columnas[i][j]).dibujar(noSeVe, this);
				}

			}
		}

		g.drawImage(imagen, 0, 0, this);
	}

	// Carga la pagina
	public void update(Graphics g) {
		paint(g);
	}

	public int elegirNumero() {
		int numAleatorio = random.nextInt(numCarta);
		int numElegido = ordenCarta[numAleatorio];
		ordenCarta[numAleatorio] = ordenCarta[numCarta - 1];
		numCarta--;
		for (int i = 0; i < numCarta; i++) {
			System.out.print(ordenCarta[i]);
		}
		System.out.println(numElegido);
		return numElegido;
	}

	@Override
	public boolean mouseDown(Event evt, int x, int y) {

		if (reversos.get(0).contains(x, y)) {
			sacarCarta();
		}
		else if (cartas.get(cartaMazo).contains(x, y)) {
			cartas.get(cartaMazo).posicionX = cartas.get(cartaMazo).x;
			cartas.get(cartaMazo).posicionY = cartas.get(cartaMazo).y;
			cogida = cartaMazo;
		}
		else {
			for (int i = 0; i < columnas.length; i++) {
				for (int j = 0; j < columnas[i].length; j++) {
					if (cartas.get(columnas[i][j]).contains(x, y)) {
						cartas.get(columnas[i][j]).posicionX = cartas.get(columnas[i][j]).x;
						cartas.get(columnas[i][j]).posicionY = cartas.get(columnas[i][j]).y;
						cogida = columnas[i][j];
						columnaCogida = i;
						filaCogida = j + 1;
					}
				}
			}
		}

		return true;
	}

	public void sacarCarta() {
		if (contadorMazo == mazoAbajo.length) {
			for (int i = 0; i < mazoAbajo.length; i++) {
				cartas.get(mazoAbajo[i]).x = 200;
				contadorMazo--;
			}
		}
		else {
			System.out.println(contadorMazo + "aaaaaa" + mazoAbajo[contadorMazo]);
			cartas.get(mazoAbajo[contadorMazo]).x += 200;
			contadorMazo++;
			cartaMazo = mazoAbajo[contadorMazo];
			System.out.println(cartaMazo);
		}
	}

	@Override
	public boolean mouseDrag(Event evt, int x, int y) {
		cartas.get(cogida).x = x - 25;
		cartas.get(cogida).y = y - 50;
		posicionada = false;
		return true;
	}

	@Override
	public boolean mouseUp(Event evt, int x, int y) {
		for (int i = 0; i < columnas.length - 1; i++) {
			for (int j = 0; j < columnas[i].length; j++) {
				if (cartas.get(columnas[i][j]).intersects(cartas.get(cogida)) && columnas[i][j] != cogida
						&& cartas.get(columnas[i][j]).valor == cartas.get(cogida).valor + 1
						&& cartas.get(columnas[i][j]).color != cartas.get(cogida).color) {
					cartas.get(cogida).x = cartas.get(columnas[i][j]).x;
					cartas.get(cogida).y = cartas.get(columnas[i][j]).y + 50;
					int k = 1;
					for (int j2 = filaCogida; j2 < columnas[columnaCogida].length; j2++) {
						if (columnas[columnaCogida][j2] != 0) {
							cartas.get(columnas[columnaCogida][j2]).x = cartas.get(cogida).x;
							cartas.get(columnas[columnaCogida][j2]).y = cartas.get(cogida).y + (50 * k);
							k++;
						}
					}
					columnas[i][j + 1] = cogida;
					posicionada = true;
				}
			}
		}
		if (!posicionada) {
			cartas.get(cogida).x = cartas.get(cogida).posicionX;
			cartas.get(cogida).y = cartas.get(cogida).posicionY;
		}

		return true;
	}
}