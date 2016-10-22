package voxSpell.GUI;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;

import voxSpell.data.UserData;
import voxSpell.data.WordList;

public class TestScreen extends UserGUIElement {

	private WordList _list;
	
	protected TestScreen(JFrame frame, UserData user, WordList list) {
		super(frame, user);
		_list = list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
