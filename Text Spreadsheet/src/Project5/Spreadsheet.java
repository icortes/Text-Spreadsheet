package Project5;

import java.util.Scanner;

public class Spreadsheet {
	private static int length;

	public static void main(String[] args) {
		Cell[][] spreadsheet = new Cell[8][10];
		length = spreadsheet[0].length;
		setSpreadsheetToEmpty(spreadsheet);
		printSpreadsheet(spreadsheet);

		String inputFromUser = inputFromUser();
		while (!inputFromUser.equalsIgnoreCase("quit")) {
			int indexOfEquals = inputFromUser.indexOf("=");
			if (inputFromUser.contains("clear")
					&& inputFromUser.indexOf(" ") != -1) {
				cellToClear(
						inputFromUser.substring(inputFromUser.indexOf(" ") + 1),
						spreadsheet);
			} else if (inputFromUser.equalsIgnoreCase("clear")) {
				setSpreadsheetToEmpty(spreadsheet);
			} else if (indexOfEquals >= 0) {
				String cellToSet = inputFromUser.substring(0, indexOfEquals)
						.trim();
				String cellVal = inputFromUser.substring(indexOfEquals + 1)
						.trim();
				int row = getRowNumber(cellToSet);
				int col = getColNumber(cellToSet);
				System.out.println("cellVal =" + cellVal);
				Cell cell = null;
				if (cellVal.startsWith("\"")) {
					cell = new TextCell(cellVal.substring(1).substring(0,
							cellVal.length() - 2));
				} else {
					try {
						cell = new NumberCell(Double.parseDouble(cellVal));
					} catch (Exception e) {

					}
				}
				try {
					spreadsheet[row][col] = cell;
				} catch (Exception e) {
					System.out.println("Index out of bounds.");
				}
			} else if (indexOfEquals == -1) {
				try {
					String cell = inputFromUser;
					int row = getRowNumber(cell);
					int col = getColNumber(cell);
					System.out.println(spreadsheet[row][col]);
				} catch (Exception e) {
					System.out.println("Please Try Again.");
				}
			}
			printSpreadsheet(spreadsheet);
			inputFromUser = inputFromUser();
		}
	}

	private static void cellToClear(String cell, Cell[][] spreadsheet) {
		int row = getRowNumber(cell);
		int col = getColNumber(cell);

		spreadsheet[row][col] = new EmptyCell();
	}

	private static int getColNumber(String cell) {
		return Character.getNumericValue(cell.charAt(0)) - 10;
	}

	private static int getRowNumber(String cell) {
		return Integer.parseInt(cell.substring(1));
	}

	private static String inputFromUser() {
		return new Scanner(System.in).nextLine();
	}

	private static void printSpreadsheet(Cell[][] spreadsheet) {
		printHeader();
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

	private static void printHeader() {
		String headerString = "  |";
		for (int i = 0; i < length; i++) {
			int valOfA = (int) 'A';
			char letterToOutput = (char) (i + valOfA);
			headerString += String.format("     %c    |", letterToOutput);
		}
		System.out.println(headerString);
	}

	private static void setSpreadsheetToEmpty(Cell[][] spreadsheet) {
		for (int rowNum = 0; rowNum < spreadsheet.length; rowNum++) {
			for (int colNum = 0; colNum < spreadsheet[rowNum].length; colNum++) {
				spreadsheet[rowNum][colNum] = new EmptyCell();
			}
		}
	}

}
