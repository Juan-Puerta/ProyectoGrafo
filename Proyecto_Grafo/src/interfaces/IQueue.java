package interfaces;

public interface IQueue<T> {

	void enqueue(T object);
	T dequeue();
	T front();
	T back();
	int size();
	
}
