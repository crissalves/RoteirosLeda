package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	protected DoubleLinkedListNode<T> head;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) head;
	}

	@Override
	public void insertFirst(T element) {
		if(element != null){
			DoubleLinkedListNode<T> newFirst = new DoubleLinkedListNode<>();
			newFirst.setData(element);
			newFirst.setNext(this.getHead());
			newFirst.setPrevious(new DoubleLinkedListNode<>());			
			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(newFirst);
			if(this.getHead().isNIL()){
				this.setLast(newFirst);
			}
			this.setHead(newFirst);
			
		}
		
	}

	@Override
	public void removeFirst() {
		DoubleLinkedListNode<T> nodeNIL = new DoubleLinkedListNode<>();
		if(!this.getHead().isNIL()){
			this.setHead(this.getHead().getNext());
			if(this.getHead().isNIL()){
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}else{
				((DoubleLinkedListNode<T>) this.getHead()).setPrevious(nodeNIL);
			}
		}
		
	}

	@Override
	public void removeLast() {
		DoubleLinkedListNode<T> nodeNIL = new DoubleLinkedListNode<>();
		if(!this.getLast().isNIL()){
			this.setLast(this.getLast().getPrevious());
			if(this.getLast().isNIL()){
				this.setHead(this.getLast());
			}else{
				this.getLast().setNext(nodeNIL);
			}
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
