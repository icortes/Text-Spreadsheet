package Spreadsheet;

import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Spreadsheet {

	public static void main(String[] args) {
		final Cell[][] tf = new Cell[12][22];
		setCellToEmpty(tf);

		JFrame frame = new JFrame("Spreadsheet");
		JLabel headerLabel = new JLabel(header());
		JPanel panel = new JPanel();
		frame.setContentPane(panel);

		panel.setLayout(new GridLayout(12, 22));
		// panel.add(headerLabel);
		for (int row = 0; row < tf.length; row++) {
			panel.add(new JLabel(String.format("%2d|", row + 1)));
			for (int col = 0; col < tf[row].length; col++) {
				panel.add(tf[row][col]);
				tf[row][col].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame frame = new JFrame("Spreadsheet");
						JPanel panel = new JPanel();
						frame.setContentPane(panel);

						panel.add(new TextField(10));
						JButton b = new JButton("Enter");
						b.addMouseListener(new MouseListener() {

							@Override
							public void mouseClicked(MouseEvent e) {
								// TODO Auto-generated method stub
							}

							@Override
							public void mouseEntered(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseExited(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mousePressed(MouseEvent e) {
								// TODO Auto-generated method stub

							}

							@Override
							public void mouseReleased(MouseEvent e) {
								// TODO Auto-generated method stub

							}
						});

						frame.pack();
						frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						frame.setVisible(true);
					}
				});
			}
		}

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private static void cellToClear(String cell, Cell[][] spreadsheet) {
		int row = getRowNumber(cell);
		int col = getColNumber(cell);

		spreadsheet[row][col] = new Cell("");
	}

	private static int getColNumber(String cell) {
		return Character.getNumericValue(cell.charAt(0)) - 10;
	}

	private static int getRowNumber(String cell) {
		return Integer.parseInt(cell.substring(1)) - 1;
	}

	private static String inputFromUser() {
		return new Scanner(System.in).nextLine();
	}

	private static void printSpreadsheet(Cell[][] spreadsheet) {
		header();
		for (int rowNum = 0; rowNum < spreadsheet.length; rowNum++) {
			System.out.print(String.format("%2d|", rowNum + 1));
			Cell[] row = spreadsheet[rowNum];
			for (Cell val : row) {
				System.out.print(String.format("%10s|",
						val.getDataForSpreadsheet()));
			}
			System.out.println();
		}
	}

	private static String header() {
		String headerString = "  |";
		for (int i = 0; i < 22; i++) {
			int valOfA = (int) 'A';
			char letterToOutput = (char) (i + valOfA);
			headerString += String.format("     %c    |", letterToOutput);
		}
		return headerString;
	}

	private static void setCellToEmpty(Cell[][] tf) {
		for (int rowNum = 0; rowNum < tf.length; rowNum++) {
			for (int colNum = 0; colNum < tf[rowNum].length; colNum++) {
				tf[rowNum][colNum] = new Cell(String.format("%5s", ""));
			}
		}
	}

}
