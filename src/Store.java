import java.util.ArrayList;


class Store {
	private int date;
	private int numTools;
	private int profit;
	private ArrayList<Tool> tools;
	private ArrayList<Rental> rentals;
	
	Store(){
		date = 0;
		numTools = 20;
		profit = 0;
		tools = new ArrayList<Tool>();
		rentals = new ArrayList<Rental>();
	}

	// Creates 4 tools of each type.
	void setup(){
		for(int i = 0; i < 4; i++) {
			Tool t = new ConcreteTool(i);
			tools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new PaintingTool(i);
			tools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new PlumbingTool(i);
			tools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new WoodworkingTool(i);
			tools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new YardworkingTool(i);
			tools.add(t);
		}
	}

	// Just updates the local copy of the date, used when
	// creating rentals.
	void update(int dateNumber){
		date = dateNumber;
	}

	// Returns the number of tools available.
	int getNumTools(){
		return numTools;
	}

	// Returns the full inventory so customers can look through it.
	// Strictly speaking this isn't necessary for our simulation,
	// since customers just generate random indices for rental,
	// but this would be used in a more realistic simulation where
	// the customers don't randomly pick tools.
	ArrayList<Tool> getAvailableTools(){
		return tools;
	}

	// Generates a Rental for a customer, removes those tools from its
	// inventory, and adjusts its profit appropriately.
	Rental rent(ArrayList<Tool> toRent, int numDays, String renter) {
		Rental r = new Rental(date, date + numDays, renter);
		int cost = 0;
		
		for(Tool t : toRent){
			r.addTool(t);
			cost += t.getPrice()*numDays;
			tools.remove(t);
		}
		
		profit += cost;
		rentals.add(r);
		numTools -= toRent.size();
		
		return r;
	}

	// Collects tools from a rental a puts them back in its inventory.
	void returnTools(Rental r){
		tools.addAll(r.getTools());
		numTools += r.numTools();
	}

	// Prints a summary of the history of the simulation, including total profit,
	// remaining inventory, past rentals, and current rentals.
	void printSummary(){
		System.out.println("There are " + tools.size() + " tools in the store.");
		if(numTools >0) {
			System.out.print("The tool(s) are: [" + tools.get(0).getID());
		}
		if(numTools > 1){
			for(int i = 1; i < numTools; i++){
				System.out.print(", " + tools.get(i).getID());
			}
		}if(numTools >0) {
			System.out.println("].");
		}
		
		System.out.println("The store made $" + profit + " over the " + date + " days");
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("Completed rentals:");
		
		for(Rental r: rentals){
			if(r.isDue(date)){
				System.out.println(r);
			}
		}
		
		System.out.println();
		System.out.println("Ongoing rentals:");
		
		int toolsOut = 0;
		
		for(Rental r: rentals){
			if(!r.isDue(date)){
				System.out.println(r);
				toolsOut += r.numTools();
			}
		}
		
		System.out.println();
		System.out.println("Number of tools currently out: " + toolsOut);
	}
}
