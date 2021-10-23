package model;

import java.io.Serializable;
import java.util.TreeMap;

public class AdministratorStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TreeMap<String, Administrator> administrators;

	public AdministratorStore() {
		administrators = new TreeMap<>();
	}
	public TreeMap<String, Administrator> getAdministrators(){
		return administrators;
	}
	public void add(Administrator Administrator) {
		if(administrators.containsKey(Administrator.getUserName())) {
		
		}else {
			administrators.put(Administrator.getUserName(), Administrator);
		}
	}
	
	public void deleteAdministrator(String userName) {
		if(administrators.containsKey(userName)) {
			administrators.remove(userName);
		}
	}
	
	public Administrator searchAdministrator(String userName) {
		Administrator Administrator = null;
		if(administrators.containsKey(userName)) {
			Administrator = administrators.get(userName);
		}
		return Administrator;
	}

}
