package View;
/**
 * @author gregpatrick
 * This interface will represent our system user's profile
 * page. Here the user will be able to view all of the
 * information view all of the updated info regarding what
 * teams they are part of, their team's last result and
 * upcoming fixtures.
 */
import javax.imageio.ImageIO;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

// MVC imports
// import View.Calendar;
// import Listeners.LogoutAction;
// import Listeners.PostTeam;
// import Listeners.SearchTeams;
// import Listeners.FindFreeAgents

public class ProfileView extends JFrame {

	// Fields for interface objects
	private static final long serialVersionUID = -9075143494267263385L;
	private static JPanel profile, urecNews, intraCalendar;
	private static JTabbedPane tPane;
	private static JMenuBar toolBar;
	private static JMenu home, teams, connect;
	private static JLabel name, wins, draws, losses, winNum, drawNum, lossNum;
	private static JButton prevMonth, nextMonth; 
	private static JMenuItem editProfile, events, logout, help;
	private static JMenuItem myTeams, joinTeam, postTeam, findPlayers;
	private static JMenuItem findFriends, messenger;
	private static ImageIcon profilePic, urecPic;
	
	public ProfileView() {
		
		setFrame();
		setTabs();
		setToolBar();	
		setProfile();
	//	setContents();
		setVisible(true);
			
		
	}
	
	private void setFrame() {
		
		profile = new JPanel();
		profile.setLayout(null);
		profile.setBackground(new Color(121, 8, 196));
		
		this.setTitle("LSU Intramurals: Welcome, Mike!");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(100, 10);
		this.setSize(750, 700);
		this.setResizable(false);
		this.getContentPane().add(profile);
	}
	
	private void setTabs() {
		tPane = new JTabbedPane();
		tPane.setBounds(0, 300, 750, 330);
		profile.add(tPane, BorderLayout.CENTER);
		
		// UREC news tab
		urecNews = new JPanel();
		urecNews.setLayout(null);
		tPane.addTab("UREC News", urecNews);
		
		// Intramural Calendar tab
		intraCalendar = new JPanel();
		intraCalendar.setLayout(null);
		tPane.addTab("Calendar", intraCalendar);
		
		// Fill Calendar tab
//		prevMonth = new JButton("Previous");
//		intraCalendar.add(prevMonth);
		
	}
	
	private void setToolBar() {
		toolBar = new JMenuBar();
		
		// Toolbar options
		home = new JMenu("Mike");
		teams = new JMenu("Teams");
		connect = new JMenu("Connect");
		toolBar.add(home);
		toolBar.add(teams);
		toolBar.add(connect);
		
		// Home tool options
		editProfile = new JMenuItem("Edit Profile");
		events = new JMenuItem("Events");
		logout = new JMenuItem("Log Out");
		help = new JMenuItem("Help");
		home.add(editProfile);
		home.add(events);
		home.add(logout);
		home.add(help);
		
		// Teams tool options
		myTeams = new JMenuItem("myTeams");
		joinTeam = new JMenuItem("Join Team", KeyEvent.VK_J);
		postTeam = new JMenuItem("Post Team", KeyEvent.VK_P);
		findPlayers = new JMenuItem("Free Agents", KeyEvent.VK_F);
		teams.add(myTeams);
		teams.add(joinTeam);
		teams.add(postTeam);
		teams.add(findPlayers);
		
		// Connect options
		findFriends = new JMenuItem("Find Friends");
		messenger = new JMenuItem("Messenger");
		connect.add(findFriends);
		connect.add(messenger);
		
		// this.addtoolBar
		this.setJMenuBar(toolBar);
	}
	
	private void setProfile() {
		
		// Display a profile picture for the user
		profilePic = new ImageIcon(this.getClass().getResource("/images/mikethetiger.png"));
		JLabel profPicLabel = new JLabel(profilePic, JLabel.CENTER);
		profPicLabel.setBounds(10, 10, 200, 250);
		Border border = BorderFactory.createLineBorder(Color.WHITE, 3);
		profPicLabel.setBorder(border);
		profile.add(profPicLabel);
		
		// Display a lsu urec logo
		urecPic = new ImageIcon(this.getClass().getResource("/images/LSUlogo2.png"));
		JLabel urecLogoLabel = new JLabel(urecPic, JLabel.CENTER);		
		urecLogoLabel.setBounds(290, 585, 200, 100);
		profile.add(urecLogoLabel);
		
		// Name label
		name = new JLabel("Mike The Tiger");
		name.setFont(new Font("Arial Black", Font.BOLD, 17));
		name.setForeground(Color.YELLOW);
		name.setBounds(40, 250, 150, 50 );
		profile.add(name);	
		profile.add(name);
		
		// Wins labels
		wins = new JLabel("WINS");
		wins.setFont(new Font("Times New Roman", Font.BOLD, 17));
		wins.setBackground(Color.WHITE);
		wins.setBounds(250, 10, 150, 50);
		profile.add(wins);
	}

}
