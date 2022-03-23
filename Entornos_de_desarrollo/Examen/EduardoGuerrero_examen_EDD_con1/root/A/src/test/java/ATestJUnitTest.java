import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ATestJUnitTest {

	ATestJUnit juni = new ATestJUnit();

	@Test
	void testLog2n() {
		Integer actual = juni.log2n(8);
		assertEquals(3, actual);
		Integer actual2 = juni.log2n(16);
		assertEquals(4, actual2);
	}

	@Test
	public void testLog2nNull() {
		assertThrows(NullPointerException.class, () -> {
			juni.log2n(null);
		});
	}

	@Test
	void testIsPalindromo() {
		boolean actual = juni.isPalindromo("adda");
		assertTrue(actual);
		boolean actual2 = juni.isPalindromo("aasasda");
		assertFalse(actual2);
	}

	@Test
	public void testIsPalindromoNull() {
		assertThrows(NullPointerException.class, () -> {
			juni.isPalindromo(null);
		});
	}

	@Test
	void testObtener_mcd() {
		Integer actual = juni.obtener_mcd(12, 6);
		assertEquals(6, actual);
		Integer actual2 = juni.obtener_mcd(20, 10);
		assertEquals(10, actual2);
	}

	@Test
	public void testObtener_mcdNull() {
		assertThrows(NullPointerException.class, () -> {
			juni.obtener_mcd(null, null);
		});
	}

}
