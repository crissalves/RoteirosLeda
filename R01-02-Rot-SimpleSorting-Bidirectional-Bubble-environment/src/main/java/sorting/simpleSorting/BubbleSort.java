package sorting.simpleSorting;

import util.Util;
import sorting.AbstractSorting;

/**
 * The bubble sort algorithm iterates over the array multiple times, pushing big
 * elements to the right by swapping adjacent elements, until the array is
 * sorted.
 */
public class BubbleSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		do{
			boolean swapped = false;
			int indice = leftIndex;
			for(int i = 1; i < rightIndex; i++){
				if(compareTo(array[indice]) > compareTo(array[i])){
					Util.swap(array, indice, i);
					swapped = True;
					indice ++;
				}else{
					indice ++;
				}
			}
			indice = leftIndex;
		}while (swapped);
	}
}
