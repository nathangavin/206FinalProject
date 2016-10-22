package voxSpell.GUI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import voxSpell.Exceptions.NoSuchTopicException;
import voxSpell.Exceptions.NoSuchWordListException;
import voxSpell.data.Topic;
import voxSpell.data.UserData;
import voxSpell.data.WordList;

public class LevelSelect extends UserGUIElement {
	
	private JComboBox<String> _topics;
	private JComboBox<String> _levels = new JComboBox<String>();
	private JLabel _title = new JLabel("Level Select");
	private JButton _selectTopic = new JButton("Select");
	private JButton _selectLevel = new JButton("Begin Level");
	private JButton _goBack = new JButton("<");
	private JLabel _topicLabel = new JLabel("Topics:");
	private JLabel _levelLabel = new JLabel("Levels:");
	
	private Topic _topic = null;
	

	protected LevelSelect(JFrame frame, UserData user) {
		super(frame, user);
		
		_topics = new JComboBox<String>(user.getTopicNames());
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {60, 240, 300};
		layout.rowHeights = new int[] {60, 100, 60, 60, 60, 160};
		setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		c.weighty = 0.5;
		
		c.gridx = 0;
		c.gridy = 0;
		_goBack.addActionListener(this);
		add(_goBack, c);
		
		c.gridy = 1;
		c.gridwidth = 3;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title, c);
		
		c.gridy = 2;
		c.gridwidth = 2;
		c.anchor = c.EAST;
		_topicLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_topicLabel, c);
		
		c.gridx = 2;
		c.gridwidth = 1;
		c.anchor = c.WEST;
		_topics.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_topics, c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridwidth = 3;
		c.anchor = c.CENTER;
		_selectTopic.addActionListener(this);
		_selectTopic.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_selectTopic, c);
		
		c.gridy = 4;
		c.gridwidth = 2;
		c.anchor = c.EAST;
		_levelLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_levelLabel, c);
		
		c.gridx = 2;
		c.gridwidth = 1;
		c.anchor = c.WEST;
		_levels.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_levels, c);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 3;
		c.anchor = c.CENTER;
		_selectLevel.addActionListener(this);
		_selectLevel.setFont(new Font("Garamond", Font.PLAIN, 20));
		add(_selectLevel, c);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(_selectTopic)) {
			try {
				_topic = _user.getTopic(_topics.getSelectedItem().toString());
			} catch (NoSuchTopicException e1) {
				e1.printStackTrace();
			}
			_levels = new JComboBox<String>(_topic.getNamesOfLists());
		} else if (e.getSource().equals(_selectLevel)) {
			if (_topic.equals(null)) {
				JOptionPane.showMessageDialog(this, "Please Select a Topic to choose a level from.");
			} else {
				WordList list = null;
				try {
					list = _topic.getList(_levels.getSelectedItem().toString());
				} catch (NoSuchWordListException e1) {
					e1.printStackTrace();
				}
				
				_GUI.removeAll();
				_GUI.getContentPane().add(new TestScreen(_GUI, _user, list));
			}
		} else if (e.getSource().equals(_goBack)) {
			_GUI.removeAll();
			_GUI.getContentPane().add(new UserMenu(_GUI, _user));
		}
		
		_GUI.revalidate();
		_GUI.repaint();
	}

}
