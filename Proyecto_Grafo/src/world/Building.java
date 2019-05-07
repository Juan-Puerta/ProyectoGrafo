package world;

import java.io.Serializable;

public class Building implements Serializable{

	private static final long serialVersionUID = 7008162910484890326L;
	
	private String nameBuilding;
	
	public Building(String nameBuilding) {
		// TODO Auto-generated constructor stub
		this.nameBuilding = nameBuilding;
	}

	public String getNameBuilding() {
		return nameBuilding;
	}

	public void setNameBuilding(String nameBuilding) {
		this.nameBuilding = nameBuilding;
	}
	
}
