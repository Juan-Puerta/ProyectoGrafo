package collections;

public class Vertex<V> {

	private V dateV;
	private String name;
	
	public Vertex(V dataV) {	
		this.dateV = dataV;
	}

	public V getDateV() {
		return dateV;
	}

	public void setDateV(V dateV) {
		this.dateV = dateV;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}