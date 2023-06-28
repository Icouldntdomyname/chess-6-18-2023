package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Chess");
        StackPane root = new StackPane();
        Image chessBoard = new Image("game/res/chessboard.png", 800, 800, false, false);
        ImageView chessBoardView = new ImageView(chessBoard);
        root.getChildren().add(chessBoardView);

        Controller controller = new Controller(primaryStage, root);

        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
