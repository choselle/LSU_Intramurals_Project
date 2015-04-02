package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import App.OSCServer;

public class PostTeamComposite extends Composite {

	public static Combo combo;
	public static Combo combo_1;
	public static Combo combo_2;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public PostTeamComposite(Composite parent, int style) {
		super(parent, SWT.NONE);
		setBackground(SWTResourceManager.getColor(70, 29, 124));
		setSize(1920, 1080);

		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewLabel.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setFont(SWTResourceManager.getFont("Moire ExtraBold", 32, SWT.BOLD));
		lblNewLabel.setBounds(603, 10, 704, 55);
		lblNewLabel.setText("Post My Team");

		Button btnBack = new Button(this, SWT.NONE);
		btnBack.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		btnBack.setBounds(992, 785, 216, 91);
		btnBack.setText("Back ");
		btnBack.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				backButtonPressed();
			}
		});

		Button btnSubmitTeam = new Button(this, SWT.NONE);
		btnSubmitTeam.setFont(SWTResourceManager.getFont("Segoe UI", 24, SWT.NORMAL));
		btnSubmitTeam.setBounds(727, 785, 216, 91);
		btnSubmitTeam.setText("Submit");
		btnSubmitTeam.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				OSCServer.submitTeam();
			}
		});

		combo = new Combo(this, SWT.NONE);
		combo.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.NORMAL));
		combo.setForeground(SWTResourceManager.getColor(70, 29, 124));
		combo.setBackground(SWTResourceManager.getColor(253, 208, 35));
		combo.setItems(new String[] { "", "Football", "Softball", "Basketball", "Raquetball", "Soccer" });
		combo.setBounds(10, 291, 615, 55);

		combo_1 = new Combo(this, SWT.NONE);
		combo_1.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.NORMAL));
		combo_1.setItems(new String[] { "", "Division 1", "Division 2", "Division 3" });
		combo_1.setBounds(1356, 482, 537, 55);
		combo_1.setForeground(SWTResourceManager.getColor(70, 29, 124));
		combo_1.setBackground(SWTResourceManager.getColor(253, 208, 35));

		combo_2 = new Combo(this, SWT.NONE);
		combo_2.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.NORMAL));
		combo_2.setItems(new String[] { "", "1", "2", "3", "4", "5", "6", "7", "8" });
		combo_2.setBounds(10, 482, 615, 55);
		combo_2.setForeground(SWTResourceManager.getColor(70, 29, 124));
		combo_2.setBackground(SWTResourceManager.getColor(253, 208, 35));

		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setBounds(10, 244, 615, 41);
		lblNewLabel_1.setText("Event:");
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewLabel_1.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));

		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setBounds(1356, 435, 537, 41);
		lblNewLabel_2.setText("Experience:");
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewLabel_2.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));

		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setBounds(10, 435, 615, 41);
		lblNewLabel_3.setText("Members needed:");
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(253, 208, 35));
		lblNewLabel_3.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("Moire ExtraBold", 26, SWT.BOLD));

		Label lblNewLabel_6 = new Label(this, SWT.NONE);
		lblNewLabel_6.setBounds(686, 146, 568, 504);
		lblNewLabel_6.setBackground(SWTResourceManager.getColor(70, 29, 124));
		lblNewLabel_6.setImage(SWTResourceManager.getImage(PostTeamComposite.class, "/images/eye.gif"));
	}

	public static void backButtonPressed() {
		ProfileViewComposite.ptc.setVisible(false);
		Stage1.pvc.setVisible(true);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}