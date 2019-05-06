package collectionsPQ;

import interfaces.IPriorityQueue;

public class PriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T>{

	private MinHeap<T> heap;

	public PriorityQueue(int maxsize) {
		heap = new MinHeap<>(maxsize);
	}

	public T extractMin() {
		if (heap.getSize() <= 0)
			return null;
		else {
			T minVal = heap.get(1);
			heap.set(1, heap.get(heap.getSize()));  
			heap.remove(1);
			return minVal;
		}
	}

	public void insert(T element) {
		heap.insert(element);       
	}

	public boolean isEmpty() {
		return heap.getSize() == 0;
	}

	public T minimum() {
		if (heap.getSize() <= 0)
			return null;
		else
			return heap.get(1);
	}	

}
