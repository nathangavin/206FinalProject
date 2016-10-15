package voxSpell.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen extends GUIElement {
	
	private JLabel _titlePrimary = new JLabel("Welcome to VoxSpell");
	private JLabel _titleSecondary = new JLabel("The Spelling Aid");
	private JButton _login = new JButton("Login to existing user");
	private JButton _newUser = new JButton("Create new user");

	public TitleScreen(JFrame frame) {
		super(frame);
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {250, 200, 200, 250};
		layout.rowHeights = new int[] {200, 50, 30, 200, 100, 120};
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 4;
		_titlePrimary.setFont(new Font("Garamond", Font.PLAIN, 50));
		add(_titlePrimary, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.weighty = 1;
		c.gridwidth = 2;
		_titleSecondary.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_titleSecondary, c);
		
		c.gridy = 3;
		c.weighty = 0.5;
		c.gridwidth = 1;
		_login.addActionListener(this);
		_login.setPreferredSize(new Dimension(200, 80));
		add(_login, c);
		
		c.gridx = 2;
		_newUser.addActionListener(this);
		_newUser.setPreferredSize(new Dimension(200, 80));
		add(_newUser, c);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		_GUI.getContentPane().removeAll();
		
		if (e.getSource().equals(_login)) {
			_GUI.getContentPane().add(new LoginScreen(_GUI));
		} else {
			_GUI.getContentPane().add(new NewUser(_GUI));
		}
		
		_GUI.revalidate();
		_GUI.repaint();
	}

}
