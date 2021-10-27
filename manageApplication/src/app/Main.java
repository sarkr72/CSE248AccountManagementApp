package app;

import java.io.EOFException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Stores;

public class Main extends Application{
	
	public static void main(String[] args) throws Exception {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception, EOFException {
		Stores gb = new Stores();
		gb.backUp();
//		Unitable ad = new Administrator("admin", "Password1", "administrator");
//		Unitable manager = new Manager("admin2", "Password2", "manager");
//		Unitable manager2 = new User("admin3", "Password3", "user");
//		Stores.getAccounts().put(ad.getUserName(), ad);
//		Stores.getAccounts().put(manager.getUserName(), manager);
//		Stores.getAccounts().put(manager2.getUserName(), manager2);
		Parent root = FXMLLoader.load(getClass().getResource("/view/LogInView.fxml"));
		Scene scene = new Scene(root, 600, 600);
		Stage primaryStage = new Stage();
		primaryStage.setWidth(600);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
