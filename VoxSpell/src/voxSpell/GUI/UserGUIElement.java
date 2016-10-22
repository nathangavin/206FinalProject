package voxSpell.GUI;

import javax.swing.JFrame;

import voxSpell.data.UserData;

public abstract class UserGUIElement extends GUIElement {

	protected UserData _user;
	
	protected UserGUIElement(JFrame frame, UserData user) {
		super(frame);
		_user = user;
	}

}
