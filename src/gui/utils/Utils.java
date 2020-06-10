package gui.utils;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ResourceBundle;

public class Utils {

    static ResourceBundle bundle = ResourceBundle.getBundle("resources.bundles.messages");

    public static ImageView getImage(String name, int width, int height){
        return new ImageView(new Image("resources/images/"+name,width,height,false,false));
    }

}
