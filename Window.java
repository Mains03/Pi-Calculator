import javax.swing.JFrame;

import java.awt.Graphics;
import java.awt.Dimension;

import java.util.ArrayList;

public class Window {
	private class Canvas extends java.awt.Canvas {
		public class Position {
			public double x;
			public double y;
			
			public Position(double x, double y) {
				this.x = x;
				this.y = y;
			}
		}
		
		public ArrayList<Position> positions;
		private int positioncount;
		
		public boolean drawPoints;
		
		public Canvas() {
			this.positions = new ArrayList<Position>();
			positioncount = 0;
			drawPoints = false;
		}
		
		public void add_position(double x, double y) {
			Position position = new Position(x, y);
			positions.add(position);
			positioncount += 1;
		}
		
		@Override
		public void paint(Graphics g) {
			if (drawPoints) {
				Position position;
				int width = getWidth();
				int height = getHeight();
				for (int i = 0; i < positioncount; ++i) {
					position = positions.get(i);
					int screenx = (int)(position.x*width);
					int screeny = (int)(position.y*height);
					g.drawLine(screenx, screeny, screenx, screeny);
				}
				g.drawArc(0-width,0-height,2*width,2*height,0,-90);
			}
		}
	}
	
	private JFrame window;
	private Canvas canvas;
	
	public Window(String title) {
		window = new JFrame(title);
	}
	
	public void create_window() {
		canvas = new Canvas();
		window.add(canvas);
		
		window.setSize(640,480);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
	}
	
	/*
	 * x and y are between 0 and 1
	 */
	public void plot_point(double x, double y) {
		canvas.add_position(x, y);
	}
	
	public void finished() {
		canvas.drawPoints = true;
		canvas.repaint();
	}
}
