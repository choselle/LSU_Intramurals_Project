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
			public void acceptMessage(java.util.Date time, final OSCMessage message) {
				Float messageArguments = (Float) message.getArguments()[0];

				System.out.println("listener called with address " + 
					message.getAddress() + "; arguments: " + 
					messageArguments);
				
				Display.getDefault().syncExec(new Runnable() {
					public void run() {
						//Page1
						if (messageEquals(message, "/1/push1")) { 
							if (!Stage1.composite.isDisposed()) {
								Stage1.txtPawsid.setText("mtiger1"); 
								Stage1.txtPassword.setText("********"); 
							}
						}
						if (messageEquals(message, "/1/push2")) Stage1.loginPressed();
						//Page 2
						if (messageEquals(message, "/2/push3")) ProfileViewComposite.PostProfilePressed();
						if (messageEquals(message, "/2/push4")) ProfileViewComposite.PostTeamPressed();
						//Page 3
						if (messageEquals(message, "/3/push5")) incrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/3/push6")) decrementComboBox(PostProfileComposite.combo);
						if (messageEquals(message, "/3/push7")) incrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/3/push8")) decrementComboBox(PostProfileComposite.combo_1);
						if (messageEquals(message, "/3/push11")) submitProfile();
						if (messageEquals(message, "/3/push12")) PostProfileComposite.backButtonPressed();
						//Page 4
						if (messageEquals(message, "/4/push13")) incrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/4/push14")) decrementComboBox(PostTeamComposite.combo);
						if (messageEquals(message, "/4/push15")) incrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/4/push16")) decrementComboBox(PostTeamComposite.combo_1);
						if (messageEquals(message, "/4/push17")) incrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/4/push18")) decrementComboBox(PostTeamComposite.combo_2);
						if (messageEquals(message, "/4/push19")) submitTeam();
						if (messageEquals(message, "/4/push20")) PostTeamComposite.backButtonPressed();
					}
				});			
			}
		};
		
		//Add all the components to the listener.
		String[] componentArray = {"/1/push1", "/1/push2", "/2/push3", "/2/push4", "/3/push5", "/3/push6", "/3/push7", "/3/push8", "/3/push11", "/3/push12", "/4/push13", "/4/push14", "/4/push15", 
				"/4/push16", "/4/push17", "/4/push18", "/4/push19", "/4/push20"};
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
		if (!comboBox.isDisposed()) {
			if (comboBox.getSelectionIndex() > 0)
				comboBox.select(comboBox.getSelectionIndex() - 1);
		}
	}
	
	//selects the next item down the combo box
	public void decrementComboBox(Combo comboBox) {
		if (!comboBox.isDisposed()) {
			if (comboBox.getSelectionIndex() < comboBox.getItemCount() - 1)
				comboBox.select(comboBox.getSelectionIndex() + 1);
		}
	}
	
	//passes the selections to where ever
	public static void submitTeam() {
		System.out.println("Event: " + PostTeamComposite.combo.getText() + "\nExperience: " 
				+ PostTeamComposite.combo_1.getText() + "\nMembers needed: " + PostTeamComposite.combo_2.getText());
		//sets combos back to index 0
		PostTeamComposite.combo.select(0); PostTeamComposite.combo_1.select(0); PostTeamComposite.combo_2.select(0);
	}
	
	public static void submitProfile() {
		System.out.println("Sport: " + PostProfileComposite.combo.getText() + "\nExperience: " 
				+ PostProfileComposite.combo_1.getText());
		//sets combos back to index 0
		PostProfileComposite.combo.select(0); PostProfileComposite.combo_1.select(0);
	}
}
