import java.util.ArrayList;
import java.util.Random;

class Simulation {
	private ArrayList<Customer> customers;
	private Store store;
	
	Simulation(){
		customers = new ArrayList<>();
		store = new Store();
	}
	boolean setup(){
		int numCustomers = 10;
		int numBusi = 0;
		int numCasu = 0;
		int numRegu = 0;
		
		Random r = new Random();
		for(int i = 0; i < numCustomers; i++){
			int type = r.nextInt(3);
			System.out.println(type);
			switch (type){
				case 0:
					numBusi ++;
					customers.add(new BusinessCustomer(store, "Busi customer " + numBusi));
					break;
				case 1:
					numCasu ++;
					customers.add(new CasualCustomer(store, "Casu customer " + numCasu));
					break;
				case 2:
					numRegu ++;
					customers.add(new RegularCustomer(store, "Regu customer " + numRegu));
					break;
			}
			
			
		}
		
		store.setup();
		
		return(true);
	}
	
	boolean run(int numDays){
		for(int i = 1; i <= numDays; i++){
			store.update(i);
			
			for(int c = 0; c < customers.size(); c++){
				customers.get(c).update(i, true);
			}
			
			for(int c = 0; c < customers.size(); c++){
				customers.get(c).update(i, false);
			}
			
		}
		
		store.printSummary();
		
		return(true);
	}
}
