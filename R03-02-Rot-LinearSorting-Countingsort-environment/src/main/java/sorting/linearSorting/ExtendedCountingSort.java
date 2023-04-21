package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		boolean valid = validation(array, leftIndex, rightIndex);

		if (valid) {
			int maior = 0;
			int menor = Integer.MAX_VALUE;
			for(int i = leftIndex; i <= rightIndex; i++){
				if(array[i] > maior){
					maior = array[i];
				}

				if(array[i] < menor){
					menor = array[i];
				}
			}
			maior ++;

			if(menor < 0){
				menor = menor * -1;
			}else{
				menor = 0;
			}

			Integer[] arrayContador = new Integer[maior + menor];
			
			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayContador[array[i] + menor] += 1;
			}

			arrayContador[0] += leftIndex;
			for (int i = 1; i < arrayContador.length; i++) {
				arrayContador[i] += arrayContador[i - 1];
			}

			Integer[] arrayOrdenado = new int[array.length];

			for (int i = rightIndex; i >= leftIndex; i--) {

				arrayOrdenado[arrayContador[array[i] + menor] - 1] = array[i];
				arrayContador[array[i] + menor] -= 1;
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayOrdenado[i];
			}

		}

	}

	private boolean validation(Integer[] array, int leftIndex, int rightIndex) {
		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (leftIndex < 0 || rightIndex < 0)
			return false;
		if (leftIndex >= rightIndex)
			return false;
		if (rightIndex >= array.length)
			return false;

		return true;
	}

}
