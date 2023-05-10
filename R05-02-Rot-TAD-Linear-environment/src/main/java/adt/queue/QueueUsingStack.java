package adt.queue;

import java.util.Queue;
import java.util.Stack;

import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		this.stack1 = new StackImpl<T>(size);
		this.stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}else{
			while (!stack1.isEmpty()){ 
            	stack2.push(stack1.pop()); 
        	} 

        	stack1.push(element); 
  
        	while (!stack2.isEmpty()){ 
            	stack1.push(stack2.pop()); 
        	}
		} 
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){ 
        	throw new RuntimeException("EmptyStackException");
        } else{
        	if (stack2.isEmpty()) {
            	while (!stack1.isEmpty()) {
                	stack2.push(stack1.pop());
            	}
        	}
        	return stack2.pop();
    	}
	}

	@Override
	public T head() {
		if (isEmpty()) {
            throw new IllegalStateException("EmptyStackException.");
        }else{
        	if (stack2.isEmpty()) {
            	while (!stack1.isEmpty()) {
            		stack2.push(stack1.pop());
            	}
        	}
			return stack2.pop();
		}
	}

	@Override
	public boolean isEmpty() {
		return this.stack1.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.stack1.isFull();
	}
}