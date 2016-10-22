package voxSpell;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import voxSpell.GUI.TitleScreen;
import voxSpell.data.Users;

public class voxSpell extends JFrame {
	
	private Users _users;

	public voxSpell() {
		super("VoxSpell - Spelling Aid");
		
		_users = new Users();
			
		setSize(600, 500);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		add(new TitleScreen(this, _users));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				_users.writeToFile();
				System.exit(0);
			}
		});
		
	}

	public static void main(String[] args) {
		
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				JFrame frame = new voxSpell();
				frame.setVisible(true);
			}
		});
		
		
		
	}
	
}
