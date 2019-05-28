package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collections.Edge;
import collections.OurGraph;
import collectionsQS.Stack;
import world.Building;
import world.Road;
import world.University;

class OurGraphTest {
	
	private OurGraph<Integer,Integer> theIntegerGraph;
	private OurGraph<String,String> theStringGraph; 
	private University theUniversity; 
	
	public void stageOne() {
		
		theIntegerGraph = new OurGraph<Integer, Integer>(6);
		
		theIntegerGraph.insert(1, 2, 3, 10);
		theIntegerGraph.insert(2, 3, 3, 20);
		theIntegerGraph.insert(2, 4, 2, 30);
		theIntegerGraph.insert(4, 3, 6, 40);
		theIntegerGraph.insert(3, 5, 4, 50);
		
	}
	
	public void stageTwo() {
		
		theStringGraph = new OurGraph<String, String>(6);
		
		theStringGraph.insert("A", "B", 3, "AB");
		theStringGraph.insert("B", "B", 3, "BC");
		theStringGraph.insert("B", "D", 2, "BD");
		theStringGraph.insert("D", "C", 6, "DC");
		theStringGraph.insert("C", "E", 4, "CE");
		
	}
	
	public void stageThree() {
		
		Building theBuildingA = new Building("A");
		Building theBuildingB = new Building("B");
		Road theRoadAB = new Road("AB", 3);
		Building theBuildingC = new Building("C");
		Road theRoadBC = new Road("BC", 3);
		Building theBuildingD = new Building("D");
		Road theRoadBD = new Road("BD", 2);
		Building theBuildingE = new Building("E");
		Road theRoadDC = new Road("DC", 6);
		Road theRoadCE = new Road("CE", 4);
		
		theUniversity = new University("Icesi", 6);
		theUniversity.getConections().insert(theBuildingA, theBuildingB, theRoadAB.getCost(), theRoadAB);
		theUniversity.getConections().insert(theBuildingB, theBuildingC, theRoadBC.getCost(), theRoadBC);
		theUniversity.getConections().insert(theBuildingB, theBuildingD, theRoadBD.getCost(), theRoadBD);
		theUniversity.getConections().insert(theBuildingD, theBuildingC, theRoadDC.getCost(), theRoadDC);
		theUniversity.getConections().insert(theBuildingC, theBuildingE, theRoadCE.getCost(), theRoadCE);
		
	}

	
//Insert
	
	@Test
	void testInsertStageOne() {
		stageOne();
		theIntegerGraph.insert(4, 6, 2, 60);
		assertEquals(6, (int)theIntegerGraph.dijkstraWay(6, 6).pop());
		
	}
	
	@Test
	void testInsertStageTwo() {
		stageTwo();
		theStringGraph.insert("D", "F", 2, "DF");
		assertEquals("F", (String)theStringGraph.dijkstraWay("F", "F").pop());
		
	}
	
	
	@Test
	void testInsertStageThree() {
		stageThree();
		Building theBuildingF = new Building("F");
		Road theRoadDF = new Road("DF", 2);
		theUniversity.getConections().insert(theUniversity.search("D"), theBuildingF, theRoadDF.getCost(), theRoadDF);
		assertEquals("F", theUniversity.search("F").getNameBuilding());
		
	}
	
//Search
	
	@Test
	void testSearchStageOne() {
		stageOne();
		assertEquals(1, (int)theIntegerGraph.dijkstraWay(1, 1).pop());
		assertEquals(3, (int)theIntegerGraph.dijkstraWay(3, 3).pop());
		assertEquals(5, (int)theIntegerGraph.dijkstraWay(5, 5).pop());
	}
	
	@Test
	void testSearchStageTwo() {
		stageTwo();
		assertEquals("B", (String)theStringGraph.dijkstraWay("B", "B").pop());
		assertEquals("C", (String)theStringGraph.dijkstraWay("C", "C").pop());
		assertEquals("D", (String)theStringGraph.dijkstraWay("D", "D").pop());
		
	}
	
	
	@Test
	void testSearchStageThree() {
		stageThree();
		assertEquals("A", theUniversity.search("A").getNameBuilding());
		assertEquals("E", theUniversity.search("E").getNameBuilding());
		
	}
	
	
//Dijsktra
	
	@Test
	void testDijkstraStageThree() {
		stageThree();
		Stack<Building> theDikjstra = theUniversity.getConections().dijkstraWay(theUniversity.search("A"), theUniversity.search("C"));
		assertEquals("A", theDikjstra.pop().getNameBuilding());
		assertEquals("B", theDikjstra.pop().getNameBuilding());
		assertEquals("C", theDikjstra.pop().getNameBuilding());
	
	}
	
	
//Prim
	@Test
	void testPrimStageThree() {
		stageThree();
		Building theBuildingF = new Building("F");
		Road theRoadDF = new Road("DF", 2);
		theUniversity.getConections().insert(theUniversity.search("D"), theBuildingF, theRoadDF.getCost(), theRoadDF);

		Stack<Edge<Building, Road>> thePrim = theUniversity.getConections().prim(theUniversity.search("A"));
		
		assertEquals(4, thePrim.pop().getWeight());
		assertEquals(3, thePrim.pop().getWeight());
		assertEquals(2, thePrim.pop().getWeight());
		assertEquals(2, thePrim.pop().getWeight());
		assertEquals(3, thePrim.pop().getWeight());
	
	}
	
	
//BFS
	
