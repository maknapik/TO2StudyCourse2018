package pl.edu.agh.iisg.to.javafx.cw1;

import java.io.IOException;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import pl.edu.agh.iisg.to.javafx.cw1.controller.AccountOverviewController;
import pl.edu.agh.iisg.to.javafx.cw1.model.Account;
import pl.edu.agh.iisg.to.javafx.cw1.model.generator.DataGenerator;

public class Main extends Application {

	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("My first JavaFX app");

		initRootLayout();
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void initRootLayout() {
		try {
			// load layout from FXML file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("view/AccountOverviewPane.fxml"));
			BorderPane rootLayout = loader.load();

			// set initial data into controller
			Account account = DataGenerator.generateAccountData();
			AccountOverviewController controller = loader.getController();
			controller.setData(account);

			// add layout to a scene and show them all
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			account.getTransactions().get(0).setPayee(new SimpleStringProperty("E"));

		} catch (IOException e) {
			// don't do this in common apps
			e.printStackTrace();
		}
	}
}
