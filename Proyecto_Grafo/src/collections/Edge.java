package collections;

public class Edge<A> implements Comparable<Edge<A>>{

	private A dateA;
	private int weight;
	
	public Edge(A dateA, int weight) {
		this.dateA = dateA;
		this.weight = weight;
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

	@Override
	public int compareTo(Edge<A> o) {
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