	@Test
	void testBFS_StageOne() {
		stageOne();
	
		ArrayList<Integer> theIntegerBfs = theIntegerGraph.bfs(1);
		assertEquals(1, (int)theIntegerBfs.get(0));
		assertEquals(2, (int)theIntegerBfs.get(1));
		assertEquals(3, (int)theIntegerBfs.get(2));
		assertEquals(4, (int)theIntegerBfs.get(3));
		assertEquals(5, (int)theIntegerBfs.get(4));
	}
	
	
	@Test
	void testBFS_StageTwo() {
		stageTwo();
	
		ArrayList<String> theStringBfs = theStringGraph.bfs("A");
		assertEquals("A", theStringBfs.get(0));
		assertEquals("B", theStringBfs.get(1));
		assertEquals("D", theStringBfs.get(2));
		assertEquals("C", theStringBfs.get(3));
		assertEquals("E", theStringBfs.get(4));
	}
	
	@Test
	void testBFS_StageThre() {
		stageThree();

		ArrayList<Building> theStringBfs = theUniversity.getConections().bfs(theUniversity.search("A"));
		assertEquals("A", theStringBfs.get(0).getNameBuilding());
		assertEquals("B", theStringBfs.get(1).getNameBuilding());
		assertEquals("C", theStringBfs.get(2).getNameBuilding());
		assertEquals("D", theStringBfs.get(3).getNameBuilding());
		assertEquals("E", theStringBfs.get(4).getNameBuilding());
	}
	

	
//DFS
	
	@Test
	void testDFS_StageOne() {
		stageOne();
	
		ArrayList<Integer> theIntegerDfs = theIntegerGraph.dfs(1);
		assertEquals(1, (int)theIntegerDfs.get(0));
		assertEquals(2, (int)theIntegerDfs.get(1));
		assertEquals(4, (int)theIntegerDfs.get(2));
		assertEquals(3, (int)theIntegerDfs.get(3));
		assertEquals(5, (int)theIntegerDfs.get(4));
	}
	
	
	@Test
	void testDFS_StageTwo() {
		stageTwo();
	
		ArrayList<String> theStringDfs = theStringGraph.dfs("A");
		assertEquals("A", theStringDfs.get(0));
		assertEquals("B", theStringDfs.get(1));
		assertEquals("D", theStringDfs.get(2));
		assertEquals("C", theStringDfs.get(3));
		assertEquals("E", theStringDfs.get(4));
	}
	
	@Test
	void testDFS_StageThree() {
		stageThree();

		ArrayList<Building> theStringDfs = theUniversity.getConections().dfs(theUniversity.search("A"));
		assertEquals("A", theStringDfs.get(0).getNameBuilding());
		assertEquals("B", theStringDfs.get(1).getNameBuilding());
		assertEquals("D", theStringDfs.get(2).getNameBuilding());
		assertEquals("C", theStringDfs.get(3).getNameBuilding());
		assertEquals("E", theStringDfs.get(4).getNameBuilding());
		
	}
	
	//Floyd-Warshall
	@Test
	void testFloydStageThree() {
		stageThree();
		int[] array1 = {0,3,6,5,10,-1}; 
		int[] array2 = {3,0,3,2,7,-1}; 
		int[] array3 = {6,3,0,5,4,-1}; 
		int[] array4 = {5,2,5,0,9,-1}; 
		int[] array5 = {10,7,4,9,0,-1}; 
		int[] array6 = {-1,-1,-1,-1,-1,0}; 
		
		Edge<Building, Road>[][] matrix = theUniversity.getConections().floydWarshall(theUniversity.getConections().getAdjMatrix());
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j].getWeight() == 10000) {
					matrix[i][j].setWeight(-1);
				}
				if(i == 0) {
					assertEquals(array1[j], matrix[i][j].getWeight());
				}else if(i == 1) {
					assertEquals(array2[j], matrix[i][j].getWeight());
				}else if(i == 2) {
					assertEquals(array3[j], matrix[i][j].getWeight());
				}else if(i == 3) {
					assertEquals(array4[j], matrix[i][j].getWeight());
				}else if(i == 4) {
					assertEquals(array5[j], matrix[i][j].getWeight());
				}else {
					assertEquals(array6[j], matrix[i][j].getWeight());
				}
			}
		}
		
	}
	
	//Kruskal
	@Test
	void testKruskal() {
		stageThree();
		
		ArrayList<Edge<Building, Road>> theSomething = theUniversity.getConections().kruskal();
		
		for(int i = 0; i < theSomething.size(); i++) {
			if(i == 0) {
				assertEquals("B", theSomething.get(i).getVertexOne().getNameBuilding());
				assertEquals("D", theSomething.get(i).getVertexTwo().getNameBuilding());
			}else if(i == 1) {
				assertEquals("A", theSomething.get(i).getVertexOne().getNameBuilding());
				assertEquals("B", theSomething.get(i).getVertexTwo().getNameBuilding());
			}else if(i == 2) {
				assertEquals("C", theSomething.get(i).getVertexOne().getNameBuilding());
				assertEquals("B", theSomething.get(i).getVertexTwo().getNameBuilding());
			}else {
				assertEquals("C", theSomething.get(i).getVertexOne().getNameBuilding());
				assertEquals("E", theSomething.get(i).getVertexTwo().getNameBuilding());
			}
			
		}
		
	}
	
	

}
