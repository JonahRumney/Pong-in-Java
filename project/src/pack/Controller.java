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
		System.out.println(e.getKeyCode());
		switch(e.getKeyCode()) {
		case 87:
			//pressed w
			break;
		case 83:
			//pressed s 
			break;
		case 38:
			//up arrow
			break;
		case 40:
			//down arrow
			break;
		default:
			break;
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("yoo");
		
	}
	
}
