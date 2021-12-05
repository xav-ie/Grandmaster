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

	public ChessGridPiece(@NamedArg("text") String text)
		{
				super();
				this.labelString = text;
				this.loadFxml(ChessGrid.class.getResource("chessGridPiece.fxml"), this);		
		}

	public void render() {
			this.setText(this.codeToImage(this.labelString));
	}

	public String codeToImage(String chessStringCode) {
		switch (chessStringCode) {
			case "wr":
				return "♖";
			case "wn":
				return "♘";
			case "wk":
				return "♔";
			case "wq":
				return "♕";
			case "wb":
				return "♗";
			case "wp":
				return "♙";
			case "br":
				return "♜";
			case "bn":
				return "♞";
			case "bk":
				return "♚";
			case "bq":
				return "♛";
			case "bb":
				return "♝";
			case "bp":
				return "♟";
			default:
				return "?";
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
