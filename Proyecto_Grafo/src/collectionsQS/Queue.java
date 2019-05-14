package collectionsQS;

import interfaces.IQueue;

public class Queue<T> implements IQueue<T>{
	
	private Node<T> root;
	private Node<T> last;
	private int size;
	
	public Queue() {
		this.root = null;
		this.last = null;
		this.size = 0;
	}
	
	@Override
	public void enqueue(T object) {
		// TODO Auto-generated method stub
		Node<T> theNode = new Node<T>(object);
		if(root == null) {
			root = theNode;
			last = theNode;
		}else {
			last.setNext(theNode);
			last = theNode;
		}
		size++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		Node<T> deleted = root;
		root = root.getNext();
		size--;
		return deleted.getDate();
	}

	@Override
	public T front() {
		// TODO Auto-generated method stub
		return root.getDate();
	}

	@Override
	public T back() {
		// TODO Auto-generated method stub
		return last.getDate();
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
