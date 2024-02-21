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
			return result;
		}else{
			result += array[i];
			calcularSomaArray(array, i++);	
		}
		return result;
	}

	public long calcularFatorial(int n) {
		long result = 1;
		if (n == 0){
			return result;
		} else {
			return result = (n * calcularFatorial(n- 1));
		}
	}

	public int calcularFibonacci(int n) {
		int result = 1;
		if(n == 1 || n == 2){
			//Caso base;
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

	private int countNotNull(Object[] array, int n){
		int count = 0;

		if(array[n] != null){
			count+=1;
			countNotNull(array,n++);
		}

		if(n != array.length - 1){
			count = count + countNotNull(array, n++);
		}

		return count;
	}

	public long potenciaDe2(int expoente) {
		int result = 1;
		if(expoente == 0){
			//Caso Base;
		} else{
			result += 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if(n == 1){

		}else{
			result = progressaoAritmetica(termoInicial, razao, n-1) + razao;
		}
		return result;
	}

	public double progressaoGeometrica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if(n == 1){

		} else {
			result = progressaoGeometrica(termoInicial, razao, n-1) * razao;
		}	
		return result;
	}
	
	
}
