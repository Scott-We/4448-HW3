public abstract class Tool {
	private String ID;

	public Tool(String _ID) {
		ID = _ID;
	}

	public abstract int getPrice();

	public String getID() {
		return ID;
	}
}
