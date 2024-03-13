package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		mergeSort(array, 0, array.length -1);
		return floor(array, 0, array.length -1, x, -1);
	}
	private void mergeSort(Integer[] array, int leftIndex, int righIndex){
		
	}

	private Integer floor(Integer[] array, int inicio, int fim, Integer x, int floor){
	if (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (array[meio] <= x) {
                floor = meio;
                return floor(array, meio + 1, fim, x, floor);
            } else {
                return floor(array, inicio, meio - 1, x, floor);
            }
        }
        return array[floor];
	}

	public static void main(String[] args){
		Integer[] array = new Integer[] {4,6,8,10};
		FloorBinarySearchImpl c = new FloorBinarySearchImpl();
		System.out.println(c.floor(array , 5));
	}
}
