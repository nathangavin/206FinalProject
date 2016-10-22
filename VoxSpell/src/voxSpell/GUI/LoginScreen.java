package voxSpell.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import voxSpell.Exceptions.NoSuchUserException;
import voxSpell.data.UserData;
import voxSpell.data.Users;

public class LoginScreen extends AdminGUIElement {
	
	private JComboBox<String> _userSelector;
	private JButton _goBack = new JButton("<");
	private JButton _select = new JButton("Select");
	private JLabel _title = new JLabel("Select a User");

	protected LoginScreen(JFrame frame, Users users) {
		super(frame, users);
		_userSelector = new JComboBox<String>(_users.getUserNames());
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {133, 166, 166, 133};
		layout.rowHeights = new int[] {160, 50, 30, 40, 30, 50, 140};
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		_title.setFont(new Font("Garamond", Font.PLAIN, 40));
		add(_title, c);
		
		c.gridx = 1;
		c.gridy = 3;
		c.gridwidth = 2;
		_userSelector.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_userSelector, c);
		
		c.gridy = 5;
		c.gridwidth = 1;
		_goBack.setFont(new Font("Garamond", Font.BOLD, 20));
		_goBack.addActionListener(this);
		add(_goBack, c);
		
		c.gridx = 2;
		_select.setFont(new Font("Garamond", Font.PLAIN, 20));
		_select.addActionListener(this);
		add(_select, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		_GUI.getContentPane().removeAll();
		if (e.getSource().equals(_goBack)) {
			_GUI.add(new TitleScreen(_GUI, _users));
		} else {
			String user = _userSelector.getSelectedItem().toString();
			UserData userData = null;
			try {
				userData = _users.getAUser(user);
			} catch (NoSuchUserException e1) {
				e1.printStackTrace();
			}
			_GUI.add(new UserMenu(_GUI, userData));
		}
		_GUI.revalidate();
		_GUI.repaint();
	}

}
