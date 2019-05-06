package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import collectionsQS.*;
import collectionsPQ.*;

public class OurGraph<V,A>{
	
	public final static int SIZE_PQ = 100;
	
	private Edge<A> adjMatrix[][];
	private int index;
	private Map<V, Integer> representationV;
	private ArrayList<V> theArrayV;
	
	public OurGraph(int nV){
		this.adjMatrix = new Edge[nV][nV];
		index = 0;
		representationV = new HashMap<V, Integer>();
		theArrayV = new ArrayList<V>();
	}

	
	public void insert(V from, V to, int weight, A date) {
		Vertex<V> vertexOne = new Vertex<V>(from);
		Vertex<V> vertexTwo = new Vertex<V>(to);
		
		if(!theArrayV.contains(from)) {
			theArrayV.add(from);
		}
		if(!theArrayV.contains(to)) {
			theArrayV.add(to);
		}
		
		addVertex(vertexOne);
		addVertex(vertexTwo);
		
		int i = representationV.get(vertexOne.getDateV());
		int j = representationV.get(vertexTwo.getDateV());
		
		adjMatrix[i][j] = new Edge<A>(date, weight);
		adjMatrix[j][i] = new Edge<A>(date, weight);
	}
	
	private void addVertex(Vertex<V> theVertex) {
		if(!representationV.containsKey(theVertex.getDateV())) {
			representationV.put(theVertex.getDateV(), index);
			index++;
		}else {
			System.out.println("El vertice ya existe");
		}
	}
	
	public Stack<V> dijkstraWay(V from, V to) {
		
		int[][] theArray = dijkstra(from);
		Stack<V> theWay = new Stack<V>();
		
		theWay.push(to);
		V aux = null;
		
		while(aux != from) {
			int post = representationV.get(theWay.peek());
			int father = theArray[1][post];
			theWay.push(theArrayV.get(father));
			aux = theWay.peek();
		}
		return theWay;
	}
	
	public int[][] dijkstra(V initialVertex) {
		
		Vertex<V> newVertex = new Vertex<V>(initialVertex);
		
		int[][] distances = new int[2][adjMatrix.length];
		PriorityQueue<Node> myQueue = new PriorityQueue<Node>(SIZE_PQ);
		Set<Integer> visited = new HashSet<Integer>();
		
		for(int i = 0; i < adjMatrix.length; i++) {
			distances[0][i] = Integer.MAX_VALUE;
			distances[1][i] = -1;
		}
		
		myQueue.insert(new Node(representationV.get(newVertex.getDateV()), 0));
		distances[0][representationV.get(newVertex.getDateV())] = 0;
		distances[1][representationV.get(newVertex.getDateV())] = representationV.get(newVertex.getDateV());
		
		while(!myQueue.isEmpty()) {
			int evaluationNode = myQueue.extractMin().node;
			visited.add(evaluationNode);
			
			int edgeDistance = -1;
			int newDistance = -1;
			
			int algo = representationV.get(newVertex.getDateV());
			
			for(int i = 0; i < adjMatrix.length; i++) {
				if(adjMatrix[evaluationNode][i] != null) {
					if(!visited.contains(i)) {
						if(adjMatrix[evaluationNode][i].getWeight() != Integer.MAX_VALUE) {
							edgeDistance = adjMatrix[evaluationNode][i].getWeight();
							newDistance = distances[0][evaluationNode] + edgeDistance;
							if(newDistance < distances[0][i]) {
								distances[0][i] = newDistance;
								distances[1][i] = algo;
							}
							myQueue.insert(new Node(i,distances[0][i]));
						}
					}
				}
				algo = evaluationNode;
			}
		}
		return distances;
	}
	
	public Edge<A>[][] getAdjMatrix() {
		return adjMatrix;
	}

	public void setAdjMatrix(Edge<A>[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}


	public Map<V, Integer> getRepresentationV() {
		return representationV;
	}


	public void setRepresentationV(Map<V, Integer> representationV) {
		this.representationV = representationV;
	}

	 public ArrayList<V> getTheArrayV() {
		return theArrayV;
	}


	public void setTheArrayV(ArrayList<V> theArrayV) {
		this.theArrayV = theArrayV;
	}



	public class Node implements Comparable<Node>{
		int node;
		int cost;
		
		public Node(int node, int cost) {
			this.node = node;
	        this.cost = cost;
		}
		
//		public Node(int cost) {
//			this.cost = cost;
//		}

		@Override
		public int compareTo(Node node) {
			// TODO Auto-generated method stub
			if(cost < node.cost) {
				return -1;
			}else if(cost > node.cost) {
				return 1;
			}else {
				return 0;
			}
		}
	 }

	
	 
	 
}
