package collections;

import java.io.Serializable;

public class Edge<V,A> implements Comparable<Edge<V,A>>, Serializable{

	private static final long serialVersionUID = 2386745115157664653L;
	
	private A dateA;
	private int weight;
	private V vertexOne;
	private V vertexTwo;
	
	public Edge(A dateA, int weight, V vertexOne, V vertexTwo) {
		this.dateA = dateA;
		this.weight = weight;
		this.vertexOne = vertexOne;
		this.vertexTwo = vertexTwo;
	}

	public A getDateA() {
		return dateA;
	}

	public void setDateA(A dateA) {
		this.dateA = dateA;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public V getVertexOne() {
		return vertexOne;
	}

	public void setVertexOne(V vertexOne) {
		this.vertexOne = vertexOne;
	}

	public V getVertexTwo() {
		return vertexTwo;
	}

	public void setVertexTwo(V vertexTwo) {
		this.vertexTwo = vertexTwo;
	}

	@Override
	public int compareTo(Edge<V,A> o) {
		// TODO Auto-generated method stub
		  if (weight > o.getWeight()) {
	            return 1;
	        } else if (weight < o.getWeight()) {
	            return -1;
	        } else {
	            return 0;
	        }
	}
	

}
