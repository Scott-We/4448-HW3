import java.util.ArrayList;


class Store {
	private int day;
	private int numTools;
	ArrayList<Tool> tools;
	
	Store(){
		day = 0;
		numTools = 20;
		tools = new ArrayList<>();
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
	
	//Rental rent(ArrayList<String> Ids){}
	
	//void return(Rental r){}
}
