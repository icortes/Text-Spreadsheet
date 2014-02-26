package Project5;

public abstract class Cell<E> {
	public E data;

	public Cell(E value) {
		data = value;
	}

	public E getData() {
		return data;

	}

	public String getDataForSpreadsheet() {
		try {
			return data.toString().substring(0, 10);
		} catch (Exception e) {
			return (String) data;
		}
	}

	public String toString() {
		return (String) data;
	}
}
