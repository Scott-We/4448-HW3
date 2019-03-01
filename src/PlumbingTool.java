public class PlumbingTool extends Tool {
	public PlumbingTool(int n) {
		super("Plumbing Tool #" + Integer.toString(n));
	}

	// All concrete tools cost $15 per day
	public int getPrice() {
		return 15;
	}
}
