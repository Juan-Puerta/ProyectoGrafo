package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	}
	
	public void addBuilding() {
		
		Building buildingA = new Building("Edificio A");	Building buildingN = new Building("Edificio N");	Building bCol1 = new Building("Coliseo 1");
		Building buildingB = new Building("Edificio B");	Building buildingL = new Building("Edificio L");	Building bCol2 = new Building("Coliseo 2");
		Building buildingC = new Building("Edificio C");	Building buildingK = new Building("Edificio K");
		Building buildingD = new Building("Edificio D");	Building bSaman = new Building("El saman");
		Building buildingE = new Building("Edificio E");	Building bLibrary = new Building("Biblioteca");	
		Building buildingF = new Building("Edificio F");	Building bSoccerSix = new Building("Cancha futbol 6");
		Building buildingG = new Building("Edificio G");	Building bAudi = new Building("Auditorios");
		Building buildingI = new Building("Edificio I");	Building bCentral= new Building("Cafeteria Central");
		Building buildingJ = new Building("Edificio J");	Building bSoccerEleven = new Building("Cancha futbol once");
		Building buildingM = new Building("Edificio M");	Building bCaba = new Building("Caballerisas");
	
		Road roadAM = new Road("A-M", 65);		Road roadCS = new Road("C-S", 120);		Road roadEI = new Road("E-I", 65);
		Road roadAS = new Road("A-S", 78);		Road roadCB = new Road("C-B", 46);		Road roadEf6 = new Road("E-f6", 60);
		Road roadABi = new Road("A-Bi", 25);	Road roadCL = new Road("C-L", 94);		Road roadFG = new Road("F-G", 185);
		Road roadACe = new Road("A-Ce", 33);	Road roadCD = new Road("C-D", 25);		Road roadFCol1 = new Road("F-Col1", 105);
		Road roadAAu = new Road("A-Au", 60);	Road roadDC = new Road("D-C", 25);		Road roadFCol2 = new Road("F-Col2", 156);	
		Road roadBBi = new Road("B-Bi", 27);	Road roadDS = new Road("D-S", 140);		Road roadFN = new Road("F-N", 298);
		Road roadBK = new Road("B-K", 80);		Road roadDI = new Road("D-I", 65);		
		Road roadBI = new Road("B-I", 109);		Road roadDE = new Road("D-E", 45);		Road roadGCab = new Road("G-cab", 60);	
		Road roadBC = new Road("B-C", 46);		Road roadED = new Road("E-D", 45);		Road roadGAu = new Road("G-Au", 140);	
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
			primaryStage.setTitle("UNIVERSITY MAPS");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
