package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveBubbleSort<T extends Comparable<T>> extends
		AbstractSorting<T> {

	/**
	 * Implementação recursiva do bubble sort. Você deve implementar apenas esse
	 * método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		recursiveSort(array, leftIndex, rightIndex, false);
	}
	
	private void recursiveSort(T[] array, int leftIndex, int rightIndex, boolean swapped) {
		if (leftIndex >= rightIndex || !swapped) {
			return;
		}
	
		boolean Swapped = false;
		int indice = leftIndex;
		for (int i = leftIndex + 1; i <= rightIndex; i++) {
			if (array[indice].compareTo(array[i]) > 0) {
				Util.swap(array, indice, i);
				Swapped = true;
				indice = i;
			}
		}
	
		recursiveSort(array, leftIndex, rightIndex - 1, Swapped);
	}
}


