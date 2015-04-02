package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.illposed.osc.*;
import javax.swing.ImageIcon;


public class PostTeam extends JFrame {

	private JPanel contentPane;
	private JLabel lblNamepawsid;
	private JLabel lblEvent;
	private JLabel lblExperience;
	private JLabel lblTotalNeeded;
	public JButton btnNewButton;
	public JComboBox<?> comboBox;
	public JComboBox<?> comboBox_1;
	public JComboBox<?> comboBox_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws java.net.SocketException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostTeam postTeam = new PostTeam();
					postTeam.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void clearTextFields(Container container) {

		for (Component c : container.getComponents()) {
			if (c instanceof JComboBox) {
				JComboBox f = (JComboBox) c;
				f.setSelectedIndex(0);
			} 
			else if (c instanceof Container)
				clearTextFields((Container)c);
		 }
	}
	
	/**
	 * Create the frame.
	 */
	public PostTeam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 1024);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(70, 29, 124));
		contentPane.setForeground(new Color(70, 29, 124));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(70, 29, 124));
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		
		
		btnNewButton = new JButton("SAVE TEAM");
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, -135, SpringLayout.SOUTH, panel);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 26));
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -87, SpringLayout.SOUTH, panel);
		btnNewButton.setForeground(new Color(70, 29, 124));
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 34, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.EAST, panel);
		btnNewButton.setBackground(new Color(253, 208, 35));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Event: " + comboBox.getSelectedItem().toString() + "\nExperience: " + comboBox_2.getSelectedItem().toString()
						+ "\nTotal Needed: " + comboBox_1.getSelectedItem().toString());
				clearTextFields(contentPane);
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Post My Group");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 45, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 150, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel, 93, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel, -132, SpringLayout.EAST, panel);
		lblNewLabel.setForeground(new Color(253, 208, 35));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 46));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		lblNamepawsid = new JLabel("Name/PawsID");
		sl_panel.putConstraint(SpringLayout.WEST, lblNamepawsid, 34, SpringLayout.WEST, panel);
		lblNamepawsid.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNamepawsid.setForeground(new Color(253, 208, 35));
		panel.add(lblNamepawsid);
		
		lblEvent = new JLabel("Event");
		sl_panel.putConstraint(SpringLayout.NORTH, lblEvent, 0, SpringLayout.NORTH, lblNamepawsid);
		sl_panel.putConstraint(SpringLayout.EAST, lblEvent, -34, SpringLayout.EAST, panel);
		lblEvent.setFont(new Font("Dialog", Font.BOLD, 26));
		lblEvent.setForeground(new Color(253, 208, 35));
		panel.add(lblEvent);
		
		lblExperience = new JLabel("Experience");
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNamepawsid, -87, SpringLayout.NORTH, lblExperience);
		sl_panel.putConstraint(SpringLayout.WEST, lblExperience, 34, SpringLayout.WEST, panel);
		lblExperience.setFont(new Font("Dialog", Font.BOLD, 26));
		lblExperience.setForeground(new Color(253, 208, 35));
		panel.add(lblExperience);
		
		lblTotalNeeded = new JLabel("Total Needed");
		sl_panel.putConstraint(SpringLayout.NORTH, lblTotalNeeded, 0, SpringLayout.NORTH, lblExperience);
		sl_panel.putConstraint(SpringLayout.EAST, lblTotalNeeded, -28, SpringLayout.EAST, panel);
		lblTotalNeeded.setFont(new Font("Dialog", Font.BOLD, 26));
		lblTotalNeeded.setForeground(new Color(253, 208, 35));
		panel.add(lblTotalNeeded);
		
		comboBox = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox, 8, SpringLayout.SOUTH, lblEvent);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox, -292, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox, 45, SpringLayout.SOUTH, lblEvent);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox, -28, SpringLayout.EAST, panel);
		comboBox.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox.setForeground(new Color(70, 29, 124));
		comboBox.setBackground(new Color(253, 208, 35));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Football", "Basketball", "Baseball", "Raquetball", "Squash"}));
		panel.add(comboBox);
		
		comboBox_1 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 6, SpringLayout.SOUTH, lblTotalNeeded);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, -292, SpringLayout.EAST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, 43, SpringLayout.SOUTH, lblTotalNeeded);
		comboBox_1.setFont(new Font("Dialog", Font.BOLD, 18));
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -28, SpringLayout.EAST, panel);
		comboBox_1.setForeground(new Color(70, 29, 124));
		comboBox_1.setBackground(new Color(253, 208, 35));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8"}));
		panel.add(comboBox_1);
		
		comboBox_2 = new JComboBox();
		sl_panel.putConstraint(SpringLayout.SOUTH, lblExperience, -6, SpringLayout.NORTH, comboBox_2);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_2, -106, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_2, -143, SpringLayout.NORTH, btnNewButton);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_2, 298, SpringLayout.WEST, panel);
		comboBox_2.setFont(new Font("Dialog", Font.BOLD, 18));
		comboBox_2.setForeground(new Color(70, 29, 124));
		comboBox_2.setBackground(new Color(253, 208, 35));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Division 1", "Division 2", "Division 3"}));
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_2, 34, SpringLayout.WEST, panel);
		panel.add(comboBox_2);
		
		ImageIcon tiger = new ImageIcon(this.getClass().getResource("/images/eye.gif"));
		JLabel lblNewLabel_1 = new JLabel(tiger, JLabel.CENTER);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 11, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 110, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -6, SpringLayout.NORTH, lblNamepawsid);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_1, -81, SpringLayout.EAST, panel);
		panel.add(lblNewLabel_1);
		
		
	}
}