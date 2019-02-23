public class Simulation {
	Simulation(){
	
	}
	boolean setup(){
		return(true);
	}
	
	boolean run(int numDays){
		for(int i = 1; i <= numDays; i++){
			System.out.println("Today is day: " + i);
		}
		return(true);
	}
}
