package pack;

import java.awt.Color;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	private static int screenWidth = 640;
	private static int screenHeight = 480;
	
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setLayout(null);
		this.addKeyListener(Main.getController());
		
		this.setVisible(true);
		
	}
	
	public static int getScreenWidth() {
		return screenWidth;
	}
	public static int getScreenHeight() {
		return screenHeight;
	}
	
}