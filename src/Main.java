public class Main {
	public static void main(String[] args){
		
		for(int i = 0; i < 20; i++) {
			Simulation s = new Simulation();
			s.setup();
			s.run(35);
			if(i < 19){
				System.out.println();
				//System.out.println("=========================");
				//System.out.println();
			}
		}
		
	}
}
