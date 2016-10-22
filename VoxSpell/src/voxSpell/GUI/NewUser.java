package voxSpell.GUI;

import java.awt.Color;
import java.awt.Dimension;
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

import voxSpell.data.UserData;
import voxSpell.data.Users;

public class NewUser extends AdminGUIElement {
	
	private JLabel _title = new JLabel("New User");
	private JLabel _name = new JLabel("Username:");
	private JTextField _input = new JTextField("Enter Username Here ");
	private JButton _createUser = new JButton("Create User");
	private JLabel _warning = new JLabel("Please enter a valid username");
	private JButton _goBack = new JButton("go back");

	public NewUser(JFrame frame, Users users) {
		super(frame, users);
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {133, 154, 180, 133};
		layout.rowHeights = new int[] {121, 28, 36, 36, 21, 21, 29, 207};
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title, c);
		
		c.gridy = 3;
		c.gridx = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.anchor = c.EAST;
		add(_name, c);
		
		c.gridx = 2;
		c.weightx = 0;
		c.anchor = c.WEST;
		_input.setMinimumSize(new Dimension(180, 30));
		_input.addFocusListener(new FocusListener() {
			public void focusGained(java.awt.event.FocusEvent evt) {
				if (_input.getText().equals("Enter Username Here ")) {
					_input.setText("");
				}
			}
			public void focusLost(FocusEvent e) {
				if (_input.getText().equals("")) {
					_input.setText("Enter Username Here ");
				}
			}
		});
		add(_input, c);
		
		c.gridx = 1;
		c.gridy = 6;
		c.anchor = c.CENTER;
		c.ipadx = 30;
		_goBack.addActionListener(this);
		add(_goBack, c);
		
		c.gridx = 2;
		_createUser.addActionListener(this);
		add(_createUser, c);
		
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth = 2;
		_warning.setOpaque(true);
		_warning.setBackground(Color.RED);
		_warning.setForeground(Color.WHITE);
		add(_warning, c);
		_warning.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(_goBack)) {
			_GUI.getContentPane().removeAll();
			_GUI.add(new TitleScreen(_GUI, _users));
			_GUI.revalidate();
			_GUI.repaint();
			return;
		} else if (e.getSource().equals(_createUser)) {
			if (_input.getText().equals("") || _input.getText().equals("Enter Username Here ")) {
				_warning.setVisible(true);
			} else {
				UserData user = new UserData(_input.getText());
				_users.addAUser(user);
				_GUI.getContentPane().removeAll();
				_GUI.add(new UserMenu(_GUI, user));
			}
			_GUI.revalidate();
			_GUI.repaint();
		}
		
		
	}

}
