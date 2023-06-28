package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static java.lang.Math.abs;

public class Knight extends Piece{
    private ImageView imageView;

    @Override
    public TeamColor getTeamColor() {
        return this.teamColor;
    }

    public Knight(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 300, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 300, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {

        if ((targetX == (currentX + 2)) && (targetY == (currentY + 1))) {
            return true;
        }

        if ((targetX == (currentX - 2)) && (targetY == (currentY + 1))) {
            return true;
        }

        if ((targetX == (currentX + 2)) && (targetY == (currentY - 1))) {
            return true;
        }

        if ((targetX == (currentX - 2)) && (targetY == (currentY - 1))) {
            return true;
        }

        if ((targetX == (currentX + 1)) && (targetY == (currentY + 2))) {
            return true;
        }

        if ((targetX == (currentX - 1)) && (targetY == (currentY + 2))) {
            return true;
        }

        if ((targetX == (currentX + 1)) && (targetY == (currentY - 2))) {
            return true;
        }

        if ((targetX == (currentX - 1)) && (targetY == (currentY - 2))) {
            return true;
        }

        else {
            return false;
        }
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }
}
