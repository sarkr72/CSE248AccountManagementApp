package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Stores;

public class LogInController implements Initializable {

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
		if (Stores.getAccounts().containsKey(userName)) {
			if (Stores.getAccounts().get(userName).getType().compareTo("manager") == 0
					&& Stores.getAccounts().get(userName).getPassWord().compareTo(passWord) == 0) {
				changeScene(event, "/view/ManagerView.fxml");
			} else if (Stores.getAccounts().get(userName).getPassWord().compareTo(passWord) == 0
					&& Stores.getAccounts().get(userName).getType().compareTo("administrator") == 0) {
				changeScene(event, "/view/Administrator.fxml");
			} else if (Stores.getAccounts().get(userName).getPassWord().compareTo(passWord) == 0
					&& Stores.getAccounts().get(userName).getType().compareTo("user") == 0) {
				userNameLabel.setText("");
				passwordLabel.setText("");
				showLabel.setText("Log In Successful");
			} else {
				userNameLabel.setText("");
				showLabel.setText("");
				passwordLabel.setText("Password is incorrect");
			}
		} else {
			userNameLabel.setText("Username isn't recoznized");
		}
	}

	@FXML
	void exit(ActionEvent event) throws IOException {
		File file = new File("Accounts.dat");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream dos = new ObjectOutputStream(fos);
		dos.writeObject(Stores.getAccounts());
		dos.close();
		fos.close();
		System.exit(0);
	}

	@FXML
	void signUp(ActionEvent event) throws IOException {
		changeScene(event, "/view/SignUpView.fxml");
	}

	public void changeScene(ActionEvent event, String str) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource(str));
		Parent root = loader.load();
		Scene scene = new Scene(root, 600, 600);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setWidth(600);
		window.setHeight(600);
		window.setScene(scene);
		window.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
//		userStore = Stores.getUserStore();
//		managerStore = Stores.getManagerStore();
//		administratorStore = Stores.getAdministratorStore();
	}
}