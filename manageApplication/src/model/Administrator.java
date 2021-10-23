package model;

import java.io.Serializable;

public class Administrator implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String passWord;
	private String type;

	public Administrator(String type, String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Administrator [userName=" + userName + ", passWord=" + passWord + ", type=" + type + "]";
	}

}
