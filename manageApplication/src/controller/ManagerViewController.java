package controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Administrator;
import model.GetStores;
import model.Manager;
import model.ManagerStore;
import model.User;

public class ManagerViewController implements Initializable {

	private ManagerStore managerStore = GetStores.getManagerStore();
	private String userName = LogInController.userName;
	private Manager manager = managerStore.searchManager(userName);
	

	@FXML
	private TableView<Object> tableView;
	@FXML
	private TableColumn<Object, String> userNameCol;

	@FXML
	private TableColumn<Object, String> passWordCol;

	@FXML
	private TableColumn<Object, String> typeCol;
	@FXML
	private TextField searchField;

	@FXML
	void logOut(ActionEvent event) {

	}

	@FXML
	void search(ActionEvent event) {
		searchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			ObservableList<Object> list = FXCollections.observableArrayList(GetStores.getUserStore().getUsers().values(),
					managerStore.getManagers().values(), GetStores.getAdministratorStore().getAdministrators().values());
			FilteredList<Object> filteredAccounts = new FilteredList<>(list, e1 -> true);
			filteredAccounts.setPredicate((Predicate<? super Object>) accounts -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCase = newValue.toLowerCase();
				if (((Manager) accounts).getUserName().toLowerCase().startsWith(lowerCase)) {
					return true;
				}
				if (( (Administrator) accounts).getUserName().toLowerCase().startsWith(lowerCase)) {
					return true;
				}
				if (((User) accounts).getUserName().toLowerCase().startsWith(lowerCase)) {
					return true;
				}
				return false;
			});
		});
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userNameCol.setCellValueFactory(new PropertyValueFactory<Object, String>("userName"));
		passWordCol.setCellValueFactory(new PropertyValueFactory<Object, String>("passWord"));
		typeCol.setCellValueFactory(new PropertyValueFactory<Object, String>("type"));
		ObservableList<Object> list = FXCollections.observableArrayList(GetStores.getUserStore().getUsers().values(),
				managerStore.getManagers().values(), GetStores.getAdministratorStore().getAdministrators().values());
		tableView.setItems(list);
	}

}
