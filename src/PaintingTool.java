public class PaintingTool extends Tool {
	public PaintingTool(int n) {
		super("Painting Tool #" + Integer.toString(n));
	}

	// All concrete tools cost $13 per day
	public int getPrice() {
		return 13;
	}
}
