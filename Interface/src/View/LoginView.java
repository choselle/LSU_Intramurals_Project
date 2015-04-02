package View;
/**
 * @author gregpatrick
 * This interface will represent our system's login/register page
 * Here, returning user's will be asked for their login credentials
 * (username and password. New users will be offered an option to
 * register as a new user.
 */
// Interface imports
import javax.imageio.ImageIO;
import javax.swing.*;

import com.illposed.osc.OSCListener;
import com.illposed.osc.OSCMessage;
import com.illposed.osc.OSCPortIn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;





// MVC imports
import Listeners.LoginAction;
import Listeners.ExitListener;

public class LoginView extends JFrame implements ActionListener {

	// Fields for interface objects
	private static final long serialVersionUID = -9075143494267263385L;
	private static JPanel panel;
	private static JLabel titleLabel, phraseLabel, userLabel, passwordLabel;
	public static JTextField userText;
	public static JPasswordField passwordText;
	public static JButton loginBtn, cancelBtn;
	private static ImageIcon logo, tiger;

	public LoginView() {

		setFrame();
		setContents();
		setListeners();
		setVisible(true);
	}

	// Display interface
	private void setFrame() {

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(121, 8, 196));
		

		this.setTitle("User Login");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 600);
		this.setLocation(100, 100);
		//this.setResizable(false);
		this.getContentPane().add(panel);
		
	}

	// Setup panel inside frame
	private void setContents() {

		// Title label
		titleLabel = new JLabel("Intramural Sports", JLabel.CENTER);
		titleLabel.setForeground(new Color(245, 197, 39));
		titleLabel.setBounds(0, 10, 300, 50);
		titleLabel.setFont(new Font("Arial Black", Font.BOLD, 30));
		panel.add(titleLabel);

		// Phrase label
		phraseLabel = new JLabel("Every Student is an Athlete!", JLabel.CENTER);
		phraseLabel.setFont(new Font("Arial Black", Font.ITALIC, 15));
		phraseLabel.setForeground(new Color(245, 197, 39));
		phraseLabel.setBounds(0, 360, 300, 50);
		panel.add(phraseLabel);

		// Username label
		userLabel = new JLabel("Username");
		userLabel.setForeground(new Color(245, 197, 39));
		userLabel.setBounds(10, 410, 80, 25);
		panel.add(userLabel);

		// Password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(245, 197, 39));
		passwordLabel.setBounds(10, 440, 80, 25);
		panel.add(passwordLabel);

		// Username textfield
		userText = new JTextField(20);
		userText.setBounds(100, 410, 160, 25);
		//userText.setText("miketiger1@lsu.edu");
		panel.add(userText);

		// Password textfield
		passwordText = new JPasswordField();
		passwordText.setBounds(100, 440, 160, 25);
		//passwordText.setText("geauxtigers");
		panel.add(passwordText);

		// Login Button
		loginBtn = new JButton("Login");
		loginBtn.setBounds(100, 480, 80, 25);
		panel.add(loginBtn);

		// Cancel Button
		cancelBtn = new JButton("Cancel");
		cancelBtn.setBounds(180, 480, 80, 25);
		panel.add(cancelBtn);

		// Logo label
		logo = new ImageIcon(this.getClass().getResource("/images/LSUlogo.jpg"));
		JLabel logoLabel = new JLabel(logo, JLabel.CENTER);
		logoLabel.setBounds(0, 490, 300, 100);
		panel.add(logoLabel);

		// Tiger label
		tiger = new ImageIcon(this.getClass().getResource("/images/tiger.png"));
		JLabel tigerLabel = new JLabel(tiger, JLabel.CENTER);
		tigerLabel.setBounds(0, 70, 300, 300);
		panel.add(tigerLabel);
		
	}

	
	private void setListeners() {
		
		loginBtn.addActionListener(new LoginAction(this));
		cancelBtn.addActionListener(new ExitListener(this));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
