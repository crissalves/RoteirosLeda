package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		int meio = array.length / 2;
		if(array[meio] == x){
			return array[meio];
		}else if(array[meio] > x){
			return floor(array, 0, meio, x);
		}else{
			return floor(array, meio, array.length -1, x);
		}
	}

	private Integer floor(Integer[] array, int inicio, int fim, Integer x){
		int floor = -1;
		while(inicio <= fim){
			int meio = (inicio + fim) / 2;
            if (array[meio] == x) {
                return array[meio];
            } else if (array[meio] < x) {
                floor = meio;
                inicio = meio + 1;
            } else{
                fim = meio - 1;
            }
		}

		if(floor == -1){
			return -1;
		}else {
			return array[floor];
		}
	}

	public static void main(String[] args){
		Integer[] array = new Integer[] {4,6,8,10};
		FloorBinarySearchImpl c = new FloorBinarySearchImpl();
		System.out.println(c.floor(array , 5));
	}
}
