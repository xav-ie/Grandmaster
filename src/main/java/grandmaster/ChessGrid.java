package grandmaster;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import java.net.URL;
import javafx.scene.control.Label;
import grandmaster.ChessGridLabel;
import javafx.scene.transform.Translate;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import org.javatuples.Pair;
import java.util.*;
		

public class ChessGrid extends GridPane {
	private @FXML GridPane chessGridPane;
	private StackPane[][] gridPaneArray = null;
	@FXML
	public EventHandler<MouseEvent> onMouseMoveHandler=new EventHandler<>(){public void handle(MouseEvent event){System.out.println("Hello World");}};
		Pair<Integer, Integer> currentActivePane = null;

	public ChessGrid() {
		super();
		this.loadFxml(ChessGrid.class.getResource("chessGrid.fxml"), this);
	}

	public void addChessPiece(String pieceText, Integer coordX, Integer coordY) {
		this.gridPaneArray[coordX][coordY].getChildren().add(new ChessGridPiece(pieceText));

		//chessGridPane.add(new ChessGridPiece(pieceText), coordX, coordY);
		// todo: add event listener of some sort or create piece with some class and emit
		// events directly to it rather than having many event handlers
	}

	private void changeActivePane(int i, int j) 
	{
			if (this.currentActivePane == null || !(this.currentActivePane[0] == i && this.currentActivePane[1] == j)) {
				this.currentActivePane = new Pair<Integer, Integer>(i,j);
				System.out.println(this.chessGridPane[i][j].getChildren());

			}
	}

	private void addPaneEvents(int i, int j, StackPane sp) {
		sp.setOnMouseMoved(new EventHandler<>() {
			public void handle(MouseEvent event) {
				System.out.println("Hello from node " + Integer.toString(i) + "," + Integer.toString(j));
			}
		});

		sp.setOnDragDetected(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				/* drag was detected, start a drag-and-drop gesture */
				/* allow any transfer mode */
				Dragboard db = source.startDragAndDrop(TransferMode.ANY);
				/* Put a string on a dragboard */
				ClipboardContent content = new ClipboardContent();
				content.putString(Integer.toString(i) + "," + Integer.toString(j));
				db.setContent(content);
				event.consume();
			}
		});

		sp.setOnDragOver(new EventHandler<DragEvent>() {
			public void handle(DragEvent event) {
				/* data is dragged over the target */
				/* accept it only if it is not dragged from the same node 
				 * and if it has a string data */
				if (event.getGestureSource() != target && event.getDragboard().hasString()) {
					/* allow for both copying and moving, whatever user chooses */
					System.out.println("I want to accept this drag");
					event.acceptTransferModes(TransferMode.COPY_OR_MOVE);

				}

				event.consume();
			}
		});

	}

	/**
	 * This function should setup only the labels for the grid once
	 */
	public void setup() {
		// Unfortunately, we must keep track of where we put which nodes... :/
		this.gridPaneArray = new StackPane[9][9];
		// set up stackpanes as the backgrounds of each chess square
		for (int i = 0; i < 9; i++) {
			RowConstraints rc = new RowConstraints();
			rc.setFillHeight(true);
			rc.setVgrow(Priority.ALWAYS);
			chessGridPane.getRowConstraints().add(rc);
			ColumnConstraints cc = new ColumnConstraints();
			cc.setFillWidth(true);
			cc.setHgrow(Priority.ALWAYS);
			chessGridPane.getColumnConstraints().add(cc);
			for (int j = 0; j < 9; j++) {
				StackPane sp = new StackPane();
				if (((i + j) % 2) == 0) {
					sp.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, null, null)));
				} else {
					sp.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
				}
				this.addPaneEvents(i, j, sp);
				// save the reference of our stackpane for later access
				this.gridPaneArray[i][j] = sp;
				chessGridPane.add(sp, i, j);
			}
		}
		this.gridPaneArray[0][0].getChildren().add(new ChessGridLabel("8"));
		this.gridPaneArray[0][1].getChildren().add(new ChessGridLabel("7"));
		this.gridPaneArray[0][2].getChildren().add(new ChessGridLabel("6"));
		this.gridPaneArray[0][3].getChildren().add(new ChessGridLabel("5"));
		this.gridPaneArray[0][4].getChildren().add(new ChessGridLabel("4"));
		this.gridPaneArray[0][5].getChildren().add(new ChessGridLabel("3"));
		this.gridPaneArray[0][6].getChildren().add(new ChessGridLabel("2"));
		this.gridPaneArray[0][7].getChildren().add(new ChessGridLabel("1"));
		this.gridPaneArray[1][8].getChildren().add(new ChessGridLabel("A"));
		this.gridPaneArray[2][8].getChildren().add(new ChessGridLabel("B"));
		this.gridPaneArray[3][8].getChildren().add(new ChessGridLabel("C"));
		this.gridPaneArray[4][8].getChildren().add(new ChessGridLabel("D"));
		this.gridPaneArray[5][8].getChildren().add(new ChessGridLabel("E"));
		this.gridPaneArray[6][8].getChildren().add(new ChessGridLabel("F"));
		this.gridPaneArray[7][8].getChildren().add(new ChessGridLabel("G"));
		this.gridPaneArray[8][8].getChildren().add(new ChessGridLabel("H"));
		this.addChessPiece("br", 1, 0);
		this.addChessPiece("bn", 2, 0);
		this.addChessPiece("bb", 3, 0);
		this.addChessPiece("bq", 4, 0);
		this.addChessPiece("bk", 5, 0);
		this.addChessPiece("bb", 6, 0);
		this.addChessPiece("bn", 7, 0);
		this.addChessPiece("br", 8, 0);
		this.addChessPiece("wr", 1, 7);
		this.addChessPiece("wn", 2, 7);
		this.addChessPiece("wb", 3, 7);
		this.addChessPiece("wq", 4, 7);
		this.addChessPiece("wk", 5, 7);
		this.addChessPiece("wb", 6, 7);
		this.addChessPiece("wn", 7, 7);
		this.addChessPiece("wr", 8, 7);
		for (int i = 0; i < 8; i++) {
			this.addChessPiece("bp", i + 1, 1);
			this.addChessPiece("wp", i + 1, 6);
		}
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
