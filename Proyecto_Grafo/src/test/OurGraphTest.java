package test;

import static org.junit.jupiter.api.Assertions.*;

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
	void testDrikjstraStageThree() {
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
		System.out.println("caca");
		Stack<Edge<Building, Road>> thePrim = theUniversity.getConections().prim(theUniversity.search("A"));
		
		assertEquals(4, thePrim.pop().getWeight());
		assertEquals(3, thePrim.pop().getWeight());
		assertEquals(2, thePrim.pop().getWeight());
		assertEquals(2, thePrim.pop().getWeight());
		assertEquals(3, thePrim.pop().getWeight());
	
	}
	
	
	
//
	

}
