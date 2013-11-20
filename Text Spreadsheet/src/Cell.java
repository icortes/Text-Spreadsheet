public class Cell {

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
}
