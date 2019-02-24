import java.util.ArrayList;

public class Rental {
	private ArrayList<Tool> tools = new ArrayList<Tool>();
	int rentDate, returnDate;
	String renter;

	public Rental(int _rentDate, int _returnDate, String _renter) {
		rentDate = _rentDate;
		returnDate = _returnDate;
		renter = _renter;
	}

	public void addTool(Tool t) {
		tools.add(t);
	}

	public boolean isDue(int date) {
		return date >= returnDate;
	}

	public ArrayList<Tool> getTools() {
		return tools;
	}

	public int numTools() {
		return tools.size();
	}

	public String toString() {
		String result = renter + " rented [";
		result += tools.get(0).getID();
		for (int i = 1; i < tools.size(); i++) {
			result += "," + tools.get(i).getID();
		}
		result += "] from " + rentDate + " to " + returnDate;
		return result;
	}
}
