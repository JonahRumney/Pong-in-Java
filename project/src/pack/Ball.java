package pack;

import java.awt.Color;

import javax.swing.JLabel;

public class Ball {
	private int x;
	private int y;
	private int radius;
	private int speed;
	private int xDir;
	private int yDir;
	private JLabel ball;
	
	public Ball(int r) {
		radius = r;
		resetSpeed();
		resetPosition();
		ball = new JLabel();
		ball.setOpaque(true);
		ball.setBackground(Color.white);
		Main.getMyFrame().add(ball);
		xDir = -1;
		yDir = -1;
	}
	
	public void drawBall() {
		ball.setBounds(x - radius, y - radius, 2*radius, 2*radius);
	}
	public void setX(int n) {
		x = n;
	}
	public void setY(int n) {
		y = n;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	public int getRadius() {
		return radius;
	}
	public void move() {
		x += speed * xDir;
		y += speed * yDir;
		if (y - radius <= 0) {
			y = radius;
			yDir = 1;
		}
		if (y + radius >= MyFrame.getScreenHeight()) {
			y = MyFrame.getScreenHeight() - radius;
			yDir = -1;
		}
	}
	public void setXDirection(int n) {
		if (n >= -1 && n <= 1)
			xDir = n;
	}
	public void setYDirection(int n) {
		if (n >= -1 && n <= 1)
			yDir = n;
	}
	public void resetPosition() {
		x = MyFrame.getScreenWidth()/2;
		y = MyFrame.getScreenHeight()/2;
	}
	public void speedUp() {
		speed++;
	}
	public void resetSpeed() {
		speed = 4;
		
	}
	
	
}


