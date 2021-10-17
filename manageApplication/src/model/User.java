package model;

import java.io.Serializable;

public class User implements Unitable, Serializable{
	
	private RoleUser roleUser;
	private String userName;
	private String passWord;
	
	public User(RoleUser roleUser) {
		this.roleUser = roleUser;
	}
	
	public void show() {
		roleUser.showLabel();
	}

}
