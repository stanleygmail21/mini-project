package battleship;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/battleship/res/view/battleship.fxml"));
        primaryStage.setTitle("Battleship");
        primaryStage.setScene(new Scene(root, 670, 670));
        primaryStage.setMinHeight(512);
        primaryStage.setMinWidth(512);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
