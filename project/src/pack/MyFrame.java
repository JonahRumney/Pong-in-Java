package pack;

import java.awt.Color;
import javax.swing.*;

public class MyFrame extends JFrame {
	
	private static int screenWidth = 1280;
	private static int screenHeight = 720;
	
	
	MyFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setLayout(null);
		this.addKeyListener(Main.getController());
		this.getContentPane().setBackground(new Color(0, 0, 0, 255));
		
		this.setVisible(true);
		
	}
	
	public static int getScreenWidth() {
		return screenWidth;
	}
	public static int getScreenHeight() {
		return screenHeight - 35; //35 is just weird offset
	}
	
}