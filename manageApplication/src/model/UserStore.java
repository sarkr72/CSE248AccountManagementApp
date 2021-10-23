package model;

import java.util.TreeMap;

public class UserStore {

	private TreeMap<String, User> users;

	public UserStore() {
		users = new TreeMap<>();
	}
	
	public TreeMap<String, User> getUsers(){
		return users;
	}
	
	public void add(User user) {
		if(users.containsKey(user.getUserName())) {
		
		}else {
			users.put(user.getUserName(), user);
		}
	}
	
	public void deleteUser(String userName) {
		if(users.containsKey(userName)) {
			users.remove(userName);
		}
	}
	
	public User searchUser(String userName) {
		User user = null;
		if(users.containsKey(userName)) {
			user = users.get(userName);
		}
		return user;
	}
}
