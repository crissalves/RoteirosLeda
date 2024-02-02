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
		if(leftIndex < rightIndex) {
			boolean swapped;
			do{
				swapped = false;
				for(int i = leftIndex; i < rightIndex; i++){
					if(array[i].compareTo(array[i+1]) > 0){
						Util.swap(array, i+1, i);
						swapped = true;
					}
				}
			}while (swapped);
		}
	}
}
