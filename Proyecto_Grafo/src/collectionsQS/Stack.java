package collectionsQS;

import interfaces.IStack;

public class Stack<T> implements IStack<T>{

	private Node<T> top;
	private int size;
	
	public Stack() {
		this.top = null;
		this.size = 0;
	}
	
	@Override
	public void push(T object) {
		// TODO Auto-generated method stub
		Node<T> theNode = new Node<T>(object);
		if(top == null) {
			top = theNode;
		}else {
			theNode.setNext(top);
			top = theNode;
		}
		size++;
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		Node<T> deleted = top;
		top = top.getNext();
		size--;
		return deleted.getDate();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return top.getDate();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}
	
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}

}
