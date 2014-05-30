package com.designpatterns.template;

public abstract class HouseTemplate {

	public HouseTemplate() {
		buildBasement();
		buildPillars();
	}

	private void buildBasement() {
		System.out.println(" basement ready ");
	}

	private void buildPillars() {
		System.out.println(" pillars ready ");
	}

	public abstract void buildWalls();
	
	public abstract void addWindows();
	
	public abstract void addDoors();
	
}
