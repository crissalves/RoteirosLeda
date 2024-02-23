package recursao;

public class MetodosRecursivos {

	public int calcularSomaArray(int[] array){
		int result;
		result = array[0] + calcularSomaArray (array, 1);
		return result;
	}

	private int calcularSomaArray(int[] array, int i){
	int limit = array.length-1;
 		if(limit == i){
			return array[i];
		}else{
			return array[i] + calcularSomaArray(array, i+=1);
		}
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
		return countNotNull(array, 0);
	}

	private int countNotNull(Object[] array, int n){
		int count=0;

		if(array[n] != null){
			count+=1;
		}

		if(n != array.length - 1){
			count += countNotNull(array, n+=1);
		}

		return count;
	}

	public long potenciaDe2(int expoente) {
		long result = 1;
		if(expoente == 0){
			//Caso Base;
		} else{
			result = 2 * potenciaDe2(expoente - 1);
		}
		return result;
	}

	public double progressaoAritmetica(double termoInicial, double razao, int n) {
		double result = termoInicial;
		if(n == 1){

		}else{
			result = progressaoAritmetica(termoInicial + razao, razao, n-1);
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
