package com.designpatterns.prototype;

public class WorkShop {

	Bike bike;

	public WorkShop(Bike bike) {
		this.bike = bike;
	}

	/**
	 * 
	 * @return Basic Model  of the Bike
	 */
	public Bike getBasicModel() {
		return bike;
	}

	/**
	 * 
	 * @return  Enhanced Bike with new features 
	 * @throws NoBikeAvailableException
	 */
	public Bike getAdvancedModel() throws NoBikeAvailableException {

		Bike advancedBike;

		try {
			advancedBike = (Bike) bike.clone();// get basic model
			advancedBike.setBikeType("SZ-R"); // add enhancements without re
												// inventing the wheel
			advancedBike.setBreakType("DISKBREAK");
			advancedBike.setPrice("65,000");
			return advancedBike;
		} catch (CloneNotSupportedException e) {
			throw new NoBikeAvailableException(
					"this bike doesn't have advanced model");
		}

	}

}
