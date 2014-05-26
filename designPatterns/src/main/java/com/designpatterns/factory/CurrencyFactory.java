package com.designpatterns.factory;

public class CurrencyFactory {

	/**
	 * Factory Produces Similar kind of Objects based on some inputs
	 * 
	 * @param countryIsoCode
	 * @return
	 */
	public static Currency getCurrency(String countryIsoCode) {

		if ("IN".equalsIgnoreCase(countryIsoCode)) {
			return new Rupee();
		} else if ("US".equalsIgnoreCase(countryIsoCode)) {
			return new Dollar();
		}
		return null;
	}
}
