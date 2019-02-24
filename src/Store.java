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
	
	Rental rent(ArrayList<Tool> toRent, int numDays){
		
		Rental r = new Rental(day, day + numDays);
		
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
	}
}
