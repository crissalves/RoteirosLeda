package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(!isFull()){
			array[--tail] = element;
			elements += 1;
		}else{
			throw new QueueOverflowException();
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(!isEmpty()){
			T aux = array[++head];
			array[head] = null;
			return aux;
		}else{
			throw new QueueUnderflowException();
		}
	}

	@Override
	public T head() {
		if(!isEmpty()){
			return array[head];
		}else{
			return null;
		}
	}
	@Override
	public boolean isEmpty() {
		if(tail == -1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if(tail == elements -1){
			return true;
		}else{
			return false;
		}
	}

}
