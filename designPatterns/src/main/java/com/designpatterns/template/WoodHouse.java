package com.designpatterns.template;

/**
 * 
 * @author tvajjala
 *
 */
public class WoodHouse extends HouseTemplate {

	@Override
	public void buildWalls() {
		System.out.println("wood walls constructed ");
	}

	@Override
	public void addWindows() {
		System.out.println("wood windows constructed ");

	}

	@Override
	public void addDoors() {
		System.out.println("wood doors constructed ");

	}

}
