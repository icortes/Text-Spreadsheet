package Spreadsheet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Cell extends JFrame implements KeyListener, ActionListener {

	public String data;
	public String a;

	public Cell(String value) {
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
