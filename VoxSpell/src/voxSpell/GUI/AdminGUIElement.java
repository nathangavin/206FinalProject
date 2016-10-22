package voxSpell.GUI;

import javax.swing.JFrame;

import voxSpell.data.Users;

public abstract class AdminGUIElement extends GUIElement {

	protected Users _users;
	
	protected AdminGUIElement(JFrame frame, Users users) {
		super(frame);
		_users = users;
	}

}
