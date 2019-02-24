import java.util.ArrayList;


class Store {
	private int day;
	private int numTools;
	private int profit;
	private ArrayList<Tool> tools;
	private ArrayList<Rental> rentals;
	
	Store(){
		day = 0;
		numTools = 20;
		profit = 0;
		tools = new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	boolean setup(){
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
		}for(int i = 0; i < 4; i++) {
			Tool t = new YardworkingTool(i);
			tools.add(t);
		}
		
		
		return(true);
	}
	
	void update(int dayNumber){
		day = dayNumber;
	}
	
	int getNumTools(){
		return(numTools);
	}
	
	ArrayList<Tool> getAvailableTools(){
		return(tools);
	}
	
	Rental rent(ArrayList<Tool> toRent, int numDays, String renter){
		
		Rental r = new Rental(day, day + numDays, renter);
		
		int cost = 0;
		
		for(Tool t : toRent){
			r.addTool(t);
			cost += t.getPrice()*numDays;
			tools.remove(t);
		}
		
		System.out.println("Rented " + toRent.size() + " tools for $" + cost);
		
		profit += cost;
		rentals.add(r);
		
		numTools -= toRent.size();
		
		return(r);
	}
	
	void returnTools(Rental r){
		tools.addAll(r.getTools());
		numTools += r.getTools().size();
		System.out.println(r.getTools().size() + " tools returned: " + numTools + " remain.");
	}
	
	void printSummary(){
		System.out.println("There are " + tools.size() + " tools in the store.");
		if(numTools >0) {
			System.out.print("The tools are: [" + tools.get(1).getID());
		}
		if(numTools > 1){
			for(int i = 1; i < numTools; i++){
				System.out.print(", " + tools.get(i).getID());
			}
		}if(numTools >0) {
			System.out.println("].");
		}
		
		System.out.println("The store made $" + profit + " over the 35 days");
		
		System.out.println("=====================================================");
		System.out.println();
		System.out.println("Completed rentals:");
		
		for(Rental r: rentals){
			if(r.isDue(day)){
				System.out.println(r);
			}
		}
		
		System.out.println();
		System.out.println("Ongoing rentals:");
		
		for(Rental r: rentals){
			if(!r.isDue(day)){
				System.out.println(r);
			}
		}
		
	}
}
