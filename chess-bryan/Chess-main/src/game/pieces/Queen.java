package game.pieces;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static java.lang.Math.abs;

public class Queen extends Piece{
    private ImageView imageView;

    @Override
    public TeamColor getTeamColor() {
        return this.teamColor;
    }

    public Queen(TeamColor color) {
        this.teamColor = color;

        Image piece = new Image("game/res/chess_pieces.png", 600, 200, false, false);
        ImageView pieceView = new ImageView(piece);
        this.imageView = pieceView;
        Rectangle2D viewRect;
        if(this.teamColor == TeamColor.WHITE) {
            viewRect = new Rectangle2D( 100, 0, 100, 100);
        } else {
            viewRect = new Rectangle2D( 100, 100, 100, 100);
        }
        pieceView.setViewport(viewRect);
    }

    boolean rookMove;
    int checkX;
    int checkY;

    @Override
    public boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY) {

        checkX = (targetX - currentX);
        checkY = (targetY - currentY);

        int distanceX = abs(targetX - currentX);
        int distanceY = abs(targetY - currentY);

        if (distanceX != distanceY && !(distanceX == 0 || distanceY == 0)) {
            return false;
        }

        if ((checkX == checkY) && (checkX > 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY + i][currentX + i] != null) {
                    return false;
                }
            }
        }
        else if (targetX > currentX && currentY == targetY) {
            int x = currentX + 1;
            while (x != targetX) {
                if (board[currentY][x] != null) {
                    return false;
                }
                x = x + 1;
            }
        }

        if ((checkX == checkY) && (checkX < 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY - i][currentX - i] != null) {
                    return false;
                }
            }
        }
        else if (targetX < currentX && currentY == targetY) {
            int x = currentX - 1;
            while (x != targetX) {
                if (board[currentY][x] != null) {
                    return false;
                }
                x = x - 1;
            }
        }

        if ((checkX > 0) && (checkY < 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY - i][currentX + i] != null) {
                    return false;
                }
            }
        }
        else if (targetY > currentY && currentX == targetX) {
            int y = currentY + 1;
            while (y != targetY) {
                if (board[y][currentX] != null) {
                    return false;
                }
                y = y + 1;
            }
        }

        if ((checkX < 0) && (checkY > 0)) {
            for(int i = 1; i < distanceY; i++) {
                if (board[currentY + i][currentX - i] != null) {
                    return false;
                }
            }
        }
        else if (targetY < currentY && currentX == targetX) {
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
