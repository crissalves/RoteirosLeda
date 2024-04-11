package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	@Override
	public boolean isEmpty() {
		if(this.getData() == null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int size() {
		if(isEmpty()){
			return 0;
		}else{
			return 1 + this.next.size();
		}
	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			return null;
		}else{
			if(this.data == element){
				return this.data;
			}else{
				return this.search(next.getData());
			}
		}
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		}else{
			this.insert(this.next.getData());
		}
	}

	@Override
	public void remove(T element) {
		if(isEmpty()){

		}else{
			if(this.data == element){
				this.setData(this.getNext().getData());
				this.setNext(this.getNext().getNext());
			}else{
				this.remove(getNext().getData());
			}
		}
	}

	@Override
	public T[] toArray() {
		T[] array = (T[]) new Comparable[this.size()];
		this.toArray(array, 0);
		return array;
	}

	private void toArray(T[] array, int i) {
		if (!this.isEmpty()) {
			array[i] = this.data;
			this.next.toArray(array, i + 1);
		}
	}
	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
