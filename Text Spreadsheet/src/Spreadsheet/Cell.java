package Spreadsheet;

import java.awt.TextField;

public class Cell extends TextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;
	private String a;

	public Cell(String value) {
		super(value);
		data = value;
	}

	public String getData() {
		return data;

	}

	public String getDataForSpreadsheet() {
		try {
			return data.substring(0, 10);
		} catch (Exception e) {
			return data;
		}
	}

	public String toString() {
		a = data;
		return a;
	}
}
