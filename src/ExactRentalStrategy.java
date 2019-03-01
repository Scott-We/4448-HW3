// A rental strategy which always returns the same number of tools
// for the same number of days.
public class ExactRentalStrategy implements RentalStrategy {
	int numTools, numDays;

	public ExactRentalStrategy(int numTools, int numDays) {
        this.numTools = numTools;
        this.numDays = numDays;
	}

	public int numToolsToRent() {
		return numTools;
	}
	public int numDaysToRent() {
		return numDays;
	}
}
