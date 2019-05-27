package application;

import java.io.IOException;

import collections.Edge;
import collectionsQS.Stack;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import world.Building;
import world.Road;
import world.University;

public class TourController {

	@FXML private ChoiceBox<String> salida;
	@FXML private Button calcular;
	@FXML private Button salir;
	
	public static Main main;
	
	public void initialize() {
		salida.getItems().add("Edificio A");
		salida.getItems().add("Edificio B");
		salida.getItems().add("Edificio C");
		salida.getItems().add("Edificio D");
		salida.getItems().add("Edificio E");
		salida.getItems().add("Edificio F");
		salida.getItems().add("Edificio G");
		salida.getItems().add("Edificio I");
		salida.getItems().add("Edificio J");
		salida.getItems().add("Edificio K");
		salida.getItems().add("Edificio L");
		salida.getItems().add("Edificio M");
		salida.getItems().add("Edificio N");
		salida.getItems().add("Edificio SAMÁN");
		salida.getItems().add("Edificio AUDITORIOS");
		salida.getItems().add("Edificio CENTRAL");
		salida.getItems().add("Edificio BIBLIOTECA");
		salida.getItems().add("Edificio CABALLERIZA");
		salida.getItems().add("Edificio CANCHA 7");
		salida.getItems().add("Edificio CANCHA 11");
		salida.getItems().add("Edificio COLISEO 1");
		salida.getItems().add("Edificio COLISEO 2");
	}
	
	public void calcular() {
		University icesi = main.getTheIcesiUniversity();
		Stack<Edge<Building, Road>> ruta = icesi.getConections().prim(icesi.search(salida.getValue()));
		while(!ruta.isEmpty()) {
			Edge<Building, Road> aux = ruta.pop();
			System.out.println(aux.getVertexOne().getNameBuilding()+" - "+aux.getWeight()+" - "+aux.getVertexTwo().getNameBuilding());
		}
	}
	
	public void salir(Event event) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			Scene scene = new Scene(root);
			Stage windows = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			windows.setScene(scene);
			windows.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
