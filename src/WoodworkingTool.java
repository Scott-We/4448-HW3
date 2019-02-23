public class WoodworkingTool extends Tool {
	public WoodworkingTool(int n) {
		super("Woodworking Tool #" + Integer.toString(n));
	}

	public int getPrice() {
		return 10;
	}
}
