package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result = 0;
		result = calcularSomaArray (array, 0);
		return result;
	}

	private int calcularSomaArray(int[] array, int i){
		int result = 0;
		if(array.length == i){

		}else{
			result += calcularSomaArray(array, i++);
		}
		return result;
	}

	public long calcularFatorial(int n) {
		long result = 1;
		if(n == 0){
			return 1;
		}else{
			result = n * calcularFatorial(n -1);
		}
		System.out.println(n + "! = " + result);
		return result;
	}

	public int calcularFibonacci(int n) {
		int result = 1;

		if (n == 1 || n == 2) {
			return result;
		} else {
			result = calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}
		return result;
	}

	public int countNotNull(Object[] array) {
		int result = 0;
		result = countNotNull(array, 0);
		return result;
	}

	private int countNotNull(Object[] array, int i){
		int result = 0;
		if(array[i] != null){
			result++;
		}
		if (i != array.length - 1) { 
			result = result + countNotNull(array, i);
		}
		return result;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente != 0){
			result = 2 * potenciaDe2(expoente -1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = 0;
		if(n != 1){
			result = progressaoAritmetica(termoInicial, razao, n - 1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = 1;
		if(n != 1){
			result = progressaoGeometrica(termoInicial, razao, n -1 ) * razao;
		}
		return result;
	}
	
	
}
