package voxSpell.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewUser extends GUIElement {
	
	private JLabel _title = new JLabel("New User");
	private JLabel _name = new JLabel("Username:");
	private JTextField _input = new JTextField("Enter Username Here    ");
	private JButton _createUser = new JButton("Create User");
	private JLabel _warning = new JLabel("Please enter a username");

	public NewUser(JFrame frame) {
		super(frame);
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {430, 470};
		layout.rowHeights = new int[] {170, 40, 50, 50, 30, 30, 40, 290};
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title, c);
		
		c.gridy = 3;
		c.gridwidth = 1;
		c.weightx = 1;
		c.anchor = c.EAST;
		add(_name, c);
		
		c.gridx = 1;
		c.weightx = 0;
		c.anchor = c.WEST;
		_input.addFocusListener(new FocusListener() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (_input.getText().equals("Enter Username Here    ")) {
					_input.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (_input.getText().equals("")) {
					_input.setText("Enter Username Here    ");
				}
			}
		});
		add(_input, c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		c.anchor = c.CENTER;
		_createUser.addActionListener(this);
		add(_createUser, c);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (_input.getText().equals("") || _input.getText().equals("Enter Username Here")) {
			
		}
	}

}
