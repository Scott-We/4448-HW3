import java.util.concurrent.ThreadLocalRandom;

// A Rental Strategy which returns random choices from a predetermined
// range of possible tools and days.
public class RandomRentalStrategy implements RentalStrategy {
	int minTools, maxTools;
	int minDays, maxDays;

	public RandomRentalStrategy(int minTools, int maxTools, int minDays, int maxDays) {
		this.minTools = minTools;
		this.maxTools = maxTools;
		this.minDays = minDays;
		this.maxDays = maxDays;
	}

	public int numToolsToRent() {
		return ThreadLocalRandom.current().nextInt(minTools, maxTools + 1);
	}

	public int numDaysToRent() {
		return ThreadLocalRandom.current().nextInt(minDays, maxDays + 1);
	}
}
