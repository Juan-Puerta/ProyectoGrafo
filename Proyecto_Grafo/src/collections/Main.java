package collections;

import collectionsQS.Stack;

public class Main {

	public static void main(String[] args) {
		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";
		String e = "e";
		
		String e1 = "e1";
		String e2 = "e2";
		String e3 = "e3";
		String e4 = "e4";
		String e5 = "e5";
		String e6 = "e6";
		
		OurGraph<String, String> elGrafo = new OurGraph<String, String>(5);
		elGrafo.insert(a, b, 2, e1);
		elGrafo.insert(a, c, 3, e2);
		elGrafo.insert(d, e, 4, e6);
		elGrafo.insert(a, e, 9, e3);
		elGrafo.insert(e, b, 3, e4);
		elGrafo.insert(c, e, 1, e5);
		
		
		
		for(int i = 0; i < elGrafo.getAdjMatrix().length; i++) {
			System.out.println("");
			for(int j = 0; j < elGrafo.getAdjMatrix().length; j++) {
				if(elGrafo.getAdjMatrix()[i][j] != null) {
					System.out.print(elGrafo.getAdjMatrix()[i][j].getWeight()+" ");
				}else {
					System.out.print(0+" ");
				}
			}
		}

		System.out.println("");
		System.out.println("");
//		int[][] hola = elGrafo.dijkstra(a);
//		for(int i = 0; i < hola[0].length; i++) {
//			System.out.print(hola[0][i]+ " ");
//		}
//		System.out.println("");
//		for(int i = 0; i < hola[0].length; i++) {
//			System.out.print(hola[1][i]+ " ");
//		}
		
//		for(int i = 0; i < elGrafo.getTheArrayV().size(); i++) {
//			System.out.print(elGrafo.getTheArrayV().get(2)+" ");
//		}
		System.out.println("");
		System.out.println("");
		Stack<String> camino = elGrafo.dijkstraWay(b, c);
		while(!camino.isEmpty()) {
			System.out.println(camino.pop());
		}
		
	}	}


