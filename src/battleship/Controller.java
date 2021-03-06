package battleship;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class Controller {
    @FXML
    private TilePane tiles;
    @FXML
    private TextField textField;
    @FXML
    private Label label;

    private Image missImage;
    private Image shipImage;
    private Board board;

    private void setImage(Point2D pos, Image img) {
        ImageView v = (ImageView)tiles.getChildren().get(pos.getY() * 7 + pos.getX());
        v.setImage(img);
    }

    private void error(String e) {
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setTitle("Error");
        a.setHeaderText(e);
        a.show();
    }

    @FXML
    public void buttonClick() {
        String text = textField.getText();
        if (text.isEmpty() || !text.matches("^[a-zA-Z][0-9]$")) {
            error("Oops, please enter a letter and a number on the board.");
            return;
        }
        if (!text.matches("^[a-gA-G][0-6]$")) {
            error("Oops, that's off the board!");
            return;
        }

        Point2D pos = new Point2D(text.charAt(1) - '0', Character.toUpperCase(text.charAt(0)) - 'A');
        boolean isHit = board.isHit(pos);
        setImage(pos, isHit? shipImage : missImage);
        label.setText(isHit ? "HIT!" : "You missed.");
    }

    @FXML
    public void initialize() {
        missImage = new Image("/battleship/res/img/miss.png");
        shipImage = new Image("/battleship/res/img/ship.png");
        board = Board.random();

        for (int i = 0; i < 49; i++)
            tiles.getChildren().add(i, new ImageView());

//        for (int i = 0; i < 7; i++)
//            for (int j = 0; j < 7; j++)
//                if (board.isHit(new Point2D(i, j)))
//                    setImage(new Point2D(i, j), shipImage);
//                else
//                    setImage(new Point2D(i, j), shipImage);
    }
}
