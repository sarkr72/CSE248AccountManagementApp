package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Stores;
import model.Unitable;

public class AdministratorController implements Initializable {

	@FXML
	private TableView<Unitable> tableView;

	@FXML
	private TableColumn<Unitable, String> userNameCol;

	@FXML
	private TableColumn<Unitable, String> passWordCol;
	@FXML
	private TextField searchField;
	@FXML
	private TableColumn<Unitable, String> typeCol;
	@FXML
	private Label label;

	@FXML
	void back(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/LogInView.fxml"));
		Parent root = loader.load();
		Scene scene = new Scene(root, 600, 600);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setWidth(600);
		window.setHeight(600);
		window.setScene(scene);
		window.show();
	}

	@FXML
	void changeToAdministrator(ActionEvent event) {
		if(tableView.getSelectionModel().getSelectedItem() == null) {
			label.setText("select the account first");
		}else {
			tableView.getSelectionModel().getSelectedItem().setType("administrator");
		}
	}

	@FXML
	void changeToManager(ActionEvent event) {
		if(tableView.getSelectionModel().getSelectedItem() == null) {
			label.setText("select the account first");
		}else {
			tableView.getSelectionModel().getSelectedItem().setType("manager");
		}
	}

	@FXML
	void changeToUser(ActionEvent event) {
		if(tableView.getSelectionModel().getSelectedItem() != null) {
			tableView.getSelectionModel().getSelectedItem().setType("user");
		}else {
			label.setText("select the account first");
		}
	}

	@FXML
	void search(ActionEvent event) {
		ObservableList<Unitable> list = FXCollections.observableArrayList(Stores.getAccounts().values());
		FilteredList<Unitable> filteredAccounts = new FilteredList<>(list, e1 -> true);
		searchField.textProperty().addListener((observableValue, oldValue, newValue) -> {
			filteredAccounts.setPredicate((Predicate<? super Unitable>) accounts -> {
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				String lowerCase = newValue.toLowerCase();
				if ((accounts).getUserName().toLowerCase().startsWith(lowerCase)) {
					return true;
				}
				return false;
			});
		});
		SortedList<Unitable> sorted = new SortedList<>(filteredAccounts);
		sorted.comparatorProperty().bind(tableView.comparatorProperty());
		tableView.setItems(sorted);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		userNameCol.setCellValueFactory(new PropertyValueFactory<Unitable, String>("userName"));
//		passWordCol.setCellValueFactory(new PropertyValueFactory<Unitable, String>("passWord"));
		typeCol.setCellValueFactory(new PropertyValueFactory<Unitable, String>("type"));
		ObservableList<Unitable> list = FXCollections.observableArrayList(Stores.getAccounts().values());
		tableView.setItems(list);
	}

}
