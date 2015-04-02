package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.LoginView;
import View.ProfileView;

public class LoginAction implements ActionListener {

	private LoginView login_view;
	private ProfileView profile_view;
	
	public LoginAction(LoginView view) {
	
		login_view = view;
		System.out.println("Logging in");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// create profile view
		System.out.println("Welcome to your profile");
		profile_view = new ProfileView();
		login_view.setVisible(false);
		// profile_view.setController(login_view.getController());
		 profile_view.setVisible(true);
		
		
	}

}
