import java.util.ArrayList;

public class Rental {
	private ArrayList<Tool> tools;
	int rentDate, returnDate;

	public Rental(int _rentDate, int _returnDate) {
		rentDate = _rentDate;
		returnDate = _returnDate;
	}

	public void addTool(Tool t) {
		tools.add(t);
	}

	public boolean isDue(int date) {
		return date >= returnDate;
	}
}
