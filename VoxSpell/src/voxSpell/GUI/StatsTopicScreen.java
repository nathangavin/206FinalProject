package voxSpell.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import voxSpell.Exceptions.NoSuchTopicException;
import voxSpell.data.Topic;
import voxSpell.data.UserData;
import voxSpell.data.Users;

public class StatsTopicScreen extends UserGUIElement {

	private JPanel _previousScreen;
	private JLabel _title = new JLabel("Select A Topic To View");
	private JComboBox<String> _options;
	private JButton _select = new JButton("Select");
	private JButton _goBack = new JButton("<");
	
	
	protected StatsTopicScreen(JFrame frame, Users users, UserData user, JPanel previousScreen) {
		super(frame, users, user);
		
		_previousScreen = previousScreen;
		
		_options = new JComboBox<String>(_user.getTopicNames());
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {60, 540};
		layout.rowHeights = new int[] {60, 100, 100, 100, 140};
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
		
		c.gridy = 2;
		_options.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_options,c);
		
		c.gridy = 3;
		_select.setFont(new Font("Garamond", Font.PLAIN, 20));
		_select.addActionListener(this);
		add(_select, c);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(_goBack)) {
			_GUI.getContentPane().removeAll();
			_GUI.getContentPane().add(_previousScreen);
			_GUI.revalidate();
			_GUI.repaint();
		} else {
			Topic selectedTopic = null;
			try {
				selectedTopic = _user.getTopic(_options.getSelectedItem().toString());
			} catch (NoSuchTopicException e1) {
				e1.printStackTrace();
			}
			_GUI.getContentPane().removeAll();
			_GUI.getContentPane().add(new StatsScreen(_GUI, _users, _user, _previousScreen, selectedTopic));
		}

	}

}
