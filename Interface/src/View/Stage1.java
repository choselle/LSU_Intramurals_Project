package View;

import java.awt.EventQueue;
import java.net.SocketException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Stage1 {

	public static Shell shell;
	private Text txtIntramural;
	private Label lblNewLabel;

	private Text txtUpcomingEvents;
	private Table table;
	private TableItem tableItem;
	private TableColumn tblclmnNewColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableColumn tblclmnNewColumn_4;
	private TableColumn tblclmnNewColumn_5;
	private TableColumn tblclmnNewColumn_6;
	private TableColumn tblclmnNewColumn_7;
	private TableColumn tblclmnNewColumn_8;
	private Text txtTeamOpenings;
	private Table table_2;
	private TableColumn tbl2clmnNewColumn_1;
	private TableColumn tbl2clmnNewColumn_2;
	private TableColumn tbl2clmnNewColumn_3;
	private TableColumn tbl2clmnNewColumn_4;
	private TableColumn tbl2clmnNewColumn_5;
	private TableItem table2Item;
	private Text txtFreeAgents;
	private Text txtTeamOpenings_1;
	private TableItem table2Item1;
	public static Composite composite;

	public static Button btnLogin;

	private Label lblNewLabel_2;
	private Label lblNewLabel_3;
	public static Text txtPawsid;
	public static Text txtPassword;
	private Label lblPawsid;
	private Label lblPassword;

	static ProfileViewComposite pvc;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	public static void main(String[] args) throws java.net.SocketException {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Stage1 s1 = new Stage1();
					s1.open();
					// s1.launchOSServer();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void open() throws SocketException {

		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(1920, 2160);
		shell.setText("SWT Application");

		String header = "INTRAMURAL\nTEAM FINDER";

		String[] table2Header = new String[] { "Event Type", "Name/PAWSID", "Experience", "Time", "Openings" };

		txtIntramural = new Text(shell, SWT.WRAP);
		txtIntramural.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		txtIntramural.setEditable(false);
		txtIntramural.setFont(SWTResourceManager.getFont("Moire ExtraBold", 70, SWT.BOLD));
		txtIntramural.setText(header);
		txtIntramural.setBounds(1025, 10, 869, 286);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setImage(SWTResourceManager.getImage(Stage1.class, "/images/7943_lsu_tigers-wordmark-2002.png"));
		lblNewLabel.setBounds(10, 10, 748, 363);

		txtUpcomingEvents = new Text(shell, SWT.NONE);
		txtUpcomingEvents.setText("UPCOMING EVENTS");
		txtUpcomingEvents.setFont(SWTResourceManager.getFont("Moire ExtraBold", 48, SWT.BOLD));
		txtUpcomingEvents.setEditable(false);
		txtUpcomingEvents.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		txtUpcomingEvents.setBounds(1025, 292, 869, 81);

		table = new Table(shell, SWT.BORDER | SWT.MULTI);
		table.setFont(SWTResourceManager.getFont("Moire ExtraBold", 9, SWT.BOLD));

		table.addListener(SWT.MeasureItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// height cannot be per row so simply set
				event.height = 150;
			}
		});

		table.setBounds(10, 417, 1884, 170);
		table.setLinesVisible(true);

		tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(320);

		tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(320);

		tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(320);

		tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(320);

		tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(320);

		tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(320);

		tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(320);

		tblclmnNewColumn_8 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_8.setWidth(320);

		String[] tableText = new String[] { " Flag Football \n      3/31/15 \n        4-5pm", "  Basketball \n     3/31/15 \n        6-7pm",
				"  Basketball \n     3/31/15 \n        7-8pm", "    Baseball \n     4/1/15 \n        4-5pm",
				"  Basketball \n     4/1/15 \n        7-8pm", "  Basketball \n     4/2/15 \n        3-4pm",
				"  Basketball \n     4/2/15 \n        4-5pm", "  Basketball \n     4/2/15 \n        6-7pm" };

		tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText(tableText);
		tableItem.setFont(SWTResourceManager.getFont("Moire ExtraBold", 30, SWT.BOLD));
		tableItem.setBackground(0, SWTResourceManager.getColor(164, 143, 196));
		tableItem.setBackground(2, SWTResourceManager.getColor(164, 143, 196));
		tableItem.setBackground(4, SWTResourceManager.getColor(164, 143, 196));
		tableItem.setBackground(6, SWTResourceManager.getColor(164, 143, 196));

		txtTeamOpenings = new Text(shell, SWT.NONE);
		txtTeamOpenings.setText("RECENT POSTINGS");
		txtTeamOpenings.setFont(SWTResourceManager.getFont("Moire ExtraBold", 48, SWT.BOLD));
		txtTeamOpenings.setEditable(false);
		txtTeamOpenings.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		txtTeamOpenings.setBounds(1025, 635, 869, 77);

		table_2 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_2.setLinesVisible(true);
		table_2.setBounds(10, 716, 1884, 260);

		table_2.addListener(SWT.MeasureItem, new Listener() {
			@Override
			public void handleEvent(Event event) {
				// height cannot be per row so simply set
				event.height = 50;
			}
		});

		tbl2clmnNewColumn_1 = new TableColumn(table_2, SWT.NONE);
		tbl2clmnNewColumn_1.setWidth(400);
		tbl2clmnNewColumn_1.setText("Event Type");

		tbl2clmnNewColumn_2 = new TableColumn(table_2, SWT.NONE);
		tbl2clmnNewColumn_2.setWidth(500);
		tbl2clmnNewColumn_2.setText("Name/PAWSID");

		tbl2clmnNewColumn_3 = new TableColumn(table_2, SWT.NONE);
		tbl2clmnNewColumn_3.setWidth(400);
		tbl2clmnNewColumn_3.setText("Experience");

		tbl2clmnNewColumn_4 = new TableColumn(table_2, SWT.NONE);
		tbl2clmnNewColumn_4.setWidth(275);
		tbl2clmnNewColumn_4.setText("Time");

		tbl2clmnNewColumn_5 = new TableColumn(table_2, SWT.NONE);
		tbl2clmnNewColumn_5.setWidth(300);
		tbl2clmnNewColumn_5.setText("Openings");

		table2Item = new TableItem(table_2, SWT.NONE);
		table2Item.setText(table2Header);
		table2Item.setFont(SWTResourceManager.getFont("Moire ExtraBold", 34, SWT.BOLD));

		txtFreeAgents = new Text(shell, SWT.BORDER);
		txtFreeAgents.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		txtFreeAgents.setText("Free Agents");
		txtFreeAgents.setEditable(false);
		txtFreeAgents.setBounds(10, 644, 262, 54);
		txtFreeAgents.setBackground(SWTResourceManager.getColor(253, 208, 35));

		txtTeamOpenings_1 = new Text(shell, SWT.BORDER);
		txtTeamOpenings_1.setText("Team Openings");
		txtTeamOpenings_1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		txtTeamOpenings_1.setEditable(false);
		txtTeamOpenings_1.setBounds(301, 644, 327, 54);
		txtTeamOpenings_1.setBackground(SWTResourceManager.getColor(164, 143, 196));

		String[] posting = new String[] { "BASKETBALL", "MIKE / " + "\n" + "MTIGER1", "SENIOR", "3 min ago", "4" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(164, 143, 196));

		posting = new String[] { "FOOTBALL", "JAMES / " + "\n" + "JJOHNS3", "SOPHMORE", "10 min ago" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		posting = new String[] { "FOOTBALL", "TOM / " + "\n" + "TSMITH7", "JUNIOR", "13 min ago", "6" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(164, 143, 196));

		posting = new String[] { "BASKETBALL", "RICK / " + "\n" + "RJAMES8", "SENIOR", "16 min ago" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		posting = new String[] { "BASKETBALL", "SAM / " + "\n" + "SHARD1", "FRESHMAN", "18 min ago" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		posting = new String[] { "BASEBALL", "ROGER / " + "\n" + "RMCULL", "JUNIOR", "22 min ago" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		posting = new String[] { "BASKETBALL", "MARK / " + "\n" + "MMAKE1", "SENIOR", "27 min ago", "1" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(164, 143, 196));

		posting = new String[] { "BASKETBALL", "JOHN / " + "\n" + "JDOE24", "SENIOR", "29 min ago", "0" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(164, 143, 196));

		posting = new String[] { "BASEBALL", "MARCUS / " + "\n" + "MDOE32", "SENIOR", "33 min ago" };
		table2Item1 = new TableItem(table_2, SWT.NONE);
		table2Item1.setText(posting);
		table2Item1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));
		table2Item1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		// ---------------------------------------------------------------------
		composite = new Composite(shell, SWT.NONE);
		composite.setTouchEnabled(true);
		composite.setBackground(SWTResourceManager.getColor(121, 8, 196));
		composite.setBounds(10, 1072, 1884, 1039);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(121, 8, 196));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 48, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 10, 1864, 77);
		lblNewLabel_1.setText("Intramural Sports");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(245, 197, 39));

		lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setBounds(695, 93, 520, 512);
		lblNewLabel_2.setImage(SWTResourceManager.getImage(Stage1.class, "/images/tiger.png"));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(121, 8, 196));

		lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setAlignment(SWT.CENTER);
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		lblNewLabel_3.setBounds(10, 631, 1864, 45);
		lblNewLabel_3.setText("Every Student is an Athlete!");
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(245, 197, 39));
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(121, 8, 196));

		txtPawsid = new Text(composite, SWT.BORDER);
		txtPawsid.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtPawsid.setBounds(970, 710, 245, 45);

		txtPassword = new Text(composite, SWT.BORDER);
		txtPassword.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		txtPassword.setBounds(970, 761, 245, 45);

		lblPawsid = new Label(composite, SWT.NONE);
		lblPawsid.setText("PAWSID:");
		lblPawsid.setForeground(SWTResourceManager.getColor(245, 197, 39));
		lblPawsid.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		lblPawsid.setBackground(SWTResourceManager.getColor(121, 8, 196));
		lblPawsid.setAlignment(SWT.CENTER);
		lblPawsid.setBounds(722, 710, 221, 45);

		lblPassword = new Label(composite, SWT.NONE);
		lblPassword.setText("password: ");
		lblPassword.setForeground(SWTResourceManager.getColor(245, 197, 39));
		lblPassword.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		lblPassword.setBackground(SWTResourceManager.getColor(121, 8, 196));
		lblPassword.setAlignment(SWT.CENTER);
		lblPassword.setBounds(722, 761, 221, 43);

		btnLogin = new Button(composite, SWT.NONE);
		btnLogin.setFont(SWTResourceManager.getFont("Segoe UI", 28, SWT.NORMAL));
		btnLogin.setBounds(793, 835, 165, 60);
		btnLogin.setText("Login");
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				loginPressed();
			}
		});

		Button btnCancel = new Button(composite, SWT.NONE);
		btnCancel.setFont(SWTResourceManager.getFont("Segoe UI", 28, SWT.NORMAL));
		btnCancel.setText("Cancel");
		btnCancel.setBounds(970, 835, 165, 60);
	}

	public static void loginPressed() {
		if (!composite.isDisposed()) {
			composite.dispose();
			pvc = new ProfileViewComposite(shell, SWT.NONE);
			pvc.setBounds(10, 1072, 1884, 1039);
		}
	}
}