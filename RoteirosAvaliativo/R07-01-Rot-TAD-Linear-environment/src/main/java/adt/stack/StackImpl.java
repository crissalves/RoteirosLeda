package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		array = (T[]) new Object[size];
		top = -1;
	}

	@Override
	public T top() {
		if(!isEmpty()){
			return this.array[top];
		}else{
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if(top == -1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean isFull() {
		if(top == array.length -1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()){
			array[++top] = element;
		}else{
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if(!isEmpty()){
			T aux = array[top];
			array[top] = null;
			top--;
			return aux;
		}else{
			throw new StackUnderflowException();
		}
	}

}
