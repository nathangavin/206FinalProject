package voxSpell.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import voxSpell.data.Users;

//import GUI.Data.DataStore;



public abstract class GUIElement extends JPanel implements ActionListener {

	protected JFrame _GUI;
	
	protected GUIElement(JFrame frame) {
		
		super();
		_GUI = frame;
		
		this.setBackground(new Color(31, 173, 255));
			
	}
	

}