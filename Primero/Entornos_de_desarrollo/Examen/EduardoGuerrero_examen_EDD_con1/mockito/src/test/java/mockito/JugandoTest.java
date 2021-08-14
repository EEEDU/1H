package mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.awt.Graphics;
import java.awt.Image;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import BomberMan.Bomba;
import BomberMan.Enemigos;
import BomberMan.Explosion;
import BomberMan.Jugador;
import BomberMan.Jugando;
import BomberMan.Mapa;

@ExtendWith(MockitoExtension.class)
class JugandoTest {

	private Jugando spyJugando;

	@Spy
	private Graphics g;

	@Spy
	private Image imagen;

	@Mock
	private Bomba bomba;

	@Mock
	private Enemigos enemigos;

	@Mock
	private Explosion explosion;

	@Mock
	private Jugador jugador;

	@Mock
	private Mapa mapa;

	@Test
	void paint() {

		spyJugando.setNoseve(g);
		spyJugando.setImagen(imagen);
		bomba.dibujarBomba();
		mapa.dibujarMapa();
		enemigos.dibujarEnemigos();
		explosion.dibujarExplosion();

		spyJugando.paint(g);

		verify(g, times(1)).drawImage(imagen, 0, 0, spyJugando);
	}

	@Test
	void init() {
		spyJugando.setNoseve(g);
		spyJugando.setImagen(imagen);

		spyJugando.setLongitudImagenX(100);
		spyJugando.setLongitudImagenY(100);

		verify(spyJugando, times(1)).getGraphics();
	}
}
