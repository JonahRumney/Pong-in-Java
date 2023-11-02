package pack;

import java.util.ArrayList;
import java.math.*;
import java.awt.Color;

public class Main {
	
	private static MyFrame m;
	private static Controller c;
	
	private static double deltaTime, lastTime; //only used in updateDeltaTime()
	private static ArrayList<Double> deltaTimes = new ArrayList<Double>();//array of deltaTimes to get an average deltaTime
	private static int deltaTimeSamples = 100;//inputs for deltaTimes list; less samples = better performance
	
	private static int frameCount = 0;
	private static int preferedFps = 60;
	
	public static void main(String[] args) {
		for (int i = 0; i < deltaTimeSamples; i++) {
			deltaTimes.add(0.0);
		}
		c = new Controller();
		m = new MyFrame();
		
		
		updateDeltaTime();
		_update();
	}
	public static Controller getController() {
		return c;
	}
	public static void updateDeltaTime() {
		deltaTime = 1000000000.0 / (System.nanoTime() - lastTime);
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
	
	//vvvvvvvvvvvvvvvv----------Updating Methods: calls other classes Update methods--------------vvvvvvv
	public static void _update() {//loop updates every instance
		while (true) {
			getFrameUpdates();
			
			
		}
	}
	
	public static void _frameUpdate() {//loop updates preferedFps per second : send _frameUpdate loop to other scripts
		
		
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
	
	public static MyFrame getMyFrame() {
		return m;
	}
	
	
	
	
}
