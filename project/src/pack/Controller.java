package pack;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller extends Component implements KeyListener {
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 87:
			//pressed w
			Main.getPlayer1().setDirection(-1);
			
			break;
		case 83:
			//pressed s 
			Main.getPlayer1().setDirection(1);
			
			break;
		case 73:
			//up arrow
			Main.getPlayer2().setDirection(-1);
			
			break;
		case 75:
			//down arrow
			Main.getPlayer2().setDirection(1);
			
			break;
		default:
			break;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
		case 87:
			//pressed w
			Main.getPlayer1().setDirection(0);
			
			break;
		case 83:
			//pressed s 
			Main.getPlayer1().setDirection(0);
			
			break;
		case 73:
			//up arrow
			Main.getPlayer2().setDirection(0);
			
			break;
		case 75:
			//down arrow
			Main.getPlayer2().setDirection(0);
			
			break;
		default:
			break;
		
	}
	
}
}
