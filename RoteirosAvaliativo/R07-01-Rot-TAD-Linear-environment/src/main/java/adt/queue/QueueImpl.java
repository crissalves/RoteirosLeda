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
		if(!isEmpty()){
			return array[0];
		}else{
			return null;
		}
		
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return array.length - 1 == tail;
	
	}

	private void shiftLeft() {
		for(int i = 0; i < tail; i++){
			array[i] = array[i+1];
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()){
			array[++tail] = element; 
		}else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()){
			T aux = array[0];
			shiftLeft();
			this.tail --;
			return aux;
		} else{
			throw new QueueUnderflowException();
		}
	}

}
