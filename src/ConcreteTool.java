public class ConcreteTool extends Tool {
	public ConcreteTool(int n) {
		super("Concrete Tool #" + Integer.toString(n));
	}

	// All concrete tools cost $5 per day
	public int getPrice() {
		return 5;
	}
}