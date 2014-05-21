package com.trvajjala.entities.constants;

public enum Country {

	US("US", "United States Of America"), UK("UK", "United Kingdom"), JP("JP",
			"Japan"), KR("KR", "Korea"), IN("IN", "India"), CA("CA", "Canada");

	private String code;
	private String name;

	private Country(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

}
