package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static java.lang.Math.abs;

public class Bishop extends Piece {
    private ImageView imageView;

    @Override
    public TeamColor getTeamColor() {
        return this.teamColor;
    }

    public Bishop(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 200, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 200, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }

    int checkX;
    int checkY;

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {

        checkX = (targetX - currentX);
        checkY = (targetY - currentY);

        int distanceX = abs(targetX - currentX);
        int distanceY = abs(targetY - currentY);

        if (distanceX != distanceY) {
            return false;
        }

        if ((checkX == checkY) && (checkX > 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY + i][currentX + i] != null) {
                    return false;
                }
            }
        }

        if ((checkX == checkY) && (checkX < 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY - i][currentX - i] != null) {
                    return false;
                }
            }
        }

        if ((checkX > 0) && (checkY < 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY - i][currentX + i] != null) {
                    return false;
                }
            }
        }

        if ((checkX < 0) && (checkY > 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY + i][currentX - i] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }

    public boolean canMove(int x, int y) {
        return false;
    }

}
