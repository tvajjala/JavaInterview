package com.designpatterns.prototype;

public class Bike implements Cloneable {

	private int gears;
	private String bikeType;
	private String model;
	private String breakType;
	private String color;
	private String price;
	
	

	/**
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * @return the breakType
	 */
	public String getBreakType() {
		return breakType;
	}

	/**
	 * @param breakType the breakType to set
	 */
	public void setBreakType(String breakType) {
		this.breakType = breakType;
	}

	/**
	 * @return the gears
	 */
	public int getGears() {
		return gears;
	}

	/**
	 * @param gears the gears to set
	 */
	public void setGears(int gears) {
		this.gears = gears;
	}

	/**
	 * @return the bikeType
	 */
	public String getBikeType() {
		return bikeType;
	}

	/**
	 * @param bikeType the bikeType to set
	 */
	public void setBikeType(String bikeType) {
		this.bikeType = bikeType;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	public Bike() {
		breakType="DRUMTYPE";
		bikeType = "SZ";
		model = "YAMAHA";
		gears = 4;
		price="60,000";
		color="RED";
		
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
