package game.pieces;

import com.sun.jdi.connect.Connector;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Rook extends Piece{
    private ImageView imageView;

    @Override
    public TeamColor getTeamColor() {
        return this.teamColor;
    }

    public Rook(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 400, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 400, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {
        if(currentX != targetX && currentY != targetY) {
            return false;
        }

        if (targetX > currentX) {
            int x = currentX + 1;
            while (x != targetX) {
                if (board[currentY][x] != null) {
                    return false;
                }
                x = x + 1;
            }
        }
        if (targetX < currentX) {
            int x = currentX - 1;
            while (x != targetX) {
                if (board[currentY][x] != null) {
                    return false;
                }
                x = x - 1;
            }
        }
        if (targetY > currentY) {
            int y = currentY + 1;
            while (y != targetY) {
                if (board[y][currentX] != null) {
                    return false;
                }
                y = y + 1;
            }
        }
        if (targetY < currentY) {
            int y = currentY - 1;
            while (y != targetY) {
                if (board[y][currentX] != null) {
                    return false;
                }
                y = y - 1;
            }
        }
        return true;
    }

    @Override
    public ImageView getImageView() {
        return imageView;
    }


}
