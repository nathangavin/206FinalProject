package voxSpell.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import voxSpell.data.UserData;
import voxSpell.data.Users;

public class UserMenu extends UserGUIElement {

	private UserData _user;

	private JLabel _title;
	private JLabel _score;
	private JButton _quiz = new JButton("New Spelling Quiz");
	private JButton _review = new JButton("Review Mistakes");
	private JButton _stats = new JButton("View Statistics");
	private JButton _importFile = new JButton("Import New Topic");
	private JButton _rewards = new JButton("View Rewards");
	private JButton _returnToTitle = new JButton("<");

	protected UserMenu(JFrame frame, UserData user) {
		super(frame, user);
		_user = user;

		_title = new JLabel("Welcome, "+_user.getName());
		_score = new JLabel("Score: "+_user.getScore());
		
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {150, 300, 150};
		layout.rowHeights = new int[] {50, 70, 70, 70, 70, 70, 70, 30};
		
		setLayout(layout);
		GridBagConstraints c = new GridBagConstraints();
		c.weighty = 0.5;
		c.weightx = 0.5;
		
		c.gridx = 2;
		c.gridy = 0;
		_score.setFont(new Font("Garamond", Font.BOLD, 14));
		add(_score, c);
		
		c.gridx = 0;
		_returnToTitle.setFont(new Font("Garamond", Font.BOLD, 25));
		_returnToTitle.setPreferredSize(new Dimension(60, 40));
		_returnToTitle.addActionListener(this);
		add(_returnToTitle, c);

		c.gridy = 1;
		c.gridwidth = 3;
		c.anchor = c.NORTH;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title, c);

		c.anchor = c.CENTER;

		
		JButton[] buttons = new JButton[] {_quiz, _review, _rewards, _stats, _importFile};
		for (int i = 0; i < buttons.length; i++) {
			JButton current = buttons[i];
			c.gridy = i + 2;
			current.addActionListener(this);
			current.setPreferredSize(new Dimension(180,30));
			add(current,c);
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object source = e.getSource();
		_GUI.getContentPane().removeAll();

		if (source.equals(_quiz)) {
			_GUI.getContentPane().add(new LevelSelect(_GUI, _user));
		} else if (source.equals(_review)) {
			//_GUI.getContentPane().add(new TestScreen(_GUI, _users, _data.getMistakes().returnCopyOfList(), true));
		} else if (source.equals(_stats)) {
			_GUI.getContentPane().add(new StatsScreen(_GUI, _user));
		} else if (source.equals(_returnToTitle)) {
			_GUI.getContentPane().add(new TitleScreen(_GUI, new Users()));
		}

		_GUI.revalidate();
		_GUI.repaint();

	}

}
