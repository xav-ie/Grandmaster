package grandmaster;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.beans.NamedArg;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class PlayerStats extends VBox 
{
		private int playerID;
		private boolean disabled = false;
		private ObservableList<String> pieces;
		private static int totalInstances = 0;
		private @FXML Ellipse playerCircle;
		private @FXML Label playerNumber;
		
		public PlayerStats(@NamedArg("playerID") Integer playerID)
		{
				super();
				this.playerID = playerID;
				if(++PlayerStats.totalInstances > 2) {
						System.out.println("THERE SHOULD BE NO MORE THAN TWO INSTANCES");
				}
				this.disabled = this.playerID == 2;
				this.loadFxml(PlayerStats.class.getResource("playerStats.fxml"), this);
		}

		public void toggle() 
		{
				this.disabled = !this.disabled;
				this.render();
		}

		public ObservableList<String> addPiece(String piece) 
		{
				this.pieces.add(piece);
				return this.pieces;
		}
		
		public void render()
		{
				this.setDisable(this.disabled);
				
				this.playerNumber.setText("Player "+Integer.toString(this.playerID));
				if(this.playerID == 1) {
						this.playerCircle.setFill(Color.WHITE);
				}	else {
						this.playerCircle.setFill(Color.BLACK);
				 
				}
				// re-load and show the chess pieces here

		}
	
		protected void loadFxml(URL fxmlFile, VBox rootController) {
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
