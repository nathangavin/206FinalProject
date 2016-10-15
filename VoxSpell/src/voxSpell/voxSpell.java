package voxSpell;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import voxSpell.GUI.TitleScreen;

public class voxSpell extends JFrame {

	public voxSpell() {
		super("VoxSpell - Spelling Aid");
		
		
		//_data = new DataStore();
			
		setSize(900, 700);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);	
		add(new TitleScreen(this));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//_data.writeDataToFile();
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
