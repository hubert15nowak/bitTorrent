package gui.controllers;

import bitTorrent.peer.Peer;
import bitTorrent.tracker.Tracker;
import flow.FlowController;
import gui.utils.Utils;
import javafx.fxml.FXML;

import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Text;
import gui.utils.DialogUtils;

import java.util.ArrayList;
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

    private MenuItem menu11, menu12;
    private MenuItem menu211, menu212, menu213;
    private MenuItem menu31;
    private ArrayList<String> trackersArrayList = new ArrayList<>();
    private ArrayList<String> peersArrayList = new ArrayList<>();

    private String trackerName(Tracker tracker) {
        return tracker.toString().substring(19);
    }

    private String peerName(Peer peer) {
        return peer.toString().substring(16);
    }

    public void startMockup(Parent root) {
        init(root, bundle);

        trackersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        for (int i = 0; i < FlowController.getInstance().getTrackers().size(); i++) {
            String tracker = trackerName(FlowController.getInstance().getTrackers().get(i));
            trackersArrayList.add(tracker);
        }
        trackersList.getItems().addAll(trackersArrayList);

        peersList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        for (int i = 0; i < FlowController.getInstance().getTrackers().size(); i++) {
            String peer = peerName(FlowController.getInstance().getPeers().get(i));
            peersArrayList.add(peer);
        }
        peersList.getItems().addAll(peersArrayList);

        trackersList.setCellFactory(lv -> new ListCell<String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(item);
                    setGraphic(null);
                } else {
                    setText(item);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 1) {
                            for (Tracker tracker : FlowController.getInstance().getTrackers()) {
                                if (trackerName(tracker).equals(item)) {
                                    leftText.setText("Adres trackera: "+tracker.getAddress()+"\n"+
                                            "Adres portu: "+tracker.getPort()
                                    );

                                    break;
                                }
                            }
                        }
                    });
                }
            }
        });

        peersList.setCellFactory(lv -> new ListCell<String>() {

            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(item);
                    setGraphic(null);
                } else {
                    setText(item);
                    setOnMouseClicked(mouseClickedEvent -> {
                        if (mouseClickedEvent.getButton().equals(MouseButton.PRIMARY) && mouseClickedEvent.getClickCount() == 1) {
                            for (Peer peer : FlowController.getInstance().getPeers()) {
                                if (peerName(peer).equals(item)) {
                                    middleText.setText("Dysk: "+peer.getDisk().getName()+"\n"+
                                                    "Adres: "+peer.getAddress()+"\n"+
                                                    "Port: "+peer.getPort()+"\n"+
                                                    "ID: "+peer.getId()+"\n"
                                    );
                                    break;
                                }
                            }
                        }
                    });
                }
            }
        });

        menu31.setOnAction(v -> {
            DialogUtils.about();
        });


    }

    private void init(Parent root, ResourceBundle bundle) {
        trackersList = (ListView<String>) root.lookup("#trackersList");
        peersList = (ListView<String>) root.lookup("#peersList");
        leftText = (Text) root.lookup("#leftText");
        middleText = (Text) root.lookup("#middleText");
        rightText = (Text) root.lookup("#rightText");
        menuBar = (MenuBar) root.lookup("#menuBar");

        Menu menu1 = new Menu("Wyświetl");
        menu12 = new MenuItem("12");
        menu11 = new MenuItem("11");
        Menu menu2 = new Menu(bundle.getString("edit"));
        Menu menu21 = new Menu("21");
        menu211 = new MenuItem("211");
        menu212 = new MenuItem("212");
        SeparatorMenuItem separator = new SeparatorMenuItem();
        menu213 = new MenuItem("213");
        menu213.setGraphic(Utils.getImage("torrent.png", 20, 20));
        Menu menu3 = new Menu(bundle.getString("help"));
        menu31 = new MenuItem(bundle.getString("about"));

        menuBar.getMenus().addAll(menu1, menu2, menu3);
        menu1.getItems().addAll(menu11, menu12);
        menu2.getItems().addAll(menu21);
        menu21.getItems().addAll(menu211, menu212, separator, menu213);
        menu3.getItems().addAll(menu31);

    }
}
