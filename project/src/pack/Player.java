package pack;

import javax.swing.JLabel;

public class Player {
	private int x;
	private int y;
	private int width = 25;
	private int height = 140;
	private int offset = 20;
	private JLabel paddle;
	private int speed;
	private int direction; //-1, 0, 1 for up, not moving, or down
	
	public Player(int i, int s) {
		
		if(i == 1) {
			x = offset;
		}
		if(i == 2) {
			x = MyFrame.getScreenWidth() - offset - width - 20;
		}
		speed = s;
		y = MyFrame.getScreenHeight()/2;
		paddle = new JLabel();
		paddle.setOpaque(true);
		Main.getMyFrame().add(paddle); //add each player to main scene
		
		
	}
	
	public void drawPlayer() {
		paddle.setBounds(x, y, width, height);
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void move() {
		y += speed * direction;
		if(y < 0) {
			y = 0;
		}
		if(y + height > MyFrame.getScreenHeight()) {
			y = MyFrame.getScreenHeight() - height;
		}
	}
	public void setDirection(int n) {
		if (n >= -1 && n <= 1)
			direction = n;
	}
}
