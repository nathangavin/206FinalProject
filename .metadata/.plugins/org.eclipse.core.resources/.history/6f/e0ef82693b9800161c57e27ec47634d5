package voxSpell.data;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Topic {

	private String _name = "";
	private ArrayList<WordList> _wordLists = new ArrayList<WordList>();
	private String _currentLevel;
	private WordList _mistakes = new WordList("mistakes");

	public Topic() {
		
	}
	
	public Topic(String name) {
		_name = name;
	}
	
	private void readFromFile(String fileName) {
		File file = new File(fileName);
		if (file.isFile()) {
			Scanner scanFile = null;
			try {
				scanFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			WordList var = new WordList(scanFile.nextLine().substring(1));
			
			while (scanFile.hasNextLine()) {
				String line = scanFile.nextLine();
				if (line.startsWith("%")) {
					_wordLists.add(var);
					var = new WordList(line.substring(1));
				} else {
					var.add(new Word(line));
				}
			}
					
		}
	}
	
	public void addWordList(WordList list) {
		_wordLists.add(list);
	}
	
	public void addMistakesList(WordList mistakes) { 
		_mistakes = mistakes;
	}
	
	public void setName(String name) {
		_name = name;
	}
	

	/** This method checks whether there is already a WordList object
	 *  in the _wordlists field with a name matching the String parameter. 
	 */
	private boolean doesListExist(String listName) {
		for (WordList var : _wordLists) {
			if (var.getName().equals(listName)) {
				return true;
			}
		}
		return false;
	}

	/** This method gets a WordList object matching the name of the 
	 *  String parameter.
	 *  returns null if no list is stored.
	 */
	public WordList getList(String listName) {
		for (WordList var : _wordLists) {
			if (var.getName().equals(listName)) {
				return var;
			}
		}
		return null;
	}

	/** This method returns an array of Strings representing the level names 
	 */
	public String[] getNamesOfLists() {
		String[] names = new String[_wordLists.size()];
		int i = 0;
		for (WordList var : _wordLists) {
			names[i] = var.getName();
			i++;
		}
		return names;
	}

	/** This method gets the Wordlist representing the words failed
	 */
	public WordList getMistakes() {
		return _mistakes;
	}
	
	
	/**This method adds a string on a new line to a file
	 */
	private void addToFile(String word, String fileName) {
		String newLine = System.getProperty("line.separator");
		String line = word + newLine;

		try {
			BufferedWriter file = new BufferedWriter(new FileWriter(fileName, true));
			file.write(line);
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/** This method sets the value of _currentLevel 
	 */
	public void setCurrentLevel(String level) {
		_currentLevel = level;
	}

	/** This method returns the WordList of _currentLevel 
	 */
	public String getCurrentLevelName() {
		return _currentLevel;
	}


	/** This method returns the name of the level above 
	 *  current level.
	 */
	public String getNextLevelName() {
		String[] names = getNamesOfLists();
		for (int i = 0; i < names.length; i++) {
			if (names[i].equals(_currentLevel)) {
				return names[i+1];
			}
		}
		return names[0];
	}

	public void writeToFile(String fileName) {
		addToFile("@"+_name, fileName);
		addToFile(_currentLevel, fileName);
		for (Word var : _mistakes.getWords()) {
			addToFile(var.toString(), fileName);
		}
		for (WordList var : _wordLists) {
			addToFile("%"+var.getName(), fileName);
			for (Word var1 : var.getWords()) {
				addToFile(var1.toString(), fileName);
			}
		}
	}

	
}

