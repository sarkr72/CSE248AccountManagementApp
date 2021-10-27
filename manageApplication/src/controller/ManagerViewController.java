package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Stores;
import model.Unitable;

public class ManagerViewController implements Initializable {
	
	private TreeMap<String, Unitable> accounts = Stores.getAccounts();
	@FXML
	private TableView<Unitable> tableView;
	@FXML
	private TableColumn<Unitable, String> userNameCol;
	@FXML
	private TableColumn<Unitable, String> passWordCol;
	@FXML
	private TableColumn<Unitable, String> typeCol;
	@FXML
	private TextField searchField;
    @FXML
    private Button searchBtn;
	@FXML
	void logOut(ActionEvent event) throws IOException {
		File file = new File("Accounts.dat");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream dos = new ObjectOutputStream(fos);
		dos.writeObject(accounts);
		dos.close();
		fos.close();
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
	void search(ActionEvent event) {
//		searchBtn.setOnAction(e->{
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
//		});
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
