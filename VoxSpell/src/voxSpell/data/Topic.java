package voxSpell.data;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import voxSpell.Exceptions.NoSuchWordListException;
import voxSpell.Exceptions.WrongFileFormatException;

public class Topic {

	private String _name = "";
	private ArrayList<WordList> _wordLists = new ArrayList<WordList>();

	public Topic(String name) {
		_name = name;
	}
	
	public Topic() throws WrongFileFormatException {
		_name = "NZCER-spelling-lists";
		readFromFile("NZCER-spelling-lists.txt");
	}

	public String getName() {
		return _name;
	}
	
	public void readFromFile(String fileName) throws WrongFileFormatException {
		File file = new File(fileName);
		if (file.isFile()) {
			Scanner scanFile = null;
			try {
				scanFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			if (!scanFile.hasNextLine()) {
				throw new WrongFileFormatException();
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
			
			_wordLists.add(var);
					
		}
	}
	
	public void addWordList(WordList list) {
		_wordLists.add(list);
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public ArrayList<WordList> getLists() {
		return _wordLists;
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
	 * @throws NoSuchWordListException 
	 */
	public WordList getList(String listName) throws NoSuchWordListException {
		for (WordList var : _wordLists) {
			if (var.getName().equals(listName)) {
				return var;
			}
		}
		throw new NoSuchWordListException();
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


	

	
}

