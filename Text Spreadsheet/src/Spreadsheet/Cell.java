package Spreadsheet;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Cell extends TextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Cell(String value) {
		super(value);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
