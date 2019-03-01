import java.util.ArrayList;
import java.util.Random;

class Simulation {
	private ArrayList<Customer> customers;
	private Store store;
	
	Simulation() {
		customers = new ArrayList<>();
		store = new Store();
	}

	// Creates a store and 10 customers of random types.
	// (Creation of the store is delegated to the store.)
	void setup() {
		int numCustomers = 10;
		int numBusi = 0;
		int numCasu = 0;
		int numRegu = 0;
		
		Random r = new Random();
		for(int i = 0; i < numCustomers; i++){
			int type = r.nextInt(3);
			switch (type){
				case 0:
					numBusi ++;
					customers.add(Customer.createBusinessCustomer(store, numBusi));
					break;
				case 1:
					numCasu ++;
					customers.add(Customer.createCasualCustomer(store, numCasu));
					break;
				case 2:
					numRegu ++;
					customers.add(Customer.createRegularCustomer(store, numRegu));
					break;
			}
		}
		store.setup();
	}

	// Calls update each morning and afternoon, then prints a summary when done.
	void run(int numDays){
		for(int i = 1; i <= numDays; i++){
			store.update(i);
			for(Customer c : customers){
				c.update(i, true);
			}
			for(Customer c : customers){
				c.update(i, false);
			}
		}
		store.printSummary();
	}
}
