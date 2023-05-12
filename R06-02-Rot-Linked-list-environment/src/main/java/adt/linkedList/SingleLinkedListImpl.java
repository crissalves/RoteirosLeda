package adt.linkedList;

import java.lang.reflect.Array;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;;
	private int size;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
		this.size = 0;
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
			if(aux.equals(element)){
				return aux;
			}else{
				aux = aux.next;
			}
		}
		return aux;
	
	}

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.last = element;
			this.head = element;
		}
		T aux = this.head;
		while(aux != null){
			aux = aux.next;
		}
		element.prev = aux.prev;
		element.next = aux.next;
		this.size++;

	}

	@Override
	public void remove(T element) {
		if(isEmpty()){
			throw new RuntimeException("LinkedList is empty");
		}
		T aux = this.head;
		while(aux != element){
			aux = aux.next;
		}
		element.prev.next = element.next;
		element.next.prev = element.prev;
		element.next = null;
		element.prev = null;
		this.size--;

	}

	@Override
	public T[] toArray() {
		T[] array = new Array(size);
		T aux = this.head;
		for(int i = 0 ; i <= size;i++){
			if(aux == null){
				aux = aux.next;
			}else{
				array[i] = aux;
				aux = aux.next;
			}
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
