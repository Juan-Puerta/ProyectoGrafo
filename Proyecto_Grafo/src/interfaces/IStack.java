package interfaces;

public interface IStack<T> {

	void push(T object);
	T pop();
	T peek();
	int size();
	
}
