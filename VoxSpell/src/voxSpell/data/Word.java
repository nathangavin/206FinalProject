package voxSpell.data;

/**
 * this class represents a word. It contains the word, as a string, 
 * and the amount of times the word has been mastered, faulted and failed, as ints.
 * 
 * @author mvan439
 *
 */
public class Word{

	private String _word;
	private int _attempts;
	private int _timesCorrect;
	
	//constructor for a new word without history
	public Word(String word){
		_word = word;
	}
	
	//constructor for a word that has history
	public Word(String word, int attempts, int timesCorrect){
		_word = word;
		_attempts = attempts;
		_timesCorrect = timesCorrect;
	}
	
	//method to increment a mastery value in a word, classes
	//that use this method use the final variables in the AbstractMenu class
	public void increment(int value){
		if(value == 0){
			_attempts += 1;
		} else {
			_timesCorrect += 1;
		}
	}
	
	//method to reset a word's statistics, for the clearStats option
	public void reset(){
		_attempts = 0;
		_timesCorrect = 0;
	}

	//method used by TableValues, to get values for the stats table
	public Object getValueAt(int columnIndex) {
		switch(columnIndex){
		case 0:
			return _word;
		case 1:
			return _attempts;
		case 2:
			return _timesCorrect;
		}
		return 0;
	}
	
	//getter for the word
	public String getWord(){
		return _word;
	}
	
	//toString method used for the save utility
	public String toString(){
		return _word + " " + _attempts + " " + _timesCorrect;
	}

	//override equals used for part of the loading. we only care about the value within the word variable(in this case)
	@Override
	public boolean equals(Object object){
		boolean sameSame = false;
		if (object != null && object instanceof Word){
			sameSame = this._word.equals(((Word) object).getWord());
		}
		return sameSame;
	}
}