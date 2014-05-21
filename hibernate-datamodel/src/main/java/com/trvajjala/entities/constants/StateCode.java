package com.trvajjala.entities.constants;

public enum StateCode {

	AL("AL", "Alabama"),
	AK("AK", "Alaska"),
	AZ("AZ", "Arizona"), 
	AR("AR", "Arkansas"),
	CA("CA","California"),
	CO("CO", "Colorado"),
	CT("CT", "Connecticut"),
	DE("DE", "Delaware"),
	FL("FL", "Florida"),
	GA("GA", "Georgia"),
	HI("HI", "Hawaii"),
	ID("ID", "Idaho"),
	IL("IL", "Illinois"),
	IN("IN", "Indiana"),
	IA("IA", "Iowa"),
	KS("KS", "Kansas"),
	KY("KY", "Kentucky"),
	LA("LA", "Louisiana"),
	ME("ME", "Maine"),
	MD("MD", "Maryland"),
	MA("MA", "Massachusetts"),
	MI("MI", "Michigan"),
	MN("MN", "Minnesota"),
	MS("MS", "Mississippi"),
	MO("MO", "Missouri"),
	MT("MT", "Montana"),
	NE("NE", "Nebraska"),
	NV("NV", "Nevada"),
	NH("NH", "New Hampshire"),
	NJ("NJ", "New Jersey"),
	NM("NM", "New Mexico"),
	NY("NY", "New York"),
	NC("NC", "North Carolina"),
	ND("ND", "North Dakota"),
	OH("OH", "Ohio"),
	OK("OK", "Oklahoma"),
	OR("OR", "Oregon"),
	PA("PA", " Pennsylvania"),
	RI("RI", "Rhode Island"),
	SC("SC", "South Carolina"),
	SD("SD", "South Dakota"),
	TN("TN", "Tennessee"),
	TX("TX", "Texas"),
	UT("UT", "Utah"),
	VT("VT", "Vermont"),
	VA("VA", "Virginia"),
	WA("WA", "Washington"),
	WV("WV", "West Virginia"),
	WI("WI", "Wisconsin"),
	WY("WY", "Wyoming");

	private String code;
	private String name;

	private StateCode(String code, String name) {

		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
