package application;

import java.io.IOException;

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
import world.University;

public class MapaController {

	@FXML private ChoiceBox<String> salida;
	@FXML private ChoiceBox<String> llegada;
	@FXML private Button calcular;
	@FXML private Button salir;
	
	public static Main main;
	
	public void initialize() {
		añadirInformacion();
		
	}
	
	public void añadirInformacion() {
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
		
		llegada.getItems().add("Edificio A");
		llegada.getItems().add("Edificio B");
		llegada.getItems().add("Edificio C");
		llegada.getItems().add("Edificio D");
		llegada.getItems().add("Edificio E");
		llegada.getItems().add("Edificio F");
		llegada.getItems().add("Edificio G");
		llegada.getItems().add("Edificio I");
		llegada.getItems().add("Edificio J");
		llegada.getItems().add("Edificio K");
		llegada.getItems().add("Edificio L");
		llegada.getItems().add("Edificio M");
		llegada.getItems().add("Edificio N");
		llegada.getItems().add("SAMAN");
		llegada.getItems().add("AUDITORIOS");
		llegada.getItems().add("CENTRAL");
		llegada.getItems().add("BIBLIOTECA");
		llegada.getItems().add("CABALLERIZA");
		llegada.getItems().add("CANCHA 7");
		llegada.getItems().add("CANCHA 11");
		llegada.getItems().add("COLISEO 1");
		llegada.getItems().add("COLISEO 2");
	}

	public void calcular() {
		University icesi = main.getTheIcesiUniversity();
		Stack<Building> pila = icesi.getConections().dijkstraWay(icesi.search(salida.getValue()),(icesi.search(llegada.getValue())));
		while(!pila.isEmpty()) {
			System.out.println(pila.pop().getNameBuilding());
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
