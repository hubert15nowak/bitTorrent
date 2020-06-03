import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class App extends Application {

    @FXML
    private ListView<String> trackersList;

    @FXML
    private ListView<String> peersList; //ew. ListView<String>, tak samo wyzej

    @FXML
    private Text leftText;

    @FXML
    private Text middleText;

    @FXML
    private Text rightText;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        stage.setTitle("TrackTorr");
        stage.setScene(new Scene(root, 976, 600));
        stage.getIcons().add(new Image("https://archive-media-0.nyafuu.org/vp/image/1473/12/1473127702488.jpg"));
        stage.show();

        init(root);

        trackersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        trackersList.getItems().addAll("tracker1", "tracker2", "tracker3", "tracker4", "tracker5", "tracker6");


        peersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        peersList.getItems().addAll("peer", "peer2", "peer3");

        trackersList.setCellFactory(lv -> new ListCell<String>()
        {

            @Override
            public void updateItem(String item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty) {
                    setText(item);
                    setGraphic(null);
                }
                else {
                    setText(item);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 1) {
                            System.out.println(item);
                        }
                    });
                }
            }
        });

        peersList.setCellFactory(lv -> new ListCell<String>()
        {

            @Override
            public void updateItem(String item, boolean empty)
            {
                super.updateItem(item, empty);
                if (empty) {
                    setText(item);
                    setGraphic(null);
                }
                else {
                    setText(item);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 1) {
                            System.out.println(item);
                        }
                    });
                }
            }
        });


        leftText.setText("left");
        middleText.setText("middle");
        rightText.setText("right");




    }

    private void init(Parent root){
        trackersList = (ListView<String>) root.lookup("#trackersList");
        peersList = (ListView<String>) root.lookup("#peersList");
        leftText = (Text) root.lookup("#leftText");
        middleText = (Text) root.lookup("#middleText");
        rightText = (Text) root.lookup("#rightText");
    }



}
