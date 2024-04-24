package adt.bst;

import org.w3c.dom.Node;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(T node){
		if(node == null){
			return -1;
		} else{
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
		}
	}

	@Override
	public BSTNode<T> search(T element) {
		Node aux = this.root;

		while ( aux != null){
			if(aux.getData() == element) return aux;
			if(element < aux.getData()) aux = aux.left;
			if(element > aux.getData()) aux = aux.right;
		}

		return null;
	}
	

	@Override
	public void insert(T element) {
		if(isEmpty()){
			this.root = new Node(element);
		}else{
			Node aux = this.root;

			while(aux != null){
				if(element < aux.value){
					if(aux.left = null){
						Node newNode = new Node(element);
						aux.left = newNode;
						newNode.parent = aux;
					}

					aux = aux.left;

				}else{
					if(aux.right == null){
						Node newNode = new Node(element);
						aux.right = newNode;
						newNode.parent = aux;
					}
						
					aux = aux.right;
				}
			}
		}
	}

	@Override
	public BSTNode<T> maximum() {
		Node aux = this.root;

		while(aux.getRight().getData() != null){
			aux = aux.getRight();
		}

		return aux;
	}

	@Override
	public BSTNode<T> minimum() {
		Node aux = this.root;

		while(aux.getLeft().getData() != null){
			aux = aux.getLeft();
		}

		return aux;
	}

	@Override
	public BSTNode<T> sucessor(T element) {

		if(element.getRight().getData() != null){
			return sucessor(element.getRight());
		}else{
			Node aux = element.getParent();

			while(aux != null && aux.getData() < node.getData()){
				aux = aux.getParentNode();
			}
		}

		return aux;

	}

	@Override
	public BSTNode<T> predecessor(T element) {
		if(element.getleft().getData() != null){
			return predecessor(element.getleft());
		}else{
			Node aux = element.getParent();

			while(aux != null && aux.getData() < node.getData()){
				aux = aux.getParentNode();
			}
		}

		return aux;

	}

	@Override
	public void remove(T element) {	
		BSTNode node = search(element);

		
	}

	@Override
	public T[] preOrder() {
		T[] array = new T[size()];
		preOrder(this.root,array,0);
		return array;
	}

	private T[] preOrder(BSTNode node, T[] array, int i){
		if(!node.isNil()){
			array[i] = node.getData(this.root);
			preOrder(node.getLeft(),array,i++);
			preOrder(node.getRight(),array,i++);
		}
		return array;
	}

	

	@Override
	public T[] order() {
		T[] array = new T[size(this.root)];
		order(this.root, array, 0);
		return array;
		
	}

	private T[] order(BSTNode node,T[] array, int i){
		if(!node.isNil()){
			order(node.getLeft(),array,i++);
			array[i] = node.getData();
			order(node.getRight(), array, i++);
		}
	}

	@Override
	public T[] postOrder() {
		T[] array = new T[size(this.root)];
		postOrder(this.root,array,0);
		return array;
	}

	private T[] postOrder(BSTNode node, T[] array, int i){
		if(!node.isNil()){
			postOrder(node.getLeft(),array, i++);
			postOrder(node.getRight(),array,i++);
			array[i] = node.getData();
		}

	
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
