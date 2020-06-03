package bitTorrent;

import bitTorrent.controllers.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../test.fxml"));
        stage.setTitle("TrackTorr");
        stage.setScene(new Scene(root, 976, 600));
        stage.getIcons().add(new Image("https://archive-media-0.nyafuu.org/vp/image/1473/12/1473127702488.jpg"));
        stage.show();
        MainController mc = new MainController();
        mc.startMockup(root);
    }
}
