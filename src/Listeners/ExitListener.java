package Listeners;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitListener implements ActionListener {

	private Window frame;
	
	public ExitListener(Window frame) {
		this.frame = frame;
	}
	
	// Close application window
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
	}

}
