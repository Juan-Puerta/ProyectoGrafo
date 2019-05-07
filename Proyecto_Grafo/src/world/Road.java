package world;

import java.io.Serializable;

public class Road implements Serializable{

	private static final long serialVersionUID = -5207714931731101495L;
	
	private String nameRoad;
	private int cost;

	public Road(String nameRoad, int cost) {
		// TODO Auto-generated constructor stub
		this.nameRoad = nameRoad;
		this.cost = cost;
	}

	public String getNameRoad() {
		return nameRoad;
	}

	public void setNameRoad(String nameRoad) {
		this.nameRoad = nameRoad;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
}
