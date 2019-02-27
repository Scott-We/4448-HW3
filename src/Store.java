import java.util.ArrayList;


class Store {
	private int day;
	private int numTools;
	private int profit;
	private ArrayList<Tool> tools;
	private ArrayList<Tool> masterTools;    //a copy of the tool list for verification purposes
	private ArrayList<Rental> rentals;
	
	Store(){
		day = 0;
		numTools = 20;
		profit = 0;
		tools = new ArrayList<>();
		masterTools = new ArrayList<>();
		rentals = new ArrayList<>();
	}
	
	boolean setup(){
		for(int i = 0; i < 4; i++) {
			Tool t = new ConcreteTool(i);
			tools.add(t);
			masterTools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new PaintingTool(i);
			tools.add(t);
			masterTools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new PlumbingTool(i);
			tools.add(t);
			masterTools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new WoodworkingTool(i);
			tools.add(t);
			masterTools.add(t);
		}
		for(int i = 0; i < 4; i++) {
			Tool t = new YardworkingTool(i);
			tools.add(t);
			masterTools.add(t);
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
	
	Rental rent(ArrayList<Tool> toRent, int numDays, String renter) {
		
		Rental r = new Rental(day, day + numDays, renter);
		
		int cost = 0;
		
		for(Tool t : toRent){
			r.addTool(t);
			cost += t.getPrice()*numDays;
			tools.remove(t);
		}
		
		profit += cost;
		rentals.add(r);
		
		numTools -= toRent.size();
		
		return(r);
	}
	
	void returnTools(Rental r){
		tools.addAll(r.getTools());
		numTools += r.numTools();
	}
	
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
		
		int toolsOut = 0;
		
		for(Rental r: rentals){
			if(!r.isDue(day)){
				System.out.println(r);
				toolsOut += r.numTools();
			}
		}
		
		System.out.println();
		
		System.out.println("Number of tools currently out: " + toolsOut);
		
		
		/*
		Display the current location of each tool.
		
		System.out.println();
		
		int toolI = 0;
		
		for(Tool t: masterTools){
			if(toolI == 4){
				System.out.println();
				toolI = 0;
			}
			boolean found = false;
			if(tools.contains(t)){
				System.out.println("Tool: " + t.getID() + " is in the store");
				found = true;
			}
			for(Rental r: rentals){
				if(!r.isDue(day)){
					if(r.getTools().contains(t)){
						System.out.println("Tool: " + t.getID() + " is with " + r.renter);
						found = true;
					}
				}
			}
			if(!found){
				Rental lastScene = new Rental(-1, -1, "Nill");
				for(Rental r: rentals){
					if(r.getTools().contains(t)){
						lastScene = r;
					}
				}
				System.out.println("Tool: " + t.getID() + " was rented: " + lastScene.rentDate + ":" + lastScene.returnDate + " to " + lastScene.renter);
				
			}
			toolI++;
			
		}
		//*/
	}
}
