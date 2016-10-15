package voxSpell.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitleScreen extends GUIElement {
	
	private JLabel _titlePrimary = new JLabel("Welcome to VoxSpell!");
	private JLabel _titleSecondary = new JLabel("The Spelling Aid");
	private JButton _login = new JButton("Login to existing user");
	private JButton _newUser = new JButton("Create new user");

	public TitleScreen(JFrame frame) {
		super(frame);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 4;
		_titlePrimary.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_titlePrimary, c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.weighty = 1;
		c.gridwidth = 2;
		_titleSecondary.setFont(new Font("Garamond", Font.PLAIN, 14));
		add(_titleSecondary, c);
		
		c.gridy = 2;
		c.weighty = 0.5;
		c.gridwidth = 1;
		_login.addActionListener(this);
		add(_login, c);
		
		c.gridx = 2;
		_newUser.addActionListener(this);
		add(_newUser, c);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
