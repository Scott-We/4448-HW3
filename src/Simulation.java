import java.util.ArrayList;

class Simulation {
	private ArrayList<String> customers;
	//private Store store;
	
	Simulation(){
		customers = new ArrayList<>();
		//store = new Store();
	}
	boolean setup(){
		int numCustomers = 10;
		
		for(int i = 0; i < numCustomers; i++){
			customers.add("Customer" + (i+1));
		}
		
		System.out.println(customers);
		return(true);
	}
	
	boolean run(int numDays){
		for(int i = 1; i <= numDays; i++){
			
			System.out.println("Today is day: " + i);
		}
		return(true);
	}
}
