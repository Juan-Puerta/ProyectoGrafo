package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import collections.*;
import collectionsQS.Stack;
import javafx.application.Application;
import javafx.stage.Stage;
import world.*;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	
	private University theIcesiUniversity;
	
	public Main() {
		// TODO Auto-generated constructor stub
		
		theIcesiUniversity = new University("Universidad Icesi", 22);
		
//		addBuilding();
		
		if(theIcesiUniversity.getConections().getAdjMatrix()[0][1] == null) {
			try {
				deserialize();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(int i = 0; i < theIcesiUniversity.getConections().getAdjMatrix().length; i++) {
			for(int j = 0; j < theIcesiUniversity.getConections().getAdjMatrix()[0].length; j++) {
				if(theIcesiUniversity.getConections().getAdjMatrix()[i][j] == null) {
					System.out.print(0+"   ");
				}else {
					if(theIcesiUniversity.getConections().getAdjMatrix()[i][j].getWeight() >= 100) {
						System.out.print(theIcesiUniversity.getConections().getAdjMatrix()[i][j].getWeight()+" ");
					}else {
						System.out.print(theIcesiUniversity.getConections().getAdjMatrix()[i][j].getWeight()+"  ");
					}
				}
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		Stack<Building> laCosa = theIcesiUniversity.getConections().dijkstraWay(theIcesiUniversity.search("Edificio A"), theIcesiUniversity.search("Edificio F"));
		while(!laCosa.isEmpty()) {
			System.out.println(laCosa.pop().getNameBuilding());
		}
		System.out.println("");
		System.out.println("");
		Stack<Edge<Building, Road>> laFufa = theIcesiUniversity.getConections().prim(theIcesiUniversity.search("El saman"));
		while(!laFufa.isEmpty()) {
			Edge<Building, Road> aux = laFufa.pop();
			System.out.println(aux.getVertexOne().getNameBuilding()+" - "+aux.getWeight()+" - "+aux.getVertexTwo().getNameBuilding());
		}
		System.out.println("");
		System.out.println("");
		Edge<Building, Road>[][] infinito = theIcesiUniversity.getConections().floydWarshall(theIcesiUniversity.getConections().getAdjMatrix());
		for(int i = 0; i < theIcesiUniversity.getConections().getAdjMatrix().length; i++) {
			for(int j = 0; j < theIcesiUniversity.getConections().getAdjMatrix()[0].length; j++) {
				System.out.print(infinito[i][j].getWeight()+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		int[][] kaka = theIcesiUniversity.getConections().dijkstra(theIcesiUniversity.search("Edificio F"));
		for(int i = 0; i < kaka[0].length; i++) {
			System.out.print(kaka[0][i]+" ");
		}
		
	}
	
	public void addBuilding() {
		
		Building buildingA = new Building("Edificio A");	Building buildingN = new Building("Edificio N");	Building bCol1 = new Building("COLISEO 1");
		Building buildingB = new Building("Edificio B");	Building buildingL = new Building("Edificio L");	Building bCol2 = new Building("COLISEO 2");
		Building buildingC = new Building("Edificio C");	Building buildingK = new Building("Edificio K");
		Building buildingD = new Building("Edificio D");	Building bSaman = new Building("SAMAN");
		Building buildingE = new Building("Edificio E");	Building bLibrary = new Building("BIBLIOTECA");	
		Building buildingF = new Building("Edificio F");	Building bSoccerSix = new Building("CANCHA 7");
		Building buildingG = new Building("Edificio G");	Building bAudi = new Building("AUDITORIOS");
		Building buildingI = new Building("Edificio I");	Building bCentral= new Building("CENTRAL");
		Building buildingJ = new Building("Edificio J");	Building bSoccerEleven = new Building("CANCHA 11");
		Building buildingM = new Building("Edificio M");	Building bCaba = new Building("CABALLERIZA");
	
		Road roadAM = new Road("A-M", 65);		Road roadCS = new Road("C-S", 120);		Road roadEI = new Road("E-I", 65);
		Road roadAS = new Road("A-S", 78);		Road roadEf6 = new Road("E-f6", 60);
		Road roadABi = new Road("A-Bi", 25);	Road roadCL = new Road("C-L", 94);		Road roadFG = new Road("F-G", 185);
		Road roadACe = new Road("A-Ce", 33);	Road roadCD = new Road("C-D", 25);		Road roadFCol1 = new Road("F-Col1", 105);
		Road roadAAu = new Road("A-Au", 60);	Road roadFCol2 = new Road("F-Col2", 156);	
		Road roadBBi = new Road("B-Bi", 27);	Road roadDS = new Road("D-S", 140);		Road roadFN = new Road("F-N", 298);
		Road roadBK = new Road("B-K", 80);		Road roadDI = new Road("D-I", 65);		
		Road roadBI = new Road("B-I", 109);		Road roadDE = new Road("D-E", 45);		Road roadGCab = new Road("G-cab", 60);	
		Road roadBC = new Road("B-C", 46);		Road roadGAu = new Road("G-Au", 140);	
		Road roadBS = new Road("B-S", 65);		Road roadES = new Road("E-S", 125);		Road roadICen = new Road("I-Cen", 155);
		
		Road roadIf11 = new Road("I-f11", 25); 	
		Road roadIJ = new Road("E-f6", 45);
		Road roadJL = new Road("J-L", 36);
		Road roadJCol1 = new Road("J-Col1", 115);
		Road roadJCol2 = new Road("J-Col2", 78);
		Road roadKL= new Road("K-L", 40);
		Road roadKCen = new Road("K-Cen", 55);
		Road roadKCab = new Road("K-Cab", 67);
		Road roadLCol1 = new Road("L-Col1", 80);
		Road roadLCol2 = new Road("L-Col2", 100);
		Road roadMAu = new Road("M-Au", 56);
		Road roadMCen = new Road("M-Cen", 70);
		Road roadMS = new Road("M-S", 83);
		Road roadNCol2 = new Road("N-Col2", 75);
		
		Road roadSaBi = new Road("Sa-Bi", 37);
		Road roadSaF6 = new Road("Sa-Futbol-6", 201);
		Road roadAuCe = new Road("Auditorio-Central", 26);
		Road roadCeBi = new Road("Central-Biblio", 36);
		Road roadF6F11 = new Road("Futbol 6 - Futbol 11", 8);
		Road f11Col2 = new Road("Futbol 11 - Coliseo 2", 48);
		Road col2Col1 = new Road("Coliseo 1-Coliseo 2", 80);
		Road col1Caba = new Road("Coliseo 1-Caballerisas", 95);
		
		theIcesiUniversity.getConections().insert(buildingA, buildingM, roadAM.getCost(), roadAM);
		theIcesiUniversity.getConections().insert(buildingA, bSaman, roadAS.getCost(), roadAS);
		theIcesiUniversity.getConections().insert(buildingA, bLibrary, roadABi.getCost(), roadABi);
		theIcesiUniversity.getConections().insert(buildingA, bAudi, roadAAu.getCost(), roadAAu);
		theIcesiUniversity.getConections().insert(buildingA, bCentral, roadACe.getCost(), roadACe);
		
		theIcesiUniversity.getConections().insert(buildingB, bSaman, roadBS.getCost(), roadBS);
		theIcesiUniversity.getConections().insert(buildingB, bLibrary, roadBBi.getCost(), roadBBi);
		theIcesiUniversity.getConections().insert(buildingB, buildingK, roadBK.getCost(), roadBK);
		theIcesiUniversity.getConections().insert(buildingB, buildingI, roadBI.getCost(), roadBI);
		theIcesiUniversity.getConections().insert(buildingB, buildingC, roadBC.getCost(), roadBC);
		
		theIcesiUniversity.getConections().insert(buildingC, bSaman, roadCS.getCost(), roadCS);
		theIcesiUniversity.getConections().insert(buildingC, buildingL, roadCL.getCost(), roadCL);
		theIcesiUniversity.getConections().insert(buildingC, buildingD, roadCD.getCost(), roadCD);
		
		theIcesiUniversity.getConections().insert(buildingD, bSaman, roadDS.getCost(), roadDS);
		theIcesiUniversity.getConections().insert(buildingD, buildingI, roadDI.getCost(), roadDI);
		theIcesiUniversity.getConections().insert(buildingD, buildingE, roadDE.getCost(), roadDE);
		
		theIcesiUniversity.getConections().insert(buildingE, bSaman, roadES.getCost(), roadES);
		theIcesiUniversity.getConections().insert(buildingE, bSoccerSix, roadEf6.getCost(), roadEf6);
		theIcesiUniversity.getConections().insert(buildingE, bSaman, roadEI.getCost(), roadEf6);
		
		theIcesiUniversity.getConections().insert(buildingF, buildingG, roadFG.getCost(), roadFG);
		theIcesiUniversity.getConections().insert(buildingF, buildingN, roadFN.getCost(), roadFN);
		theIcesiUniversity.getConections().insert(buildingF, bCol1, roadFCol1.getCost(), roadFCol1);
		theIcesiUniversity.getConections().insert(buildingF, bCol2, roadFCol2.getCost(), roadFCol2);
		
		theIcesiUniversity.getConections().insert(buildingG, bAudi, roadGAu.getCost(), roadGAu);
		theIcesiUniversity.getConections().insert(buildingG, bCaba, roadGCab.getCost(), roadGCab);
		
		theIcesiUniversity.getConections().insert(buildingI, bCentral, roadICen.getCost(), roadICen);
		theIcesiUniversity.getConections().insert(buildingI, buildingJ, roadIJ.getCost(), roadIJ);
		theIcesiUniversity.getConections().insert(buildingI, bSoccerEleven, roadIf11.getCost(), roadIf11);
		
		theIcesiUniversity.getConections().insert(buildingJ, buildingL, roadJL.getCost(), roadJL);
		theIcesiUniversity.getConections().insert(buildingJ, bCol1, roadJCol1.getCost(), roadJCol1);
		theIcesiUniversity.getConections().insert(buildingJ, bCol2, roadJCol2.getCost(), roadJCol2);
		
		theIcesiUniversity.getConections().insert(buildingK, bCentral, roadKCen.getCost(), roadKCen);
		theIcesiUniversity.getConections().insert(buildingK, buildingL, roadKL.getCost(), roadKL);
		theIcesiUniversity.getConections().insert(buildingK, bCaba, roadKCab.getCost(), roadKCab);
		
		theIcesiUniversity.getConections().insert(buildingL, bCol1, roadLCol1.getCost(), roadLCol1);
		theIcesiUniversity.getConections().insert(buildingL, bCol2, roadLCol2.getCost(), roadLCol2);
		
		theIcesiUniversity.getConections().insert(buildingM, bAudi, roadMAu.getCost(), roadMAu);
		theIcesiUniversity.getConections().insert(buildingM, bCentral, roadMCen.getCost(), roadMCen);
		theIcesiUniversity.getConections().insert(buildingM, bSaman, roadMS.getCost(), roadMS);
		
		theIcesiUniversity.getConections().insert(buildingN, bCol2, roadNCol2.getCost(), roadNCol2);
		
		theIcesiUniversity.getConections().insert(bAudi, bCentral, roadAuCe.getCost(), roadAuCe);
		theIcesiUniversity.getConections().insert(bLibrary, bCentral, roadCeBi.getCost(), roadCeBi);
		theIcesiUniversity.getConections().insert(bLibrary, bSaman, roadSaBi.getCost(), roadSaBi);
		theIcesiUniversity.getConections().insert(bSaman, bSoccerSix, roadSaF6.getCost(), roadSaF6);
		theIcesiUniversity.getConections().insert(bSoccerSix, bSoccerEleven, roadF6F11.getCost(), roadF6F11);
		theIcesiUniversity.getConections().insert(bSoccerEleven, bCol2, f11Col2.getCost(), f11Col2);
		theIcesiUniversity.getConections().insert(bCol2, bCol1, col2Col1.getCost(), col2Col1);
		theIcesiUniversity.getConections().insert(bCol1, bCaba, col1Caba.getCost(), col1Caba);
		
		try {
			serializable();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void serializable() throws FileNotFoundException, IOException {
		ObjectOutputStream serializeUniversity = new ObjectOutputStream(new FileOutputStream("Data/dataGraph"));
		serializeUniversity.writeObject(theIcesiUniversity);
		serializeUniversity.close();
	}
	
	public void deserialize() throws Exception {
		ObjectInputStream unserializeUniversity = new ObjectInputStream(new FileInputStream("Data/dataGraph"));
		theIcesiUniversity = (University) unserializeUniversity.readObject();
		unserializeUniversity.close();
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("ICESI MAPS");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public University getTheIcesiUniversity() {
		return theIcesiUniversity;
	}

	public void setTheIcesiUniversity(University theIcesiUniversity) {
		this.theIcesiUniversity = theIcesiUniversity;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
