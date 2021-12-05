package grandmaster;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.beans.NamedArg;


public class ChessGridLabel extends Label
{
		public String labelString;

		public ChessGridLabel(@NamedArg("text") String text)
		{
				super();
				this.labelString = text;
				this.loadFxml(ChessGrid.class.getResource("chessGridLabel.fxml"), this);		
		}
		
		public void render()
		{
				this.setText(labelString);
		}

		protected void loadFxml(URL fxmlFile, Label rootController) {
			FXMLLoader loader = new FXMLLoader(fxmlFile);
			loader.setController(rootController);
			loader.setRoot(rootController); // setting the root to this class, VBox
					
			try {
				loader.load();
				// now all the FXML bindings are active and accessible
				this.render();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
}

