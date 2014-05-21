package com.trvajjala.entities.constants;

public enum TaxType {

	GST("Goods And Service Tax"), HST("Harmonized Sales Tax");

	private String name;

	private TaxType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
