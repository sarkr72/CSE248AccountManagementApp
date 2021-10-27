package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;

public class Stores {

	private static TreeMap<String, Unitable> accounts;

	public Stores() {
		accounts = new TreeMap<>();
	}

	public void add(String userName, Unitable unitable) {
		accounts.put(userName, unitable);
	}

	public static TreeMap<String, Unitable> getAccounts() {
		return accounts;
	}

	public void backUp() throws ClassNotFoundException, IOException {
		if (new File("Accounts.dat").exists()) {
			FileInputStream fis = new FileInputStream("Accounts.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			accounts = (TreeMap<String, Unitable>) (ois.readObject());
			ois.close();
			fis.close();
			if (accounts == null) {
			}
		}
	}
//	private static AdministratorStore administratorStore = new AdministratorStore();
//	private static  ManagerStore managerStore = new ManagerStore();
//	private static UserStore userStore = new UserStore();
//	
//
//	public static AdministratorStore getAdministratorStore() {
//		return administratorStore ;
//	}
//
//	public static ManagerStore getManagerStore() {
//		return managerStore ;
//	}
//
//	public static UserStore getUserStore() {
//		return userStore ;
//	}
}
