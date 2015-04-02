package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class ProfileViewComposite extends Composite {

	static PostProfileComposite ppc;
	static PostTeamComposite ptc;

	// Protected Shell shell;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public ProfileViewComposite(Composite parent, int style) {
		super(parent, style);
		setBackground(SWTResourceManager.getColor(70, 29, 124));
		setBounds(10, 1072, 1920, 1080);

		Label lblProfilePic = new Label(this, SWT.NONE);
		lblProfilePic.setImage(SWTResourceManager.getImage(ProfileViewComposite.class, "/images/tiger.png"));
		lblProfilePic.setBounds(10, 69, 481, 557);

		Button btnPostFreeAgent = new Button(this, SWT.NONE);
		btnPostFreeAgent.setFont(SWTResourceManager.getFont("Segoe UI", 22, SWT.NORMAL));
		btnPostFreeAgent.setBounds(10, 677, 481, 53);
		btnPostFreeAgent.setText("Register as Free Agent");
		btnPostFreeAgent.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PostProfilePressed();
			}
		});

		Button btnPostTeam = new Button(this, SWT.NONE);
		btnPostTeam.setText("Post Team");
		btnPostTeam.setFont(SWTResourceManager.getFont("Segoe UI", 22, SWT.NORMAL));
		btnPostTeam.setBounds(10, 736, 481, 53);

		ToolBar toolBar = new ToolBar(this, SWT.FLAT | SWT.RIGHT);
		toolBar.setFont(SWTResourceManager.getFont("Moire ExtraBold", 28, SWT.BOLD));
		toolBar.setToolTipText("");
		toolBar.setBackground(SWTResourceManager.getColor(SWT.COLOR_GRAY));
		toolBar.setBounds(10, 10, 1846, 53);

		ToolItem tltmWelcomeMike = new ToolItem(toolBar, SWT.NONE);
		tltmWelcomeMike.setText("Welcome, Mike!");

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 22, SWT.BOLD));
		lblNewLabel_1.setBounds(10, 632, 481, 39);
		lblNewLabel_1.setText("Mike the Tiger");

		Label lblWins = new Label(this, SWT.NONE);
		lblWins.setAlignment(SWT.CENTER);
		lblWins.setFont(SWTResourceManager.getFont("Moire ExtraBold", 55, SWT.BOLD));
		lblWins.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblWins.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblWins.setBounds(518, 69, 406, 178);
		lblWins.setText("WINS\n5");

		Label lblLosses = new Label(this, SWT.NONE);
		lblLosses.setAlignment(SWT.CENTER);
		lblLosses.setText("LOSSES\n2");
		lblLosses.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblLosses.setFont(SWTResourceManager.getFont("Moire ExtraBold", 55, SWT.BOLD));
		lblLosses.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblLosses.setBounds(986, 69, 406, 178);

		Label lblTies = new Label(this, SWT.NONE);
		lblTies.setAlignment(SWT.CENTER);
		lblTies.setText("TIES\n3");
		lblTies.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblTies.setFont(SWTResourceManager.getFont("Moire ExtraBold", 55, SWT.BOLD));
		lblTies.setBackground(SWTResourceManager.getColor(255, 255, 255));
		lblTies.setBounds(1450, 69, 406, 178);

		Label lblLogo = new Label(this, SWT.NONE);
		lblLogo.setAlignment(SWT.CENTER);
		lblLogo.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblLogo.setImage(SWTResourceManager.getImage(ProfileViewComposite.class, "/images/tiger3.png"));
		lblLogo.setBounds(10, 854, 481, 185);

		Label lblHeader = new Label(this, SWT.NONE);
		lblHeader.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblHeader.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblHeader.setFont(SWTResourceManager.getFont("Moire ExtraBold", 42, SWT.BOLD));
		lblHeader.setAlignment(SWT.CENTER);
		lblHeader.setBounds(530, 274, 654, 76);
		lblHeader.setText("Last Match");

		Label lblUpcoming = new Label(this, SWT.NONE);
		lblUpcoming.setAlignment(SWT.CENTER);
		lblUpcoming.setFont(SWTResourceManager.getFont("Moire ExtraBold", 24, SWT.BOLD));
		lblUpcoming.setBackground(SWTResourceManager.getColor(230, 230, 250));
		lblUpcoming.setText("3v3 Basketball vs \nWhite Men Can't Jump\n\nW   65 - 43\n\nMon 30th March 2015\nUREC Court 1");
		lblUpcoming.setBounds(518, 356, 666, 287);

		Label lblLastMatch = new Label(this, SWT.NONE);
		lblLastMatch.setAlignment(SWT.CENTER);
		lblLastMatch.setText(" 7v7 Flag Football vs \nGrid Iron Goons\n\n0 - 0\n\nFri 3rd April\nUREC Field 2");
		lblLastMatch.setFont(SWTResourceManager.getFont("Moire ExtraBold", 24, SWT.BOLD));
		lblLastMatch.setBackground(SWTResourceManager.getColor(230, 230, 250));
		lblLastMatch.setBounds(1190, 356, 666, 287);

		Label lblNextMatch = new Label(this, SWT.NONE);
		lblNextMatch.setText("Upcoming Match");
		lblNextMatch.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNextMatch.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNextMatch.setFont(SWTResourceManager.getFont("Moire ExtraBold", 42, SWT.BOLD));
		lblNextMatch.setAlignment(SWT.CENTER);
		lblNextMatch.setBounds(1172, 274, 654, 76);

		Button lblFindPlayers = new Button(this, SWT.NONE);
		lblFindPlayers.setText("Find Free Agents");
		lblFindPlayers.setFont(SWTResourceManager.getFont("Segoe UI", 22, SWT.NORMAL));
		lblFindPlayers.setBounds(10, 795, 481, 53);

		Label lblNewsHeader = new Label(this, SWT.NONE);
		lblNewsHeader.setAlignment(SWT.CENTER);
		lblNewsHeader.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewsHeader.setFont(SWTResourceManager.getFont("Moire ExtraBold", 42, SWT.BOLD));
		lblNewsHeader.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewsHeader.setBounds(968, 661, 444, 60);
		lblNewsHeader.setText("UREC News");

		Label lblNews = new Label(this, SWT.NONE);
		lblNews.setFont(SWTResourceManager.getFont("Moire ExtraBold", 24, SWT.BOLD));
		lblNews.setForeground(SWTResourceManager.getColor(0, 0, 0));
		lblNews.setBackground(SWTResourceManager.getColor(230, 230, 250));
		lblNews.setBounds(518, 727, 1338, 312);
		lblNews.setText("28              UREC hours to be modified over Spring Break -\nMAR          These changes will commence on Friday 6th.\n\n  1              Pool will be closed due to UREC expansion work.\nAPR           Lap swimming will now take place in the Natatorium.\n\n  3             10 ways to keep fit while over-endulging over Spring Break!\nAPR");

		btnPostTeam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				PostTeamPressed();
			}
		});
	}

	public static void PostProfilePressed() {
		if (!(ppc != null)) {
			ppc = new PostProfileComposite(Stage1.shell, SWT.NONE);
			ppc.setBounds(10, 1072, 1884, 1039);
		}
		else {
			ppc.setVisible(true);
		}

		Stage1.pvc.setVisible(false);
	}

	public static void PostTeamPressed() {
		if (!(ptc != null)) {
			ptc = new PostTeamComposite(Stage1.shell, SWT.NONE);
			ptc.setBounds(10, 1072, 1884, 1039);
		}
		else {
			ptc.setVisible(true);
		}

		Stage1.pvc.setVisible(false);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}