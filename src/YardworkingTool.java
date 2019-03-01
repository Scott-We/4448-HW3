public class YardworkingTool extends Tool {
	public YardworkingTool(int n) {
		super("Yardworking Tool #" + Integer.toString(n));
	}

	// All concrete tools cost $6 per day
	public int getPrice() {
		return 6;
	}
}