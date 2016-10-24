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

import voxSpell.data.UserData;
import voxSpell.data.Users;

public class RewardsScreen extends UserGUIElement {

	private JPanel _previousPanel;
	
	private JLabel _title = new JLabel("Rewards");
	private JLabel _scoreRequired = new JLabel("Score Required: 0");
	
	private JButton _playVideo = new JButton("Play Video Reward");
	private JButton _goBack = new JButton("<");
	
	
	protected RewardsScreen(JFrame frame,Users users, UserData user, JPanel previousPanel) {
		super(frame,users, user);
		
		_previousPanel = previousPanel;
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {60, 540};
		layout.rowHeights = new int[] {60, 60, 100, 100,180};
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 0;
		_goBack.addActionListener(this);
		_goBack.setPreferredSize(new Dimension(50, 50));
		_goBack.setFont(new Font("Garamond", Font.PLAIN, 18));
		add(_goBack, c);
		
		c.gridy = 1;
		c.gridwidth = 2;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title,c);
		
		c.gridy = 3;
		c.anchor = c.NORTH;
		_scoreRequired.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_scoreRequired, c);
		c.anchor = c.CENTER;
		_playVideo.addActionListener(this);
		_playVideo.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_playVideo, c);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(_playVideo)) {
			new VideoScreen(_GUI, _users,_user);
			_GUI.revalidate();
			_GUI.repaint();
			return;
		} else if (e.getSource().equals(_goBack)) {
			_GUI.getContentPane().removeAll();
			_GUI.getContentPane().add(_previousPanel);
			_GUI.revalidate();
			_GUI.repaint();
		}
		
	}

}
