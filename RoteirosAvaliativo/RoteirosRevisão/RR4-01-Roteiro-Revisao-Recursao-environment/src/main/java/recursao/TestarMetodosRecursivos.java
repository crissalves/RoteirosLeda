package recursao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestarMetodosRecursivos {
	private MetodosRecursivos metodosRecursivos;
		
	@Before
	public void setUp(){
		metodosRecursivos = new MetodosRecursivos();
	}

	@Test
	public void calcularSomaArrayTest() {
		int[] array = { -123, 0, 123 };
		int resultado = metodosRecursivos.calcularSomaArray(array);
		assertEquals(0, resultado);
	}

	@Test
	public void calcularFatorialTest(){
		Long resultado = metodosRecursivos.calcularFatorial(5);
		assertEquals(120, resultado.longValue());
	}

	@Test
	public void calcularFibonacciTest(){
		int resultado = metodosRecursivos.calcularFibonacci(23);
		assertEquals(28657, resultado);
	}

	@Test
	public void countNotNullTest(){
		Object[] array = {23, null, "Olá", "Bom dia Adalberto", null, "amén senhor", 232, 2.32, null, null};
		int resultado = metodosRecursivos.countNotNull(array);
		assertEquals(6, resultado);
	}

	@Test
	public void potenciaDe2Test(){
		Long resultado = metodosRecursivos.potenciaDe2(24);
		assertEquals(576, resultado.longValue());
	}

	@Test 
	public void progressaoAritmeticaTest(){
		double resultado = metodosRecursivos.progressaoAritmetica(1, 2, 10);
		assertEquals(19, resultado, 0.001);
	}

	@Test
	public void progressaoGeometricaTest(){
		double resultado = metodosRecursivos.progressaoGeometrica(1, 2, 10);
		assertEquals(512, resultado,0.001);
	}
}


	