package grandmaster;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.net.URL;
import javafx.scene.control.Label;
import grandmaster.ChessGridLabel;

public class ChessGrid extends GridPane {
	private @FXML GridPane chessGridPane;

	public ChessGrid() {
		super();
		this.loadFxml(ChessGrid.class.getResource("chessGrid.fxml"), this);
	}

	/** 
	 * This function should setup only the labels for the grid once
	 */
	public void setup() {
		chessGridPane.add(new ChessGridLabel("8"), 0, 0);
		chessGridPane.add(new ChessGridLabel("7"), 0, 1);
		chessGridPane.add(new ChessGridLabel("6"), 0, 2);
		chessGridPane.add(new ChessGridLabel("5"), 0, 3);
		chessGridPane.add(new ChessGridLabel("4"), 0, 4);
		chessGridPane.add(new ChessGridLabel("3"), 0, 5);
		chessGridPane.add(new ChessGridLabel("2"), 0, 6);
		chessGridPane.add(new ChessGridLabel("1"), 0, 7);
		chessGridPane.add(new ChessGridLabel("A"), 1, 8);
		chessGridPane.add(new ChessGridLabel("B"), 2, 8);
		chessGridPane.add(new ChessGridLabel("C"), 3, 8);
		chessGridPane.add(new ChessGridLabel("D"), 4, 8);
		chessGridPane.add(new ChessGridLabel("E"), 5, 8);
		chessGridPane.add(new ChessGridLabel("F"), 6, 8);
		chessGridPane.add(new ChessGridLabel("G"), 7, 8);
	}

	public void render() {
		// re-load and show the chess pieces here

	}

	protected void loadFxml(URL fxmlFile, GridPane rootController) {
		FXMLLoader loader = new FXMLLoader(fxmlFile);
		loader.setController(rootController);
		loader.setRoot(rootController); // setting the root to this class, VBox

		try {
			loader.load();
			// now all the FXML bindings are active and accessible
			this.setup();
			this.render();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
