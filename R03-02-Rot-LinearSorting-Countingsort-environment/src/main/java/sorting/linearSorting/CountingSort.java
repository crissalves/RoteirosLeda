package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala.
 *
 * Procure evitar desperdício de memória: AO INVÉS de alocar o array de contadores
 * com um tamanho arbitrariamente grande (por exemplo, com o maior valor de entrada possível),
 * aloque este array com o tamanho sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Seu algoritmo deve assumir que o array de entrada nao possui numeros negativos,
 * ou seja, possui apenas numeros inteiros positivos e o zero.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(array == null) {
			throw new IllegalArgumentException();
		} else if (leftIndex >= rightIndex || array.length <= 1 || leftIndex > array.length-1 || rightIndex > array.length-1 || leftIndex < 0 || rightIndex < 0) {
			return;
		}else{
			int maiorElemento = 0;
			for(int i = leftIndex; i <= rightIndex; i++){
				if(array[i] > maiorElemento){
					maiorElemento = array[i];
				}
			}

			Integer[] B = new Integer[maiorElemento];

			for(int i = leftIndex; i <= rightIndex; i++){
				B[array[i - 1]] += 1;
			}

			for(int i = 1 ; i < B.length ; i++){
				B[i] += B[i - 1];
			}

			Integer[] C = new Integer[array.length];

			for(int i = array.length; i >= 0; i--){
				C[B[array[i] -1] -1]= array[i];
				B[array[i] -1] -= 1;
			}

			for(int i = 0; i<= array.length; i++){
				array[i] = C[i];
			}
		}
	}

}
