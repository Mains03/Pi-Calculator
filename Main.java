
public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		
		RandomPosition randpos = new RandomPosition();
		Window window = new Window("Pi calculator");
		
		window.create_window();
		
		double x;
		double y;
		
		int incircle = 0;
		int insquare = 100000;
		
		for (int i = 0; i < insquare; i++) {
			randpos.new_position();
			x = randpos.getx();
			y = randpos.gety();
			
			if (main.in_circle(x, y, 1)) {
				incircle += 1;
			}
			
			window.plot_point(x, y);
		}
		
		window.finished();
		
		double pi = 4*((double)incircle/(double)insquare);
		System.out.println("Pi: " + Double.toString(pi));
	}
	
	public boolean in_circle(double x, double y, double radius) {
		return (Math.sqrt(Math.pow(x,2)+Math.pow(y,2)) <= radius);
	}
}
