package grandmaster;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.paint.*;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.fxml.FXMLLoader;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class HelloFX extends Application {
	@FXML
	private VBox mainApp;
	@FXML
	private BorderPane modal;
	@FXML
	private VBox playerOneVBox;
	@FXML
	private VBox playerTwoVBox;

	@FXML
	public void quitApplication(Event e) {
		Platform.exit();
	}

	@FXML
	public void toggleAboutGrandmaster(Event e) {
		modal.setVisible(!modal.isVisible());
		// this makes the app easier to tab through by keyboard
		// plus, you should not be rendering the app when it is
		// covered by the modal
		mainApp.setVisible(!modal.isVisible());
	}

	@FXML
	public void newGame(Event e) {
		System.out.println("restart");
	}

	@FXML
	public void openInBrowser(ActionEvent e) {
		Hyperlink hl = (Hyperlink)e.getTarget();
		getHostServices().showDocument(hl.getText());
	}

	private Parent createContent() {
		try {
			StackPane sp = FXMLLoader.<StackPane>load(HelloFX.class.getResource("firstlayout.fxml"));
			return sp;
		} catch (Exception e) {
			VBox vbox = new VBox(8); 
			String javaVersion = System.getProperty("java.version");
			String javafxVersion = System.getProperty("javafx.version");
			Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
			Text t = new Text("The file 'firslayout.fxml' could not be loaded!");
			vbox.getChildren().addAll(l, t);
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			return vbox;
		}
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setOpacity(1.0);
		Scene scene = new Scene(createContent(), 840, 580, Color.BLUE);
		primaryStage.setTitle("Grandmaster");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(HelloFX.class.getResource("Login.css").toExternalForm());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
