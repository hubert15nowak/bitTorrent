package gui.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import gui.dialogs.DialogUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ResourceBundle;

public class MainController {

    static ResourceBundle bundle = ResourceBundle.getBundle("resources.bundles.messages");

    @FXML
    private ListView<String> trackersList;

    @FXML
    private ListView<String> peersList;

    @FXML
    private Text leftText;

    @FXML
    private Text middleText;

    @FXML
    private Text rightText;

    @FXML
    private MenuBar menuBar;

    public void startMockup(Parent root){
        init(root, bundle);

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
                            leftText.setText(item);
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
                            leftText.setText(item);
                        }
                    });
                }
            }
        });

        leftText.setText("");
        middleText.setText("middle");
        rightText.setText("right");
    }

    private void init(Parent root, ResourceBundle bundle){
        trackersList = (ListView<String>) root.lookup("#trackersList");
        peersList = (ListView<String>) root.lookup("#peersList");
        leftText = (Text) root.lookup("#leftText");
        middleText = (Text) root.lookup("#middleText");
        rightText = (Text) root.lookup("#rightText");
        menuBar = (MenuBar) root.lookup("#menuBar");

        Menu menu1 = new Menu("Wyświetl");
            MenuItem menu12 = new MenuItem("12");
            MenuItem menu11 = new MenuItem("11");
        Menu menu2 = new Menu(bundle.getString("edit"));
            Menu menu21 = new Menu("21");
                MenuItem menu211 = new MenuItem("211");
                MenuItem menu212 = new MenuItem("212");
                SeparatorMenuItem separator = new SeparatorMenuItem();
                MenuItem menu213 = new MenuItem("213");
                    menu213.setGraphic(getImage("torrent.png", 20,20));
        Menu menu3 = new Menu("Pomoc");
            MenuItem menu31 = new MenuItem("O aplikacji");

        menuBar.getMenus().addAll(menu1, menu2, menu3);
            menu1.getItems().addAll(menu11, menu12);
            menu2.getItems().addAll(menu21);
                menu21.getItems().addAll(menu211, menu212, separator, menu213);
            menu3.getItems().addAll(menu31);

        menu31.setOnAction(v -> {
            DialogUtils.about();
        });
    }

    private ImageView getImage(String name, int width, int height){
        return new ImageView(new Image("resources/images/"+name,width,height,false,false));
    }

}
