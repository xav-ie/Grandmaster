package grandmaster;

import javafx.application.Application;
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


public class HelloFX extends Application {
	@FXML
		public void quitApplication(Event e) 
		{
				System.out.println("please quit!");
		}
		

	private Parent createContent() {
		try {
			VBox vbox = FXMLLoader.<VBox>load(HelloFX.class.getResource("firstlayout.fxml"));
			return vbox;
		} catch (Exception e) {
			VBox vbox = new VBox(8); // spacing = 8
			String javaVersion = System.getProperty("java.version");
			String javafxVersion = System.getProperty("javafx.version");
			Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
			Text t = new Text("The file 'firslayout.fxml' could not be loaded!");
			vbox.getChildren().addAll(l, t);
			return vbox;
		}
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setOpacity(1.0);
		Scene scene = new Scene(createContent(), 640, 480, Color.BLUE);
		scene.setCursor(Cursor.cursor("MOVE"));
		primaryStage.setTitle("Grandmaster");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(HelloFX.class.getResource("Login.css").toExternalForm());
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch();
	}

}
