package game;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import game.pieces.Piece;
import game.pieces.TeamColor;

public class Controller {
    Stage display;
    StackPane root;
    GridPane gridPane;
    Board board;

    public Controller(Stage display, StackPane root) {
        this.display = display;
        this.root = root;
        board = new Board();
        initializeDisplay();
    }

    //Game Controller
    public TeamColor checkWin() {
        return null;
    }

    public boolean checkChecks() {
        return false;
    }

    public void initializeDisplay() {
        gridPane = new GridPane();
        root.getChildren().add(gridPane);
        for (int i = 0; i < 8; i++) {
            gridPane.getColumnConstraints().add(new ColumnConstraints(100)); // column 0 is 100 wide
            gridPane.getRowConstraints().add(new RowConstraints(100)); // column 0 is 100 wide
        }
        gridPane.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("" + e.getX() + ' ' + e.getY());
            clicked(e.getX(), e.getY());
        });

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoardArray()[i][j] != null) {
                    gridPane.add(board.getBoardArray()[i][j].getImageView(), j, i);
                }
            }
        }
    }

    public void updateDisplay() {
        gridPane.getChildren().clear();

        if (pieceSelected && selectedSquare != null) {
            gridPane.add(selectedSquare, gridOldX, gridOldY);
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board.getBoardArray()[i][j] != null) {
                    gridPane.add(board.getBoardArray()[i][j].getImageView(), j, i);
                }
            }
        }

    }

    Rectangle selectedSquare = new Rectangle();
    int gridOldX;
    int gridOldY;
    boolean pieceSelected = false;
    public void clicked(double x, double y) {

        int gridX;
        int gridY;
        gridX = (int) x / 100;
        gridY = (int) y / 100;

        if (!pieceSelected) {
            if ((board.getBoardArray()[gridY][gridX]) != null && (board.getBoardArray()[gridY][gridX].getTeamColor() == currentPlayer)) {
                gridOldX = gridX;
                gridOldY = gridY;

                selectedSquare = new Rectangle();
                selectedSquare.setWidth(100);
                selectedSquare.setHeight(100);
                selectedSquare.setFill(Color.YELLOW);

                pieceSelected = true;
                }
            }
        else if (pieceSelected) {
            if ((board.getBoardArray()[gridY][gridX] != null) && (board.getBoardArray()[gridY][gridX]).getTeamColor() == (board.getBoardArray()[gridOldY][gridOldX]).getTeamColor()) {
                return;
            }

            if (board.getBoardArray()[gridOldY][gridOldX].canMove(board.getBoardArray(), gridOldX, gridOldY, gridX, gridY)) {

                board.getBoardArray()[gridY][gridX] = board.getBoardArray()[gridOldY][gridOldX];
                board.getBoardArray()[gridOldY][gridOldX] = null;
                selectedSquare = null;
                pieceSelected = false;
                switchPlayers();
            }

        }
        updateDisplay();

    }

    TeamColor currentPlayer = TeamColor.WHITE;
    public void switchPlayers() {
        if (currentPlayer == TeamColor.WHITE) currentPlayer = TeamColor.BLACK;
        else {
            currentPlayer = TeamColor.WHITE;
        }

    }

}
        // find out which square is clicked
