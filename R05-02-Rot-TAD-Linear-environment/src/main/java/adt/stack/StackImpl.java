package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;
	private int size;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
		this.size = size;
	}

	@Override
	public T top() {
		return this.array[top];
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return this.top == (size - 1);
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (this.isFull()){
			throw new RuntimeException("FullStackException");
		}else{
			this.top += 1;
			this.array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			throw new RuntimeException("EmptyStackException");
		}else{
			T value_top = this.array[top];
			top -= 1;
			return value_top;
		}
	}

}
