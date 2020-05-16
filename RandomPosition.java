import java.util.Random;

public class RandomPosition {
	private class Position {
		private double x;
		private double y;
		
		public Position() {
			x = 0;
			y = 0;
		}
		
		public void setx(double x) {
			this.x = x;
		}
		
		public void sety(double y) {
			this.y = y;
		}
		
		public double getx() {
			return this.x;
		}
		
		public double gety() {
			return this.y;
		}
	}

	
	private Position position;
	private Random random;
	
	public RandomPosition() {
		position = new Position();
		random = new Random();
	}
	
	public void new_position() {
		position.setx(random.nextDouble());
		position.sety(random.nextDouble());
	}
	
	public double getx() {
		return position.getx();
	}
	
	public double gety() {
		return position.gety();
	}
}
