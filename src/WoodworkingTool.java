public class WoodworkingTool extends Tool {
	public WoodworkingTool(int n) {
		super("Woodworking Tool #" + Integer.toString(n));
	}

	// All concrete tools cost $10 per day
	public int getPrice() {
		return 10;
	}
}
