package voxSpell.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

//import GUI.Data.DataStore;



public abstract class GUIElement extends JPanel implements ActionListener {

	protected JFrame _GUI;
	//protected DataStore _data;
	
	protected GUIElement(JFrame frame /*, DataStore data */) {
		
		super();
		_GUI = frame;
		//_data = data;
			
	}
	

}