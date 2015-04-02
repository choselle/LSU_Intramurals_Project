package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class PostProfileComposite extends Composite {
	private final Text nameField;
	public static Combo combo, combo_1;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public PostProfileComposite(Composite parent, int style) {
		super(parent, style);
		setSize(1920, 1080);
		setBackground(SWTResourceManager.getColor(75, 0, 130));

		Label title = new Label(this, SWT.NONE);
		title.setBounds(0, 10, 1920, 95);
		title.setAlignment(SWT.CENTER);
		title.setFont(SWTResourceManager.getFont("Verdana", 60, SWT.BOLD));
		title.setForeground(SWTResourceManager.getColor(253, 208, 35));
		title.setBackground(SWTResourceManager.getColor(70, 29, 124));
		title.setText("Post Your Profile!\n");

		Label nameLabel = new Label(this, SWT.NONE);
		nameLabel.setBounds(109, 111, 412, 44);
		nameLabel.setForeground(SWTResourceManager.getColor(253, 208, 35));
		nameLabel.setBackground(SWTResourceManager.getColor(70, 29, 124));
		nameLabel.setFont(SWTResourceManager.getFont("Verdana", 30, SWT.BOLD));
		nameLabel.setText("Name/Paws ID");

		nameField = new Text(this, SWT.BORDER);
		nameField.setFont(SWTResourceManager.getFont("Verdana", 26, SWT.BOLD));
		nameField.setBounds(112, 182, 1707, 44);
		nameField.setText("mike1");
		nameField.setForeground(SWTResourceManager.getColor(70, 29, 124));
		nameField.setBackground(SWTResourceManager.getColor(253, 208, 35));

		Label sportLabel = new Label(this, SWT.NONE);
		sportLabel.setBounds(110, 333, 138, 44);
		sportLabel.setText("Sport");
		sportLabel.setForeground(SWTResourceManager.getColor(253, 208, 35));
		sportLabel.setBackground(SWTResourceManager.getColor(70, 29, 124));
		sportLabel.setFont(SWTResourceManager.getFont("Verdana", 30, SWT.BOLD));
		String[] sports = { "5v5 Basketball", "Softball", "Flag Football", "Ultimate Frisbee", "Tennis", "6v6 Soccer", "Volleyball", "Racquetball" };

		Label expLabel = new Label(this, SWT.NONE);
		expLabel.setBounds(109, 561, 259, 44);
		expLabel.setText("Experience\n");
		expLabel.setForeground(SWTResourceManager.getColor(253, 208, 35));
		expLabel.setBackground(SWTResourceManager.getColor(70, 29, 124));
		expLabel.setFont(SWTResourceManager.getFont("Verdana", 30, SWT.BOLD));
		String[] leagues = { "Freshman", "Sophomore", "Junior", "Senior" };

		Button postButton = new Button(this, SWT.NONE);
		postButton.setFont(SWTResourceManager.getFont("Verdana", 30, SWT.BOLD));
		postButton.setBounds(508, 916, 344, 70);
		postButton.setText("Post Profile");

		combo = new Combo(this, SWT.NONE);
		combo.setItems(new String[] { "", "Football", "Basketball", "Soccer", "Softball", "Raquetball" });
		combo.setForeground(SWTResourceManager.getColor(70, 29, 124));
		combo.setBackground(SWTResourceManager.getColor(253, 208, 35));
		combo.setFont(SWTResourceManager.getFont("Verdana", 26, SWT.BOLD));
		combo.setBounds(109, 383, 1710, 23);

		combo_1 = new Combo(this, SWT.NONE);
		combo_1.setForeground(SWTResourceManager.getColor(70, 29, 124));
		combo_1.setBackground(SWTResourceManager.getColor(253, 208, 35));
		combo_1.setItems(new String[] { "", "Division 1", "Division 2", "Division 3" });
		combo_1.setFont(SWTResourceManager.getFont("Verdana", 26, SWT.BOLD));
		combo_1.setBounds(109, 611, 1710, 23);

		Button btnNewButton = new Button(this, SWT.NONE);
		btnNewButton.setFont(SWTResourceManager.getFont("Verdana", 30, SWT.BOLD));
		btnNewButton.setBounds(1108, 916, 344, 70);
		btnNewButton.setText("Back");

		postButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});

		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				backButtonPressed();
			}
		});
	}

	public static void backButtonPressed() {
		ProfileViewComposite.ppc.setVisible(false);
		Stage1.pvc.setVisible(true);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}