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


public class App extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
        stage.setTitle("BitTracker");
        stage.setScene(new Scene(root, 976, 600));
        stage.getIcons().add(new Image("https://archive-media-0.nyafuu.org/vp/image/1473/12/1473127702488.jpg"));
        stage.show();

        ListView trackersList = (ListView) root.lookup("#trackersList");
        trackersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        trackersList.getItems().addAll("tracker1", "tracker2", "tracker3", "tracker4", "tracker5", "tracker6");

        ListView peersList = (ListView) root.lookup("#peersList");
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




    }

    @FXML
    private ListView<?> trackersList;

    @FXML
    private ListView<?> peersList;

    @FXML
    private Text leftText;

    @FXML
    private Text middleText;

    @FXML
    private Text rightText;

}
