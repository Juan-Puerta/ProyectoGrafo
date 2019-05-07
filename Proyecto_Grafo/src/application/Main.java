package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import world.University;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private University theIcesiUniversity;
	
	public Main() {
		// TODO Auto-generated constructor stub
		theIcesiUniversity = new University("Universidad Icesi", 22);
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
