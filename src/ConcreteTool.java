public class ConcreteTool extends Tool {
	public ConcreteTool(int n) {
		super("Concrete Tool #" + Integer.toString(n));
	}

	public int getPrice() {
		return 100;
	}
}