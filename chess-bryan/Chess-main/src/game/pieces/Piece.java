package game.pieces;

import javafx.scene.image.ImageView;

public abstract class Piece {
    protected int id;
    protected TeamColor teamColor;

    public abstract ImageView getImageView();

    public abstract TeamColor getTeamColor();

    public abstract boolean canMove(Piece[][] board, int currentX, int currentY, int targetX, int targetY);

}
