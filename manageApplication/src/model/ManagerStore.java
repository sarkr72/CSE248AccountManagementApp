package model;
import java.io.Serializable;
import java.util.TreeMap;

public class ManagerStore implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TreeMap<String, Manager> managers;

	public ManagerStore() {
		managers = new TreeMap<>();
	}
	
	public TreeMap<String, Manager> getManagers(){
		return managers;
	}
	public void add(Manager Manager) {
		if(managers.containsKey(Manager.getUserName())) {
		
		}else {
			managers.put(Manager.getUserName(), Manager);
		}
	}
	
	public void deleteManager(String userName) {
		if(managers.containsKey(userName)) {
			managers.remove(userName);
		}
	}
	
	public Manager searchManager(String userName) {
		Manager Manager = null;
		if(managers.containsKey(userName)) {
			Manager = managers.get(userName);
		}
		return Manager;
	}

}
