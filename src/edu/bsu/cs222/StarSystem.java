package edu.bsu.cs222;

import java.util.ArrayList;
import java.util.Iterator;

public class StarSystem{
	
	public static StarSystem creatStarSystem(){
		return new StarSystem();
	}
	
	private ArrayList<Sun> sunList;
	private ArrayList<Planet> planetList;
	
	private StarSystem(){
		sunList = new ArrayList<Sun>();
		planetList = new ArrayList<Planet>();
	}
	
	public boolean isEmpty() {
		return sunList.isEmpty()&&planetList.isEmpty();
	}

	public void addPlanet(Planet planet) {
		planetList.add(planet);
	}

	public void addSun(Sun sun) {
		sunList.add(sun);
	}

	public Iterator<Sun> sunIterator() {
		return sunList.iterator();
	}

	public Iterator<Planet> planetIterator() {
		return planetList.iterator();
	}
	
	public int size(){
		return (sunList.size()+planetList.size());
	}

}
