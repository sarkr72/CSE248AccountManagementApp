package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Administrator;
import model.AdministratorStore;
import model.GetStores;
import model.Manager;
import model.ManagerStore;
import model.User;
import model.UserStore;

public class SignUpController {

	private UserStore userStore = GetStores.getUserStore();
	private ManagerStore managerStore = GetStores.getManagerStore();
	private AdministratorStore administratorStore = GetStores.getAdministratorStore();
	private String userName;
	private String passWord;
	private String type;

	@FXML
	private Pane pane;
	@FXML
	private TextField userNameField;

	@FXML
	private Label userNameLabel;

	@FXML
	private PasswordField passWordField;

	@FXML
	private Label passwordLabel;

	@FXML
	private Button signUp;

	@FXML
	private Label showLabel;

	@FXML
	void backToLogIn(ActionEvent event) {

	}

	@FXML
	void signUp(ActionEvent event) throws IOException {
		if (userStore.getUsers().containsKey(userName) || managerStore.getManagers().containsKey(userName)
				|| administratorStore.getAdministrators().containsKey(userName))

		{
			if (userStore.getUsers().containsKey(userName)) {
				if (passWord.length() < 8) {
					passwordLabel.setText("Enter at least 8 characters");
				} else if (!passWord.matches("?=.*[A-Z]")) {
					passwordLabel.setText("Enter at least one capitol letter");
				} else if (!passWord.matches("?=.*[a-z]")) {
					passwordLabel.setText("Enter at least one lowerCase letter");
				} else if (!passWord.matches("?=.*\\d")) {
					passwordLabel.setText("Enter at least one digit");
				} else {
					type = "user";
					userStore.add(new User(userName, passWord, type));
					changeScene(event, "/view/LogInView.fxml");
				}
			} else if (managerStore.getManagers().containsKey(userName)) {
				if (passWord.length() < 8) {
					passwordLabel.setText("Enter at least 8 characters");
				} else if (!passWord.matches("?=.*[A-Z]")) {
					passwordLabel.setText("Enter at least one capitol letter");
				} else if (!passWord.matches("?=.*[a-z]")) {
					passwordLabel.setText("Enter at least one lowerCase letter");
				} else if (!passWord.matches("?=.*\\d")) {
					passwordLabel.setText("Enter at least one digit");
				} else {
					type = "manager";
					managerStore.add(new Manager(userName, passWord, type));
					changeScene(event, "/view/LogInView.fxml");
				}
			} else if (administratorStore.getAdministrators().containsKey(userName)) {
				if (passWord.length() < 8) {
					passwordLabel.setText("Enter at least 8 characters");
				} else if (!passWord.matches("?=.*[A-Z]")) {
					passwordLabel.setText("Enter at least one capitol letter");
				} else if (!passWord.matches("?=.*[a-z]")) {
					passwordLabel.setText("Enter at least one lowerCase letter");
				} else if (!passWord.matches("?=.*\\d")) {
					passwordLabel.setText("Enter at least one digit");
				} else {
					type = "administrator";
					administratorStore.add(new Administrator(userName, passWord, type));
					changeScene(event, "/view/LogInView.fxml");
				}
			}
		}
	}
	
	public void changeScene(ActionEvent event, String str) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("str"));
		Parent root = loader.load();
		Scene scene = new Scene(root, 600, 600);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setWidth(600);
		window.setHeight(600);
		window.setScene(scene);
		window.show();
	}

}
