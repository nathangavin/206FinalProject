package voxSpell.data;

import java.util.ArrayList;

public class UserData {

	private String _name = "";
	private ArrayList<Topic> _topics = new ArrayList<Topic>();
	private int _score = 0;
	
	
	
	
	public void addToScore(int number) {
		_score += number;
	}
	
}
