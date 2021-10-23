package model;

public class GetStores {
	
	public static AdministratorStore administratorStore;
	public static  ManagerStore managerStore;
	public static UserStore userStore;
	

	public static AdministratorStore getAdministratorStore() {
		return administratorStore = new AdministratorStore();
	}

	public static ManagerStore getManagerStore() {
		return managerStore = new ManagerStore();
	}

	public static UserStore getUserStore() {
		return userStore = new UserStore();
	}
	
	
}
