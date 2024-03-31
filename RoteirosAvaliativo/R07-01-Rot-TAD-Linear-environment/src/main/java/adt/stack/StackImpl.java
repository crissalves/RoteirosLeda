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
		T topo = null;
		if(!isEmpty()){
			return  topo = this.array[top];
		}

		return topo;
	}

	@Override
	public boolean isEmpty() {
		return this.top == -1;
	}

	@Override
	public boolean isFull() {
		return top == array.length -1;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(!isFull()){
			if(element != null){
				this.array[++this.top] = element;
			}			
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
