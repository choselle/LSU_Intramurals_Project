package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class PostProfile {
	
	private JComboBox sportsDropdown;
	private JComboBox expDropdown;
	private JDialog dialog;
	private JFrame frame;
	private JLabel expLabel;
	private JLabel nameLabel;
	private JLabel sportLabel;
	private JLabel titleLabel;
	private JTextArea comments;
	private JTextField nameField;
	private JOptionPane optionPane;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostProfile window = new PostProfile();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PostProfile() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 768, 1024);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(70, 29, 124));
		panel.setBounds(0, 0, 768, 783);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		titleLabel = new JLabel("Post My Profile\n");
		titleLabel.setBounds(0, 5, 768, 50);
		titleLabel.setFont(new Font("Verdana", Font.BOLD, 40));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(new Color(255, 215, 0));
		panel.add(titleLabel);
		
		nameLabel = new JLabel("Name/Paws ID\n");
		nameLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		nameLabel.setForeground(new Color(255, 215, 0));
		nameLabel.setBounds(80, 96, 230, 30);
		panel.add(nameLabel);
		
		nameField = new JTextField();
		nameField.setBounds(77, 143, 580, 39);
		panel.add(nameField);
		nameField.setColumns(10);
		
		sportLabel = new JLabel("Sport\n");
		sportLabel.setForeground(new Color(255, 215, 0));
		sportLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		sportLabel.setBounds(80, 218, 180, 30);
		panel.add(sportLabel);
		
		String[] sports = {"5v5 Basketball", "Softball", "Flag Football", "Ultimate Frisbee", "Tennis", "6v6 Soccer", "Volleyball","Racquetball"};
		sportsDropdown = new JComboBox(sports);
		sportsDropdown.setBackground(new Color(255, 215, 0));
		sportsDropdown.setBounds(80, 263, 574, 39);
		sportsDropdown.setSelectedIndex(-1);
		panel.add(sportsDropdown);
		
		expLabel = new JLabel("Experience");
		expLabel.setForeground(new Color(255, 215, 0));
		expLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		expLabel.setBounds(80, 336, 180, 39);
		panel.add(expLabel);
		
		String[] leagues = {"Freshman","Sophomore","Junior","Senior"};
		expDropdown = new JComboBox(leagues);
		expDropdown.setBackground(new Color(255, 215, 0));
		expDropdown.setBounds(80, 387, 574, 39);
		expDropdown.setSelectedIndex(-1);
		panel.add(expDropdown);
		
		JLabel commentsLabel = new JLabel("Notes/Comments");
		commentsLabel.setForeground(new Color(255, 215, 0));
		commentsLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		commentsLabel.setBounds(80, 470, 259, 37);
		panel.add(commentsLabel);		
		
		comments = new JTextArea();
		comments.setLineWrap(true);
		comments.setBounds(80, 532, 572, 135);
		panel.add(comments);
		
		JButton postButton = new JButton("Post Profile");
		postButton.setFont(new Font("Verdana", Font.PLAIN, 24));
		postButton.setBounds(80, 707, 585, 50);
		postButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {						
				JButton post = new JButton("Post");
				JButton cancel = new JButton("Cancel");
				JButton[] buttons = {post, cancel};
				optionPane = new JOptionPane("Name/Paws ID: " + nameField.getText() + "\nSport: " + sportsDropdown.getSelectedItem().toString()
						+ "\nExperience: " + expDropdown.getSelectedItem().toString() + "\nComments: " 
						+ comments.getText(),JOptionPane.QUESTION_MESSAGE,JOptionPane.YES_NO_CANCEL_OPTION,null,buttons,buttons[0]);
				cancel.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.setVisible(false);
					}					
				});
				post.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent e) {
						nameField.setText(null);
						sportsDropdown.setSelectedItem(null);
						expDropdown.setSelectedItem(null);
						comments.setText(null);
						dialog.setVisible(false);
					}					
				});
				
				dialog = new JDialog(frame,"Confirmation", true);
				dialog.setContentPane(optionPane);
				dialog.pack();
				dialog.setVisible(true);		
			}
		});
		panel.add(postButton);		
	}
}
