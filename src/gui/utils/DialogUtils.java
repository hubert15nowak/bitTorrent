package gui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;

import java.util.Optional;
import java.util.ResourceBundle;

public class DialogUtils {

    static ResourceBundle bundle = ResourceBundle.getBundle("resources.bundles.messages");

    public static void about(){
        Alert aboutinfo = new Alert(Alert.AlertType.INFORMATION);
        aboutinfo.setTitle(bundle.getString("about.title"));
        aboutinfo.setHeaderText(bundle.getString("about.header"));
        aboutinfo.setContentText(bundle.getString("about.content"));
        aboutinfo.show();
    }

    public static void errorDialog(String error) {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle(bundle.getString("error.title"));
        errorAlert.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        errorAlert.getDialogPane().setContent(textArea);
        errorAlert.showAndWait();
    }

    public static Optional<ButtonType> confirmationDialog() {
        Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationDialog.setHeaderText(bundle.getString("risky.header"));
        Optional<ButtonType> result = confirmationDialog.showAndWait();
        return result;

        /* returns
        Optional[ButtonType [text=OK, buttonData=OK_DONE]]
        or
        Optional[ButtonType [text=Cancel, buttonData=CANCEL_CLOSE]]
         */
    }

}
