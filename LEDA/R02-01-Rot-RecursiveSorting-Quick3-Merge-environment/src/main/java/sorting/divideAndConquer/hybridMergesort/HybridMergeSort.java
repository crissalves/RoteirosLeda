package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

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
		hybridMergesort(array,leftIndex,rightIndex);
	}

	private void hybridMergesort(T[]array, int leftIndex, int rightIndex){
		if(rightIndex <= SIZE_LIMIT){
			insertion(array,leftIndex, rightIndex);
		}else{
			int middle = (leftIndex + rightIndex) / 2;
			hybridMergesort(array, leftIndex, middle);
			hybridMergesort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);

		}
	}
	

	private void merge(T[] array, int leftIndex, int middle, int rightIndex) {
		MERGESORT_APPLICATIONS += 1;
		T[] aux = array.clone();

		int left = leftIndex;
		int mid = middle + 1;
		int point = leftIndex;// Variavél que ira guardar as posições dos elementos do aux para o array final.


		while(left <= middle && mid <= rightIndex){
			if(aux[left].compareTo(aux[mid]) < 0){//Comparação para ver qual das 2 partes restantes do Array é maior;
				array[point] = aux[left]; //Adiciona na posição point.
				left ++;

			}else{
				array[point] = aux[mid];
				mid ++;
			}
			point ++; //Aumenta point para as próximas interações.
		}

		while (left <= middle) {//Adiciona os que sobraram a esquerda.
			array[point] = aux[left];
			left++;
			point++;
		}
	
		while (mid <= rightIndex) {//Adiciona os que sobraram a direita.
			array[point] = aux[mid];
			mid++;
			point++;
		}
	}

	private void insertion(T[] array, int leftIndex, int rightIndex) {
		INSERTIONSORT_APPLICATIONS += 1;
		for(int i = leftIndex + 1; i <= rightIndex; i++){
			int j = i - 1;
			while (j >= 0 && array[j].compareTo(array[j + 1]) > 0) {
				Util.swap(array, j, j + 1);
				j = j - 1;
			}
		}
	}
}

