package recursao;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MetodosRecursivosTest {
	@Test
	public void calcularSomaArray() {
		MetodosRecursivos m = new MetodosRecursivos();
		int[] array = { -123, 0, 123 };
		int expected = 123;
		int actual = m.calcularSomaArray(array);

		assertEquals(expected, actual);
	}
}
