package sorting.linearSorting;

import java.util.Arrays;

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
		if(leftIndex < rightIndex){

			int maior = 0;
			int menor = 1000;
			for(int i = leftIndex; i <= rightIndex; i++){
				if(array[i] > maior){
					maior = array[i];
				}

				if(array[i] < menor){
					menor = array[i];
				}
			}

			int range = maior - menor + 1;

			//Para mapear eu tenho que subtrair o valor pelo menor já emcontrado
			Integer[] arrayContador = new Integer[range];
			Arrays.fill(arrayContador,0);
			Integer[] arrayOrdenado = new Integer[array.length];


			//Armazena a frequência na posição do Array contador.
			for(int i = leftIndex; i <= rightIndex; i++){
				arrayContador[array[i] - menor]++;
			}

			//System.out.println(Arrays.toString(arrayContador));

			//Faz a frquencia relativa dos elementos do Array, sendo o próximo a soma dos anteriores + ele mesmo para atingir o valor máximo.
			for(int i = 1; i < arrayContador.length; i++){
				arrayContador[i] += arrayContador[i-1];
			}

			//System.out.println(Arrays.toString(arrayContador));

			//Se tornou errado esta estourando algum array.
			for(int i = rightIndex; i >= leftIndex; i--){
				arrayOrdenado[arrayContador[array[i] - menor] -1]= array[i];
				arrayContador[array[i] - menor] -= 1;
			}

			for(int i = leftIndex; i <= rightIndex; i++){
				array[i]= arrayOrdenado[i];
			}
			
		}
	}
		public static void main(String[] args) {
		ExtendedCountingSort c = new ExtendedCountingSort();
		Integer[] array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
		c.sort(array,0,9);
		System.out.println(Arrays.toString(array));
	
	}

}
