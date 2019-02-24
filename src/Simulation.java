import java.util.ArrayList;
import java.util.Random;

class Simulation {
	private ArrayList<String> customers;
	private Store store;
	
	Simulation(){
		customers = new ArrayList<>();
		store = new Store();
	}
	boolean setup(){
		int numCustomers = 10;
		
		Random r = new Random();
		
		for(int i = 0; i < numCustomers; i++){
			customers.add("Customer" + (i+1));
		}
		
		store.setup();
		
		return(true);
	}
	
	boolean run(int numDays){
		for(int i = 1; i <= numDays; i++){
			store.update(i);
			
			for(int c = 0; c < customers.size(); c++){
				//customers.get(c).update(i, true);
			}
			
			for(int c = 0; c < customers.size(); c++){
				//customers.get(c).update(i, false);
			}
			
			//System.out.println("Today is day: " + i);
		}
		return(true);
	}
}
