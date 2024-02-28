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

	public void merge(T[] array, int leftIndex, int middle, int rightIndex){
		T[] aux = array.clone();

		int left = leftIndex;
		int mid = middle + 1;
		int point = leftIndex;

		while(left <= middle && mid <= rightIndex){
			if(aux[left].compareTo(aux[mid]) < 0){
				array[point] = aux[left];
				left ++;

			}else{
				array[point] = aux[mid];
				mid ++;
			}
			point ++; 
		}

		while (left <= middle) {
			array[point] = aux[left];
			left++;
			point++;
		}
	
		while (mid <= rightIndex) {
			array[point] = aux[mid];
			mid++;
			point++;
		}
	}
}
