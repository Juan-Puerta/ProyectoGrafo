package world;

import java.io.Serializable;

import collections.OurGraph;

public class University implements Serializable{

	private static final long serialVersionUID = 4098102238239025170L;

	private String name;
	private int numBuild;
	private OurGraph<Building, Road> conections;
	
	public University(String name, int numBuild) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.numBuild = numBuild;
		conections = new OurGraph<Building, Road>(numBuild);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumBuild() {
		return numBuild;
	}

	public void setNumBuild(int numBuild) {
		this.numBuild = numBuild;
	}

	public OurGraph<Building, Road> getConections() {
		return conections;
	}

	public void setConections(OurGraph<Building, Road> conections) {
		this.conections = conections;
	}
	
}
