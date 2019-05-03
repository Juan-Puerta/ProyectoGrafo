package application;

import java.io.IOException;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

public class SampleController {
	
	@FXML public Button ir;
	@FXML public Button tour;
	@FXML public Button exit;
	@FXML public Button informacion;
	
	public void initialize() {
		
	}
	
	public void ir(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Mapa.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void tour(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Tour.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exit() {
		Alert alert = new Alert(AlertType.INFORMATION," GRACIAS POR USAR NUESTRA APLICACIÓN ", ButtonType.OK);
		alert.setHeaderText("Hasta Pronto");
		alert.showAndWait();	
		alert.setTitle("UNIVERSITY MAPS");
		System.exit(0);
	}
	
	public void informacion() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("UNIVERSITY MAPS");
		alert.setHeaderText("PROGRAMA CREADO POR: ");
		alert.setContentText("==============="+" Camilo Castillo "+"==============="+"\n"+"==============="+" Fabian Portilla "+"==============="+"\n"+"==============="+" Juan Puertas "+"==============="+"\n"+
		"Estudiantes del curso de Algortimos y Estructuras de Datos de la universidad ICESI");
		alert.showAndWait();	
		
	}
	
}
