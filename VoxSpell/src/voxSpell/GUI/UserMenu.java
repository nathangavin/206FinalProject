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

	private JLabel _title = new JLabel("Main Menu");
	private JButton _quiz = new JButton("New Spelling Quiz");
	private JButton _review = new JButton("Review Mistakes");
	private JButton _stats = new JButton("View Statistics");
	private JButton _importFile = new JButton("Import New Topic");

	protected UserMenu(JFrame frame, UserData user) {
		super(frame, user);
		_user = user;

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.weighty = 0.5;

		c.gridx = 0;
		c.gridy = 0;
		_title.setFont(new Font("Garamond", Font.PLAIN, 30));
		add(_title, c);

		JButton[] buttons = new JButton[] {_quiz, _review, _stats, _importFile};
		for (int i = 0; i < buttons.length; i++) {
			JButton current = buttons[i];
			c.gridy = i + 1;
			current.addActionListener(this);
			current.setPreferredSize(new Dimension(200,50));
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
			_GUI.getContentPane().add(new TestScreen(_GUI, _users, _data.getMistakes().returnCopyOfList(), true));
		} else if (source.equals(_stats)) {
			_GUI.getContentPane().add(new StatsScreen(_GUI, _user));
		}

		_GUI.revalidate();
		_GUI.repaint();

	}

}
