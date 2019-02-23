import java.util.ArrayList;

public class Store {
	private int day;
	private int numTools;
	ArrayList<Tool> tools;
	
	Store(){
		day = 0;
		numTools = 20;
		
	}
	void update(int dayNumber){
		day = dayNumber;
	}
}
