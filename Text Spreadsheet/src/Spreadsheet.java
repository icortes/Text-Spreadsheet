public class Spreadsheet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cell[][] spreadsheet = new Cell[12][22];
		setSpreadsheetToEmpty(spreadsheet);

		printSpreadsheet(spreadsheet);
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
		for (int i = 0; i < 22; i++) {
			int valOfA = (int) 'A';
			char letterToOutput = (char) (i + valOfA);
			headerString += String.format("     %c    |", letterToOutput);
		}
		System.out.println(headerString);
	}

	private static void setSpreadsheetToEmpty(Cell[][] spreadsheet) {
		for (int rowNum = 0; rowNum < spreadsheet.length; rowNum++) {
			for (int colNum = 0; colNum < spreadsheet[rowNum].length; colNum++) {
				spreadsheet[rowNum][colNum] = new Cell("");
			}
		}
	}

}
