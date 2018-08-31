package main.java.frontend.windows;

import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * SettingsWindow will open, when user wants to change settings of his personal
 * account by clicking on Settings button.
 *
 * @author klein
 * @since 28.8.2018
 */
public class SettingsWindow {
    private ImageView palette = new ImageView("main/resources/images/Paint_Palette_64px.png");
    private ComboBox colors = new ComboBox();

    /**
     * Constructor of SettingsWindow
     */
    public SettingsWindow(){
        setComponents();
    }

    /**
     * Method sets an ID names for purpose of easier language changing. Also sets Styles of components
     */
    private void setComponents() {
        //TOTO TU NEMA BYŤ
        palette.setLayoutY(200);
        palette.setLayoutX(200);

    }

    //Getters
    public ImageView getPalette(){
        return palette;
    }
    //Setters
}
