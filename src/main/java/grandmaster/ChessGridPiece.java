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
	public String color;

	public ChessGridPiece(@NamedArg("text") String text) {
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
				this.color = "W";
				return "♖";
			case "wn":
				this.color = "W";
				return "♘";
			case "wk":
				this.color = "W";
				return "♔";
			case "wq":
				this.color = "W";
				return "♕";
			case "wb":
				this.color = "W";
				return "♗";
			case "wp":
				this.color = "W";
				return "♙";
			case "br":
				this.color = "B";
				return "♜";
			case "bn":
				this.color = "B";
				return "♞";
			case "bk":
				this.color = "B";
				return "♚";
			case "bq":
				this.color = "B";
				return "♛";
			case "bb":
				this.color = "B";
				return "♝";
			case "bp":
				this.color = "B";
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
