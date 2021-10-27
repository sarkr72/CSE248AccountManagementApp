package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.TreeMap;

public class UserStore {

//	private TreeMap<String, User> users;
	private TreeMap<String, Unitable> users;
	public UserStore() {
		 users = new TreeMap<>();
	}

	public void add(String userName, Unitable unitable) {
			users.put(userName, unitable);
	}

	public TreeMap<String, Unitable> getUsers() {
		return users;
	}

	public void deleteUser(String userName) {
		if (users.containsKey(userName)) {
			users.remove(userName);
		}
	}

	
//	public User searchUser(String userName) {
//		User user = null;
//		if (users.containsKey(userName)) {
//			user = users.get(userName);
//		}
//		return user;
//	}
}
