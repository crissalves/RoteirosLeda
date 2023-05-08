package adt.queue;

import adt.stack.Stack;
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
		if (stack1.isEmpty()){ 
        	throw new RuntimeException("EmptyStackException");
        } 
  
        int x = stack1.peek(); 
        stack1.pop(); 
        return x; 
	}

	private T peek(){
		if (stack2.empty())
            while (!stack1.empty())
                stack2.push(stack1.pop());
        return stack2.peek();
	}

	@Override
	public T head() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}
