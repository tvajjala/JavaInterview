package com.designpatterns.template;

public class GlassHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("glass walls constructed ");
	}

	@Override
	public void addWindows() {
		System.out.println("glass windows constructed ");

	}

	@Override
	public void addDoors() {
		System.out.println("glass doors constructed ");

	}

}
