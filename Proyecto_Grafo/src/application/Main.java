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
	
		Road roadAM = new Road("A-M", 65);		Road roadAM = new Road("A-M", 65);		Road roadAM = new Road("A-M", 65);
		Road roadAS = new Road("A-S", 78);		Road roadAM = new Road("A-M", 65);		Road roadAM = new Road("A-M", 65);
		Road roadABi = new Road("A-Bi", 25);	Road roadAM = new Road("A-M", 65);
		Road roadACe = new Road("A-Ce", 33);		Road roadAM = new Road("A-M", 65);
		Road roadAAu = new Road("A-Au", 60);		Road roadAM = new Road("A-M", 65);
		Road roadBBi = new Road("B-Bi", 27);		Road roadAM = new Road("A-M", 65);
		Road roadBK = new Road("B-K", 80);		Road roadAM = new Road("A-M", 65);
		Road roadBM = new Road("B-M", 65);		Road roadAM = new Road("A-M", 65);
		Road roadBM = new Road("B-M", 65);		Road roadAM = new Road("A-M", 65);
		Road roadBM = new Road("B-M", 65);		Road roadAM = new Road("A-M", 65);
		
		
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
