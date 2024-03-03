package sorting.divideAndConquer;

import sorting.AbstractSorting;

/**
 * Merge sort is based on the divide-and-conquer paradigm. The algorithm
 * consists of recursively dividing the unsorted list in the middle, sorting
 * each sublist, and then merging them into one single sorted list. Notice that
 * if the list has length == 1, it is already sorted.
 */
public class MergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex >= rightIndex){
			return;
		}else{
			int middle = (leftIndex + rightIndex) / 2;
			sort(array, leftIndex, middle);
			sort(array, middle + 1, rightIndex);
			merge(array, leftIndex, middle, rightIndex);
		}
	}

	private void merge(T[] array, int leftIndex, int middle, int rightIndex){
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
}
