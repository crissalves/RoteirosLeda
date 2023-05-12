package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;
	private int size;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
		this.size = -1;
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public T search(T element) {
		if(isEmpty()){
			throw new RuntimeException("LinkedList is empty");
		}
		T aux = this.head;

		for(int i = 0; i <= this.size ;i++ ){
			if(aux.T.equals(element)){
				return aux.T;
			}else{
				aux = aux.next();
			}
		}
		return aux.T;
	
	}

	@Override
	public void insert(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented!");
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
