package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

	@Override
	public T head() {
		if(isEmpty()){
			throw new RuntimeException("QueuIsEmptyException");
		}else{
			return array[0];
		}
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length;
	}

	private void shiftLeft() {
		for(int i = 1 ; i <= tail ; i++){
			array[i - 1] = array[i];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()){
			reSize();
		}
		if(isEmpty()){
			array[0] = element;
			tail++;
		}else{
			array[tail] = element;
			tail++;
		}
	}

	//Método para dorbrar o tamanho do array caso ele esteja cheio
	private void reSize(){
		T[] newArray = (T[]) new Object[array.length * 2];
        for (int i = 0; i <= array.length; i ++) {
            newArray[i] = array[i];
        }
        array = newArray;
	}


	@Override
	public T dequeue() throws QueueUnderflowException {
		T aux = array[0];
		array[0] = null;
		shiftLeft();
		return aux;
	}

}
