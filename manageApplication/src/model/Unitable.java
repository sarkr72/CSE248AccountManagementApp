package model;

public interface Unitable {
	public static final String userName = "";
	public static final String passWord = "";
	
	String getUserName();
	String getPassWord();
	String getType();
	void setType(String type);
	void setUserName(String str);
	void setPassWord(String passWord);
}
