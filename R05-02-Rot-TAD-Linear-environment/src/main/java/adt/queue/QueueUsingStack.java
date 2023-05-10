package adt.queue;

import java.util.Queue;
import java.util.Stack;

import adt.stack.StackImpl;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new RuntimeException("EmptyStackException");
		}
		while (!stack1.isEmpty()){ 
        	stack2.push(stack1.pop()); 
    	} 
        stack1.push(element); 
  
        while (!stack2.isEmpty()){ 
        	stack1.push(stack2.pop()); 
    	}		
	} 

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()){ 
        	throw new RuntimeException("EmptyStackException");
        } 
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    	return stack2.pop();
	}



	@Override
	public T head() {
		if (isEmpty()) {
            throw new IllegalStateException("EmptyStackException.");
        }

        if (stack2.isEmpty()) {
        	while (!stack1.isEmpty()) {
        		stack2.push(stack1.pop());
        	}
		}
			return stack2.pop();
		
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

}
