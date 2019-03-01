// An encapsulates the varying behavior between business,
// regular, and casual customers. This way we don't need to
// inherit Customer three times with duplicate code.
public interface RentalStrategy {
	public int numToolsToRent();
	public int numDaysToRent();
}