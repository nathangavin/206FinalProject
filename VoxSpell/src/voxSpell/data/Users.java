package voxSpell.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import voxSpell.Exceptions.NoSuchUserException;

public class Users {

	private ArrayList<UserData> _users = new ArrayList<UserData>();

	public Users() {
		File file = new File(".Users.Data");
		if (file.isFile()) {
			Scanner scanFile = null;

			try {
				scanFile = new Scanner(file);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			while (scanFile.hasNextLine()) {
				_users.add(new UserData(scanFile.nextLine()));
			}
			
			scanFile.close();
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void addUser(UserData user) {
		_users.add(user);
	}

	public void writeToFile() {
		File file = new File(".Users.Data");
		file.delete();
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (UserData x : _users) {
			addToFile(x.getName());
			x.writeToFile();
		}
	}

	private void addToFile(String word) {
		String fileName = ".Users.Data";
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
	
	public void addNewUser(String userName) {
		_users.add(new UserData(userName));
	}
	
	public void addAUser(UserData user) {
		_users.add(user);
	}
	
	public UserData getAUser(String userName) throws NoSuchUserException {
		for (UserData user : _users) {
			if (userName.equals(user.getName())) {
				return user;
			}
		}
		
		throw new NoSuchUserException();
	}
	
	public String[] getUserNames() {
		String[] out = new String[_users.size()];
		for (int i = 0; i < _users.size(); i++) {
			out[i] = _users.get(i).getName();
		}
		
		return out;
	}
	
	
}
