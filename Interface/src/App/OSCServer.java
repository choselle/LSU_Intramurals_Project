/*
 * @author Chase Hoselle
 * Starts and manages all the TouchOSC functionality.
 */

package App;

import javax.swing.JComboBox;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.*;
import View.*;
import com.illposed.osc.*;

public class OSCServer {
	
	private OSCPortIn receiver;
	private OSCListener listener;
	int receiverPort = 8000;
	
	public void launchOSServer() throws java.net.SocketException {
		receiver = new OSCPortIn(receiverPort);
		listener = new OSCListener() {
			public void acceptMessage(java.util.Date time, OSCMessage message) {
				Float messageArguments = (Float) message.getArguments()[0];

				System.out.println("listener called with address " + 
					message.getAddress() + "; arguments: " + 
					messageArguments);
				
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						if (messageEquals(message, "/2/push10")) { 
							if (!Stage1.composite.isDisposed()) {
								Stage1.txtPawsid.setText("mtiger1"); 
								Stage1.txtPassword.setText("********"); 
							}
						}
						//Page 2
						if (messageEquals(message, "/2/push1")) Stage1.loginPressed();
						
						//Page 4
						if (messageEquals(message, "/4/push2")) incrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/4/push3")) decrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/4/push4")) incrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/4/push5")) decrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/4/push6")) incrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/4/push7")) decrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/4/push8")) submitTeam();
					}
				});			
			}
		};
		
		//Add all the components to the listener.
		String[] componentArray = {"/1/push1", "/2/push1", "/2/push10", "/4/push8", "/4/push2", "/4/push3", "/4/push4", "/4/push5", "/4/push6", "/4/push7"};
		for (String comp : componentArray) {
			receiver.addListener(comp, listener);
		}

		System.out.println("Server is listening on port " + receiverPort);
		receiver.startListening();
	}
	
	//checks to see if the message is equal to the conditional string
	public boolean messageEquals(OSCMessage message, String str) {
		Float messageArguments = (Float) message.getArguments()[0];
		
		if (message.getAddress().equals(str) && messageArguments == 1.0)
			return true;
		else
			return false;
	}
	
	//selects the next item up the combo box
	public void incrementComboBox(Combo comboBox) {
		if (comboBox.getSelectionIndex() > 0)
			comboBox.select(comboBox.getSelectionIndex() - 1);
	}
	
	//selects the next item down the combo box
	public void decrementComboBox(Combo comboBox) {
		if (comboBox.getSelectionIndex() < comboBox.getItemCount() - 1)
			comboBox.select(comboBox.getSelectionIndex() + 1);
	}
	
	//passes the selections to where ever
	public static void submitTeam() {
		System.out.println("Event: " + PostTeamComposite.combo.getText() + "\nExperience: " 
				+ PostTeamComposite.combo_1.getText() + "\nMembers needed: " + PostTeamComposite.combo_2.getText());
		//sets combos back to index 0
		PostTeamComposite.combo.select(0); PostTeamComposite.combo_1.select(0); PostTeamComposite.combo_2.select(0);
	}
}
