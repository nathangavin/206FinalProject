package voxSpell.GUI;

import javax.swing.JFrame;

import voxSpell.data.UserData;
import voxSpell.data.Users;

public abstract class UserGUIElement extends GUIElement {

	protected UserData _user;
	
	protected UserGUIElement(JFrame frame, Users users, UserData user) {
		super(frame, users);
		_user = user;
	}

}
