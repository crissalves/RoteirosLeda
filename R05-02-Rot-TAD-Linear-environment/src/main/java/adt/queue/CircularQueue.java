package adt.queue;

import javax.lang.model.element.Element;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;
	private int capacity;

	public CircularQueue(int size) {
		array = (T[]) new Object[size];
		head = -1;
		tail = -1;
		elements = 0;
		capicity = size;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(this.isFull()){
			throw new RuntimeException("QueueIsFullException");
		}else{
			if(head == -1){
				head = 0;
			}
			tail = (tail + 1) % capacity;
			array[tail] = element;
			this.elements ++;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(this.isEmpty()){
			throw new RuntimeException("QueuIsEmptyException");
			return -1;
		}else{
			element = array[head];
			if(head == tail){
				head = -1;
				tail = -1;
			}else{
				head = (head + 1) % capacity;
			}
			this.elements--;
			return element;
		}
	}

	@Override
	public T head() {
		if (this.isEmpty()){
			throw new RuntimeException("QueuIsEmptyException");
		}else{
			return this.array[head];
		}
	}

	@Override
	public boolean isEmpty() {
		return this.head == -1;
	}

	@Override
	public boolean isFull() {
		return this.elements == array.length;
	} 

}
