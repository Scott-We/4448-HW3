import java.util.ArrayList;

class Store {
	private int day;
	private int numTools;
	ArrayList<Tool> tools;
	
	Store(){
		day = 0;
		numTools = 20;
		
	}
	
	boolean setup(){
		return(true);
	}
	
	void update(int dayNumber){
		day = dayNumber;
	}
}
