package View;

// Swing packages
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

// Action Listeners
//import Listeners.nextMonthAction;
//import Listeners.prevMonthAction;
//import Listeners.pickYearAction;

public class Calendar extends JInternalFrame {

	private static final long serialVersionUID = -9075143494267263385L;
	private static Container pane;
	private static JPanel calPane;
	private static JLabel monthLabel, yearLabel;
	private static JButton prevBtn, nextBtn;
	private static JTable calTbl;
	private static JComboBox<String> pickYear;
	private static DefaultTableModel calMTbl; // Table model
	private static JScrollPane calSTable; // Scroll pane
	private static int day, month, year, currYear, currMonth;

	public Calendar() {

		setFrame();
		setContents();
		setDate();
		formatCalendar();
		setListeners();
		this.setVisible(true);
	}

	private void setFrame() {

		// this.setTitle("Intramural Calendar");
		this.setSize(330, 375); // Calendar size
		this.setResizable(false);
		pane = this.getContentPane(); // may need to consider Container
											// object instead here
		calPane = new JPanel();
		calPane.setLayout(null);
		calPane.setBounds(0, 0, 320, 335);
		calPane.setBorder(BorderFactory.createTitledBorder("Calendar"));
		pane.add(calPane);
	}

	// Add contents to JPanel
	private void setContents() {

		// Month header label
		monthLabel = new JLabel("January");
		monthLabel.setBounds(160 - monthLabel.getPreferredSize().width / 2, 25,
				100, 25);
		calPane.add(monthLabel);

		// Year picker label
		yearLabel = new JLabel("Choose year:");
		yearLabel.setBounds(10, 305, 80, 20);
		calPane.add(yearLabel);

		// Year picker combo box
		pickYear = new JComboBox();
		pickYear.setBounds(230, 305, 80, 20);
		calPane.add(pickYear);

		// Previous month button
		prevBtn = new JButton("<<");
		prevBtn.setBounds(10, 25, 50, 25);
		calPane.add(prevBtn);

		// Next month button
		nextBtn = new JButton(">>");
		nextBtn.setBounds(260, 25, 50, 25);
		calPane.add(nextBtn);

		// Scroll pane for table
		calSTable.setBounds(10, 50, 300, 250);
	}

	// Handles real-time date and time
	private void setDate() {
		GregorianCalendar cal = new GregorianCalendar(); // Create calendar
		day = cal.get(GregorianCalendar.DAY_OF_YEAR); // Get day
		month = cal.get(GregorianCalendar.MONTH); // Get month
		year = cal.get(GregorianCalendar.YEAR); // Get year
		currMonth = month; // Match month
		currYear = year; // Match year
	}

	// Format calendar
	private void formatCalendar() {

		// Column headers
		String[] headers = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (int i = 0; i < 7; i++) {
			calMTbl.addColumn(headers[i]);
		}

		// Disable resizing/reordering
		calTbl.getTableHeader().setResizingAllowed(false);
		calTbl.getTableHeader().setReorderingAllowed(false);

		// Single cell selection
		calTbl.setColumnSelectionAllowed(true);
		calTbl.setRowSelectionAllowed(true);
		calTbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Set row/column count
		calTbl.setRowHeight(38);
		calMTbl.setColumnCount(7);
		calMTbl.setRowCount(6);

		// Populate table
		for (int i = year - 10; i <= year + 10; i++) {
			pickYear.addItem(String.valueOf(i));
		}

		// Refresh table
		refreshCalendar(month, year); // Refresh calendar

	}
	
	// Set ActionListeners
	private void setListeners() {
		prevBtn.addActionListener(new prevMonthAction());
		nextBtn.addActionListener(new nextMonthAction());
		pickYear.addActionListener(new pickYearAction());
	}
	
	private void refreshCalendar(int m, int y) {
		// Placeholder vars
		String[] months = { "January", "February", "March", "April", "May",
				"June", "July", "August", "September", "October", "November",
				"December" };
		int numDays, startMonth; // Number of days & Start of month

		// Allow/disallow buttons
		prevBtn.setEnabled(true);
		nextBtn.setEnabled(true);

		if (m == 0 && y <= year - 10) {
			prevBtn.setEnabled(false);
		}

		if (m == 11 && y >= year + 10) {
			nextBtn.setEnabled(false);
		}

		// Update month label
		monthLabel.setText(months[m]);

		// Re-align label with calendar
		monthLabel.setBounds(160 - monthLabel.getPreferredSize().width / 2, 25,
				180, 25);

		// Select year in combo box
		pickYear.setSelectedItem(String.valueOf(y));

		// Clear table
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 7; j++) {
				calMTbl.setValueAt(null, i, j);
			}

		}

		// Get first day of month and number of days
		GregorianCalendar cal = new GregorianCalendar(year, month, 1);
		numDays = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		startMonth = cal.get(GregorianCalendar.DAY_OF_WEEK);

		// Draw calendar
		for (int i = 1; i <= numDays; i++) {
			int row = new Integer((i + startMonth - 2) / 7);
			int column = (i + startMonth - 2) % 7;
			calMTbl.setValueAt(i, row, column);
		}

		// Apply renderers
		calTbl.setDefaultRenderer(calTbl.getColumnClass(0),
				new tblCalendarRenderer());
	}
	

	// Calendar Renderer object
	public class tblCalendarRenderer extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean selected, boolean focused, int row,
				int column) {
			super.getTableCellRendererComponent(table, value, selected,
					focused, row, column);
			if (column == 0 || column == 6) { // Week-end
				setBackground(new Color(255, 220, 220));
			} else { // Week
				setBackground(new Color(255, 255, 255));
			}
			if (value != null) {
				if (Integer.parseInt(value.toString()) == day
						&& currMonth == month && currYear == year) { // Today
					setBackground(new Color(220, 220, 255));
				}
			}
			setBorder(null);
			setForeground(Color.black);
			return this;
		}
	}
	
	// Previous month ActionListener
	public class prevMonthAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (currMonth == 0) { //Back one year
				currMonth = 11;
				currYear -= 1;
			}
			else{ //Back one month
				currMonth -= 1;
			}
			refreshCalendar(currMonth, currYear);
		}
	}
	
	// Next month ActionListener
	public class nextMonthAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (currMonth == 11) { //Foward one year
				currMonth = 0;
				currYear += 1;
			}
			else{ //Foward one month
				currMonth += 1;
			}
			refreshCalendar(currMonth, currYear);
		}
	}
	
	// Year picker ActionListener
	public class pickYearAction implements ActionListener {
		public void actionPerformed (ActionEvent e) {
			if (pickYear.getSelectedItem() != null) {
				String b = pickYear.getSelectedItem().toString();
				currYear = Integer.parseInt(b);
				refreshCalendar(currMonth, currYear);
			}
		}
	}
}
	


