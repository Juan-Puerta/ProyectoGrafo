package interfaces;

public interface IPriorityQueue<T> {

	T extractMin();
	void insert(T element);
	boolean isEmpty();
	T minimum();
	
}
