package sorting.linearSorting;

import java.util.Arrays;

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
		if(leftIndex < rightIndex){
			int maior = 0;
			for(int i = leftIndex; i <= rightIndex; i++){
				if(array[i] > maior){
					maior = array[i];
				}
			}

			Integer[] arrayContador = new Integer[maior + 1];
			Arrays.fill(arrayContador,0);
			Integer[] arrayOrdenado = new Integer[array.length];

			for(int i = leftIndex; i <= rightIndex; i++){
				arrayContador[array[i]]++;
			}

			for(int i =1; i< arrayContador.length; i++){
				arrayContador[i] += arrayContador[i-1];
			}

			for(int i = rightIndex; i >= leftIndex; i--){
				arrayOrdenado[arrayContador[array[i]] -1]= array[i];
				arrayContador[array[i]] -= 1;
			}

			for(int i = leftIndex; i <= rightIndex; i++){
				array[i]= arrayOrdenado[i];
			}

		}
	}

}
