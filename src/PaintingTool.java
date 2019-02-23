public class PaintingTool extends Tool {
	public PaintingTool(int n) {
		super("Painting Tool #" + Integer.toString(n));
	}

	public int getPrice() {
		return 100;
	}
}
