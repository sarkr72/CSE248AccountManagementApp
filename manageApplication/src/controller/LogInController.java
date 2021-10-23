package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AdministratorStore;
import model.GetStores;
import model.ManagerStore;
import model.UserStore;

public class LogInController {

	private UserStore userStore = GetStores.getUserStore();
	private ManagerStore managerStore = GetStores.getManagerStore();
	private AdministratorStore administratorStore = GetStores.getAdministratorStore();
	public static String userName;
	private String passWord;

	@FXML
	private TextField userNameField;

	@FXML
	private Pane pane;

	@FXML
	private Label userNameLabel;

	@FXML
	private PasswordField passWordField;

	@FXML
	private Label passwordLabel;

	@FXML
	private Label showLabel;

	@FXML
	void signIn(ActionEvent event) throws IOException {
		userName = userNameField.getText().toLowerCase();
		passWord = passWordField.getText();
		if (userStore.getUsers().containsKey(userName)) {
			if (userStore.getUsers().get(userName).getPassWord().compareTo(passWord) == 0) {
				showLabel.setText("Log In Successful");
			} else {
				passwordLabel.setText("Password is incorrect");
			}
		} else if (managerStore.getManagers().containsKey(userName)) {
			if (managerStore.getManagers().get(userName).getPassWord().compareTo(passWord) == 0) {
				changeScene(event, "/view/ManagerLoggedInView.fxml");
			} else {
				passwordLabel.setText("Password is incorrect");
			}
		} else if (administratorStore.getAdministrators().containsKey(userName)) {
			if (administratorStore.getAdministrators().get(userName).getPassWord().compareTo(passWord) == 0) {
				changeScene(event, "/view/ManagerLoggedInView.fxml");
			} else {
				passwordLabel.setText("Password is incorrect");
			}
		} else {
			userNameLabel.setText("userName couldn't be recoznized");
		}
	}

	@FXML
	void exit(ActionEvent event) {

	}

	@FXML
	void signUp(ActionEvent event) throws IOException {
		changeScene(event, "/view/SignUpView.fxml");
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