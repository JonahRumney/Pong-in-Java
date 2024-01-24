package pack;

import java.util.ArrayList;
import java.math.*;
import java.awt.Color;
import javax.swing.JLabel;

public class Main {

	private static MyFrame m;
	private static Controller c;
	static Player player1;
	static Player player2;
	static Ball ball;
	
	private static double deltaTime, lastTime; //only used in updateDeltaTime()
	private static ArrayList<Double> deltaTimes = new ArrayList<Double>();//array of deltaTimes to get an average deltaTime
	private static int deltaTimeSamples = 100;//inputs for deltaTimes list; less samples = better performance
	
	private static int frameCount = 0;
	private static int preferedFps = 60;
	private static boolean isDead = false;
	
	public static void main(String[] args) {
		for (int i = 0; i < deltaTimeSamples; i++) {//initializes delta samples to 0
			deltaTimes.add(0.0);
		}
		c = new Controller(); //create new controller
		m = new MyFrame(); //create new frame
		ball = new Ball(18);
		player1 = new Player(1, 10);
		player2 = new Player(2, 10);
		

		
		updateDeltaTime();//update the delta time once before running _update()
		_update();
	}
	

	
	//vvvvvvvvvvvvvvvv----------Updating Methods: calls other classes Update methods--------------vvvvvvv
	public static void _update() {//loop updates every instance
		while (true) {
			getFrameUpdates();
		}
	}
	
	public static void _frameUpdate() {//loop updates preferedFps per second : send _frameUpdate loop to other scripts
		ball.drawBall();
		player1.drawPlayer();
		player2.drawPlayer();
		player1.move();
		player2.move();
		ball.move();
		detectHit();
		offScreen();
	}
	public static void updateDeltaTime() {
		deltaTime = 1000000000.0 / (System.nanoTime() - lastTime);//gets delta time
        lastTime = System.nanoTime();
	}
	
	public static double getDeltaAverage() {
		double a = 0;
		for (double d : deltaTimes) {
			a += d;
		}
		
		return a/deltaTimes.size();
	}
	public static void takeDeltaSample() {
		deltaTimes.remove(0);
		deltaTimes.add(deltaTime);
	}
	//^^^^^^^^^^^^----------Updating Methods: calls other classes Update methods--------------^^^^^
	
	public static void getFrameUpdates() {
		updateDeltaTime();
		takeDeltaSample();
		if (frameCount >= getDeltaAverage()/preferedFps) {
			_frameUpdate();
			frameCount = 0;
		}
		frameCount++;
	}
	public static Controller getController() {
		return c;
	}
	public static MyFrame getMyFrame() {
		return m;
	} 
	public static Player getPlayer1() {
		return player1;
	}
	public static Player getPlayer2() {
		return player2;
	}
	
	private static void detectHit() {
		if(isDead)
			return;
		if (ball.getX() - ball.getRadius() <= player1.getX() + player1.getWidth()) { //left side
			if(ball.getY() + ball.getRadius() > player1.getY() && ball.getY() - ball.getRadius() < player1.getY() + player1.getHeight()) { //when you hit left paddle
				ball.speedUp();
				ball.setXDirection(1);
				ball.setX(player1.getX() + player1.getWidth() + ball.getRadius());
			}
			else {
				isDead = true;
			}
			
			
		}
		if (ball.getX() + ball.getRadius() >= player2.getX()) { //right side
			if(ball.getY() + ball.getRadius() > player2.getY() && ball.getY() - ball.getRadius() < player2.getY() + player2.getHeight()) { //when you hit right paddle
				ball.speedUp();
				ball.setXDirection(-1);
				ball.setX(player2.getX() - ball.getRadius());
			}
			else {
				isDead = true;
			}
			
		}
	}
	private static void offScreen() {
		if(ball.getX() + ball.getRadius() < 0 || ball.getX() - ball.getRadius() > MyFrame.getScreenWidth() ) {
			resetGame();
			isDead = false;
		}
	}
	private static void resetGame() {
		ball.resetPosition();
		ball.resetSpeed();
	}
	
	
	
	
	
	
	
	
	
}
