import java.util.ArrayList;

public class Rental {
	private ArrayList<Tool> tools = new ArrayList<>();
	int rentDate, returnDate;
	String renter;

	public Rental(int _rentDate, int _returnDate, String _renter) {
		rentDate = _rentDate;
		returnDate = _returnDate;
		renter = _renter;
	}

	// Adds a tool to the rental's list.
	public void addTool(Tool t) {
		tools.add(t);
	}

	// Decides if it is time to return the rental.
	public boolean isDue(int date) {
		return date >= returnDate;
	}

	// Returns the tools to be added back into the store's inventory.
	public ArrayList<Tool> getTools() {
		return tools;
	}

	// Just the length of the tools list.
	public int numTools() {
		return tools.size();
	}

	// Converts itself to a string for printing the summary.
	public String toString() {
		String result = renter + " rented [ ";
		result += tools.get(0).getID();
		for (int i = 1; i < tools.size(); i++) {
			result += ", " + tools.get(i).getID();
		}
		result += " ] from day " + rentDate + " to day " + returnDate + ".";
		return result;
	}
}
