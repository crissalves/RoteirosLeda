package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;
		hybridMergesort(array, leftIndex, rightIndex);
	}


	private void hybridMergesort(T[] array, int leftIndex, int rightIndex){
		int contador = 0;
		if(array == null){
			throw IllegalArgumentException;
		}else if(array.length <= 1 && leftIndex < rightIndex){
			return;
		}else if(contador > SIZE_LIMIT){
			int meio = (leftIndex + rightIndex) / 2;
			hybridMergesort(array, leftIndex, meio);
			hybridMergesort(array, middle+1,leftIndex);
			merge(array,leftIndex,meio,rightIndex);
		}else{
			inserTionSort(array, leftIndex, leftIndex);
		}
	}


	private void merge(T[] array, int leftIndex, int meio, int rightIndex){
		MERGESORT_APPLICATIONS ++;
		T[] aux = new Array[array.length];
		for(int i = leftIndex; i<= rightIndex; i++){
			aux[i] = array[i];
		}

		int i = leftIndex;
		int j = meio + 1;
		int k = leftIndex;

		While(i <= meio && j <= rightIndex);{
			if(aux[i].compareTo(aux[m]) > 0){
				array[k] = aux[i];
				i++;
			}else{
				array[k] = aux[m];
				m++;
			}
			k++;
		}

		while(i <= meio){
			array[k] = aux[i];
			i++;
			k++;
		}

		while(j <= meio){
			array[k] = aux[j];
			j++;
			k++;
		}
	}

	
	private void inserTionSort(T[] array, int leftIndex, int rightIndex){
		INSERTIONSORT_APPLICATIONS ++;
		if(leftIndex < rightIndex) {
			for(int i = leftIndex; i < rightIndex; i++){
				int j = i;
				while(j > 0 && array[j].compareTo(array[j-1]) < 0){
					Util.swap(array, j, j-1);
					j -= 1;
				}
			}
		}
	}
}
