package grandmaster;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.net.URL;
import javafx.scene.control.Label;
import javafx.beans.NamedArg;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ChessGridPiece extends Label {
	public String labelString;
	private @FXML ImageView pieceImage;

	public ChessGridPiece(@NamedArg("text") String text)
		{
				super();
				this.labelString = text;
				this.loadFxml(ChessGrid.class.getResource("chessGridLabel.fxml"), this);		
		}

	public void render() {
			// pieceImage.setImage(new Image(this.codeToImage(this.labelString)));
			this.setText(this.codeToImage(this.labelString));
			
	}

	public String codeToImage(String chessStringCode) {
		switch (chessStringCode) {
			case "wp1":
				return "\u2654";
			default:
				return "\u2654";
		}
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
