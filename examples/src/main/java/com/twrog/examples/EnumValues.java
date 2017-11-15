package com.twrog.examples;

public class EnumValues {

    public enum CLASSI {
	BENIGN("benign"), LB("likely benign"), VUS("variant of unknown significance"), LP("likely pathogenic"), PATHO(
		"pathogenic"), UNCLASSIFIED("unclassified");
	private String value;

	private CLASSI(String value) {
	    this.value = value;
	}

	public String getValue() {
	    return value;
	}

	@Override
	public String toString() {
	    return this.getValue();
	}
    }

}
