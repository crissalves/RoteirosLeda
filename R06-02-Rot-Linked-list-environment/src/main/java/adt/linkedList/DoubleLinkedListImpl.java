package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	protected DoubleLinkedListNode<T> head;

	@Override
	public void insertFirst(T element) {

		if(isEmpty()){
			this.last = element;
			this.head = element;
		}else{
			element.next = this.head;
			this.head.prev = element;
			this.head = element;
		}
	}

	@Override
	public void removeFirst() {
		if (isEmpty()){
			throw new RuntimeException("Lista vazia.");
		}else{
			this.head = this.head.next;
			this.head.prev = null;

		}
	}

	@Override
	public void removeLast() {
		this.last = this.tal.prev;
		this.last.next = null;
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
