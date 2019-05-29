package application;

import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.experimental.theories.FromDataPoints;

import com.sun.javafx.tk.Toolkit;

import collectionsQS.Stack;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import world.Building;
import world.University;

public class MapaController {

	@FXML private ChoiceBox<String> salida;
	@FXML private ChoiceBox<String> llegada;
	@FXML private Button calcular;
	@FXML private Button salir;
	@FXML private Line a_m;
	@FXML private Line a_saman;
	@FXML private Line a_auditorios;
	@FXML private Line a_central;
	@FXML private Line a_biblioteca;
	@FXML private Line b_saman;
	@FXML private Line b_biblioteca;
	@FXML private Line b_k;
	@FXML private Line b_c;
	@FXML private Line b_i1;
	@FXML private Line b_i2;
	@FXML private Line c_saman;
	@FXML private Line c_d;
	@FXML private Line c_l;
	@FXML private Line d_saman;
	@FXML private Line d_e;
	@FXML private Line d_i;
	@FXML private Line e_saman;
	@FXML private Line e_i;
	@FXML private Line e_cancha7;
	@FXML private Line f_g;
	@FXML private Line f_coliseo1;
	@FXML private Line f_coliseo2;
	@FXML private Line f_n;
	@FXML private Line g_auditorios;
	@FXML private Line g_caballeriza;
	@FXML private Line i_central;
	@FXML private Line i_j;
	@FXML private Line i_cancha11;
	@FXML private Line j_coliseo2;
	@FXML private Line j_l;
	@FXML private Line j_coliseo1;
	@FXML private Line k_l;
	@FXML private Line k_central;
	@FXML private Line k_caballeriza;
	@FXML private Line l_coliseo1;
	@FXML private Line l_coliseo2;
	@FXML private Line m_saman;
	@FXML private Line m_central;
	@FXML private Line m_auditorios;
	@FXML private Line n_coliseo2;
	@FXML private Line saman_cancha7;
	@FXML private Line biblioteca_central;
	@FXML private Line auditorios_central;
	@FXML private Line coliseo1_coliseo2;
	@FXML private Line coliseo1_caballeriza;
	@FXML private Line coliseo2_cancha11;
	@FXML private Line cancha7_cancha11;
	
	
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
		salida.getItems().add("SAMAN");
		salida.getItems().add("AUDITORIOS");
		salida.getItems().add("CENTRAL");
		salida.getItems().add("BIBLIOTECA");
		salida.getItems().add("CABALLERIZA");
		salida.getItems().add("CANCHA 7");
		salida.getItems().add("CANCHA 11");
		salida.getItems().add("COLISEO 1");
		salida.getItems().add("COLISEO 2");
		
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
		Stack<Building> pila2 = icesi.getConections().dijkstraWay(icesi.search(salida.getValue()),(icesi.search(llegada.getValue())));
		
		
		
		String subtitulo = "Usted se encuentra en: "+salida.getValue()+" y desea dirigirse a: "+llegada.getValue();
		String mensaje = "";
		int i = 1;
		while(!pila.isEmpty()) {
//			validar(pila2);
			mensaje += (i)+". Diríjase a: "+pila.pop().getNameBuilding()+"\n";
			i++;
//			validar(pila2);
		}
		Alert alerta = new Alert(AlertType.INFORMATION);
		alerta.setTitle("INFORMACIÓN");
		alerta.setHeaderText(subtitulo);
		alerta.setContentText(mensaje);
		alerta.showAndWait();
	}
	
	public void validar(Stack<Building> edificios) {
		Building laCosa = edificios.pop();
		if(edificios.peek() != null) {
			if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio A")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio M")) {
					a_m.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					a_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Auditorios")) {
					a_auditorios.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					a_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Biblioteca")) {
					a_biblioteca.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio B")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					b_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Biblioteca")) {
					b_biblioteca.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio K")) {
					b_k.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio C")) {
					b_c.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio I")) {
					b_i1.setVisible(true);
					b_i2.setVisible(true);	
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio C")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("saman")) {
					c_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio D")) {
					c_d.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio L")) {
					c_l.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio B")) {
					b_c.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio D")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					d_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio E")) {
					d_e.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio I")) {
					d_i.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio C")) {
					c_d.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio E")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					e_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio I")) {
					e_i.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("CANCHA 7")) {
					e_cancha7.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Cancha de Futbol 7")) {
					d_e.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio F")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio G")) {
					f_g.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 1")) {
					f_coliseo1.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					f_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio N")) {
					f_n.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio G")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Auditorios")) {
					g_auditorios.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Caballeriza")) {
					g_caballeriza.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio I")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					i_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio J")) {
					i_j.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("CANCHA 11")) {
					i_cancha11.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio D")) {
					d_i.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio E")) {
					e_i.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio B")) {
					b_i1.setVisible(true);
					b_i2.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio J")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio L")) {
					j_l.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 1")) {
					j_coliseo1.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					j_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio I")) {
					i_j.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio K")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					k_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio L")) {
					k_l.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Caballeriza")) {
					k_caballeriza.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio B")) {
					b_k.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio L")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 1")) {
					l_coliseo1.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					l_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio C")) {
					c_l.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio J")) {
					j_l.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio K")) {
					k_l.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio M")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					m_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					m_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Auditorios")) {
					m_auditorios.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio A")) {
					a_m.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Edificio N")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					n_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio F")) {
					f_n.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Saman")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("CANCHA 7")) {
					saman_cancha7.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio A")) {
					a_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio B")) {
					b_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio C")) {
					c_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio D")) {
					d_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio E")) {
					e_saman.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio M")) {
					m_saman.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Biblioteca")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					biblioteca_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio A")) {
					a_biblioteca.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio B")) {
					b_biblioteca.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Auditorios")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Central")) {
					auditorios_central.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio A")) {
					a_auditorios.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio G")) {
					g_auditorios.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio M")) {
					m_auditorios.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Coliseo 1")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					coliseo1_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Caballeriza")) {
					coliseo1_caballeriza.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio J")) {
					j_coliseo1.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio L")) {
					l_coliseo1.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio F")) {
					f_coliseo1.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("CANCHA 11")) {
					coliseo2_cancha11.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio F")) {
					f_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio L")) {
					l_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio J")) {
					j_coliseo2.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio N")) {
					n_coliseo2.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Cancha 7")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Cancha 11")) {
					cancha7_cancha11.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio E")) {
					e_cancha7.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Saman")) {
					saman_cancha7.setVisible(true);
				}
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Cancha 11")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Cancha 7")) {
					cancha7_cancha11.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio I")) {
					i_cancha11.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 2")) {
					coliseo2_cancha11.setVisible(true);
				}	
			}else if(laCosa.getNameBuilding().equalsIgnoreCase("Caballeriza")) {
				if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio G")) {
					g_caballeriza.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Edificio K")) {
					k_caballeriza.setVisible(true);
				}else if(edificios.peek().getNameBuilding().equalsIgnoreCase("Coliseo 1")) {
					coliseo1_caballeriza.setVisible(true);
				}
			}
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
