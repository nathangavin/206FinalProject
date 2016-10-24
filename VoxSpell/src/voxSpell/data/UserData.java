package voxSpell.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import voxSpell.Exceptions.NoSuchTopicException;
import voxSpell.Exceptions.WrongFileFormatException;

public class UserData {

	private String _name = "";
	private ArrayList<Topic> _topics = new ArrayList<Topic>();
	private ArrayList<Integer> _scores = new ArrayList<Integer>();
	private int _score = 0;
	private WordList _mistakes = new WordList("mistakes");
	private String _festivalPath;

	public UserData(String userName) {
		_name = userName;
		readFile();
		writeToFile();
	}

	public void addTopic(Topic topic) {
		_topics.add(topic);
	}

	public void addToScore(int number) {
		_score += number;
	}
	
	public void addAScore(int score) {
		_scores.add(score);
	}
	
	public ArrayList<Integer> getScores() {
		return _scores;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public void addToMistakes(Word word) { 
		if (!doesListContainWord(word, _mistakes)) {
			_mistakes.add(word);
		}
	}

	private boolean doesListContainWord(Word word, WordList list) {
		for (Word var : list.getWords()) {
			if (var.getWord().equals(word.getWord())) {
				return true;
			}
		}
		return false;
	}
	
	public int getScore() {
		return _score;
	}
	
	public WordList getMistakes() {
		return _mistakes;
	}

	public Topic getTopic(String topicName) throws NoSuchTopicException {
		for (Topic x : _topics) {
			if (topicName.equals(x.getName())) {
				return x;
			}
		}

		throw new NoSuchTopicException();
	}

	private void readFile() {
		String fileName = "." + _name + ".Data";
		File f = new File(fileName);
		if (f.isFile()) {
			Scanner file = null;
			try {
				file = new Scanner(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			if (file.hasNextLine()) {				
				String score = file.nextLine();
				_score = Integer.parseInt(score);
				
				
				WordList var1 = _mistakes;
				file.nextLine();
				
				Topic var = null;
				
				while (file.hasNextLine()) {
					String line = file.nextLine();
					if (line.startsWith("@")) {
						var = new Topic(line.substring(1));
						addTopic(var);
					} else if (line.startsWith("%")) {
						var1 = new WordList(line.substring(1));
						var.addWordList(var1);
						var1.createScores(file.nextLine());
					} else {
						var1.addWordFromString(line);
					}
				}
			}

			file.close();
		} else {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}

	public void writeToFile() {
		String fileName = "."+_name+".Data";
		File file = new File(fileName);
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}


		String scoreString = "" + _score;
		addToFile(scoreString);
		addToFile("%mistakes");
		for (Word var : _mistakes.getWords()) {
			addToFile(var.toString());
		}
		
		for (Topic var : _topics) {
			addToFile("@"+var.getName());
			for (WordList var1 : var.getLists()) {
				addToFile("%"+var1.getName());
				addToFile(var1.printScores());
				for (Word var2 : var1.getWords()) {
					addToFile(var2.toString());
				}
			}
		}
	}

	private void addToFile(String word) {
		String fileName = "." + _name + ".Data";
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

	public String[] getTopicNames() {
		String[] names = new String[_topics.size()];
		for (int i = 0; i < _topics.size(); i++) {
			names[i] = _topics.get(i).getName();
		}
		return names;
	}
	
	private void locateFestival() {
		
		File file = new File(".save");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c","which festival > '" + file.getAbsolutePath() + "'");
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String line = scan.nextLine();
		_festivalPath = line;
		
		scan.close();
		file.delete();
		
	}
	
	public String getFestival() {
		return _festivalPath;
	}
}
