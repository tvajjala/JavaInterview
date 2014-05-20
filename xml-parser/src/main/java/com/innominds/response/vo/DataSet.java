package com.innominds.response.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author tvajjala
 *
 */
public class DataSet implements Serializable {

	private static final long serialVersionUID = -168777842498065533L;

	private String type;

	private List<Data> records = new ArrayList<Data>();

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the records
	 */
	public List<Data> getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            the records to set
	 */
	public void setRecords(List<Data> records) {
		this.records = records;
	}

}
