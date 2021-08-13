package Ejercicio004;

import java.util.Random;

public class Bombo {
	private int bolas[];
	Random aleatorio;
	private int numBolas = 48;

	public Bombo() {
		bolas = new int[numBolas];
		for (int i = 0; i < bolas.length; i++) {
			bolas[i] = i + 1;
		}
		aleatorio = new Random();
	}

	public int[] getBolas() {
		return bolas;
	}

	public void setBolas(int[] bolas) {
		this.bolas = bolas;
	}

	public Random getAleatorio() {
		return aleatorio;
	}

	public void setAleatorio(Random aleatorio) {
		this.aleatorio = aleatorio;
	}

	public int getNumBolas() {
		return numBolas;
	}

	public void setNumBolas(int numBolas) {
		this.numBolas = numBolas;
	}

	public int sacaBola() {
		int numAleatorio = aleatorio.nextInt(numBolas);
		int bolaSacada = bolas[numAleatorio];
		bolas[numAleatorio] = bolas[numBolas - 1];
		numBolas--;
		return bolaSacada;
	}

	public void print(int num) {
		System.out.printf("%d, ", num);
	}
}
