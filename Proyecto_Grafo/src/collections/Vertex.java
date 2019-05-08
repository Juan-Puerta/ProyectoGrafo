package collections;

import java.io.Serializable;

public class Vertex<V> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3298533209027321768L;
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