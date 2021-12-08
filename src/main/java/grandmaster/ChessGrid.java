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
	public EventHandler<MouseEvent> onMouseMoveHandler = new EventHandler<>() {
		public void handle(MouseEvent event) {
			System.out.println("Hello World");
		}
	};
	/// Pair<Integer, Integer> currentActivePane = null;
	public Game ourGame;

	public ChessGrid() {
		super();
		this.loadFxml(ChessGrid.class.getResource("chessGrid.fxml"), this);
	}

	public void addChessPiece(String pieceText, Integer coordX, Integer coordY) {
		this.gridPaneArray[coordX][coordY].getChildren().clear();
		this.gridPaneArray[coordX][coordY].getChildren().add(new ChessGridPiece(pieceText));
	}

	private void addPaneEvents(int i, int j, StackPane sp) {
		sp.setOnMouseClicked(new EventHandler<>() {
			public void handle(MouseEvent event) {
				System.out.println("Hello from node " + Integer.toString(i) + "," + Integer.toString(j));
				//Block myPiece = ourGame.gameboard.blocks[7 - j][i - 1];
				// if we do not have an active piece
				if (ourGame.currentX == -1) {
					// before changing blue, verify it is selectable
					// 1. piece
					// 2. your turn and your piece
					List<Node> panelElems = (List<Node>) sp.getChildren();
					if (panelElems.size() != 0) {
						Node currentElement = panelElems.get(0);
						String curPlayer = ourGame.in_turn_player.toString();
						if ((currentElement instanceof ChessGridPiece) &&
						// if its your current turn and your piece ...
						(curPlayer.equals(((ChessGridPiece) currentElement).color))) {
							sp.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
							// this is now our current active piece!
							ourGame.setCurrentPieceCoords(i, j); // may have to fix later
						}
					}
				} else {
					// you have an active piece!
					List<Node> panelElems = (List<Node>) sp.getChildren();
					if (panelElems.size() != 0) {
						Node currentElement = panelElems.get(0);
						String curPlayer = ourGame.in_turn_player.toString();
						if (currentElement instanceof ChessGridPiece) {
							// if its your current turn and your piece ...
							if (curPlayer.equals(((ChessGridPiece) currentElement).color)) {
								// change current active piece again
								sp.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
								// deactivate the old piece
								Color c = Color.WHITE;
								if ((ourGame.currentX + ourGame.currentY) % 2 == 0)
									c = Color.LIGHTGRAY;
								gridPaneArray[ourGame.currentX][ourGame.currentY]
										.setBackground(new Background(new BackgroundFill(c, null, null)));

								// this is now our current active piece!
								ourGame.setCurrentPieceCoords(i, j); // may have to fix later
							} else {
								// not our piece, send a command
								System.out.println("send command to move");
								if(ourGame.playerMove(ourGame.in_turn_player, 7 - ourGame.currentY,  ourGame.currentX - 1, 7 - j, i - 1)) {
										System.out.println("moved");
										
								} else {
										System.out.println("womp");
								}
								

							}
						}
					} else {
						// send a command to move the piece to this empty spot
						System.out.println("send command to move");
								if(ourGame.playerMove(ourGame.in_turn_player, 7 - ourGame.currentY,  ourGame.currentX - 1, 7 - j, i - 1)) {
										System.out.println("moved");
										
								} else {
										System.out.println("womp");
								}
					}
					System.out.println("is white in check?");
					System.out.println(ourGame.white_check_flag);
					System.out.println("");
					System.out.println("is black in check?");
					System.out.println(ourGame.black_check_flag);
					System.out.println("");
					System.out.println("has white won?");
					System.out.println(ourGame.white_victory);
					System.out.println("");
					System.out.println("has black won?");
					System.out.println(ourGame.black_victory);
					System.out.println("");
					render();

				}

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
	}

	public void setOurGame(Game ourGame) {
			this.ourGame = ourGame;
	}

	@FXML
	public void render() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Block myPiece = ourGame.gameboard.blocks[7 - i][j];
				System.out.print(myPiece);
				if (myPiece.toString() != "") {
					this.addChessPiece(myPiece.toString().toLowerCase(), j + 1, i);
				} else {
					// clear space
					this.gridPaneArray[j + 1][i].getChildren().clear();
				}
			}
		}
		System.out.println("rendered");
	}

	protected void loadFxml(URL fxmlFile, GridPane rootController) {
		FXMLLoader loader = new FXMLLoader(fxmlFile);
		loader.setController(rootController);
		loader.setRoot(rootController); // setting the root to this class, VBox

		try {
			loader.load();
			// now all the FXML bindings are active and accessible
			this.setup();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
