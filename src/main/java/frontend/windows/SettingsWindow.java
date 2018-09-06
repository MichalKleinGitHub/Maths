package main.java.frontend.windows;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import main.tools.TColor;

/**
 * SettingsWindow will open, when user wants to change settings of his personal
 * account by clicking on Settings button.
 *
 * @author klein
 * @since 28.8.2018
 */
public class SettingsWindow {
    private AnchorPane layout;
    private ImageView palette = new ImageView("main/resources/images/Paint_Palette_64px.png");
    private ComboBox colors = new ComboBox();
    private TextField colorRGB = new TextField();
    private TextField colorHxdcml = new TextField();
    private JFXButton colorRGBButton = new JFXButton("pick");
    private JFXButton colorHxdcmlButton = new JFXButton("pick");

    /**
     * Constructor of SettingsWindow
     */
    public SettingsWindow(AnchorPane layout){
        setComponents(layout);
    }

    /**
     * Method sets an ID names for purpose of easier language changing. Also sets Styles of components
     */
    private void setComponents(AnchorPane layout) {
        this.layout = layout;
        //TOTO TU NEMA BYŤ
        colors.setLayoutY(200);
        palette.setLayoutY(230);
        colorRGB.setLayoutY(250);
        colorRGBButton.setLayoutY(250);
        colorHxdcml.setLayoutY(300);
        colorHxdcmlButton.setLayoutY(300);

        palette.setLayoutX(400);
        colors.setLayoutX(500);
        colorRGB.setLayoutX(500);
        colorHxdcml.setLayoutX(500);
        colorRGBButton.setLayoutX(650);
        colorHxdcmlButton.setLayoutX(650);

        colorRGB.setPromptText("RGB color");
        colorHxdcml.setPromptText("Hexadecimal color");

       // colorRGBButton.setStyle();
        //colorHxdcmlButton.setStyle();

        ObservableList<String> operations = FXCollections.observableArrayList("BROWN", "RED", "BLUE", "WHITE", "BLACK");
        colors.setItems(operations);
        colors.getSelectionModel().selectFirst();

        colors.setOnAction(event -> {
            String operationsColors = (String)colors.getSelectionModel().getSelectedItem();
            switch (operationsColors){
                case "BROWN":
                    layout.setStyle("-fx-background-color: #f2ebde");
                    break;
                case "RED":
                    layout.setStyle("-fx-background-color: #ff9999");
                    break;
                case "BLUE":
                    layout.setStyle("-fx-background-color: #b3b3ff");
                    break;
                case "WHITE":
                    layout.setStyle("-fx-background-color: #f2f2f2");
                    break;
                case "BLACK":
                    layout.setStyle("-fx-background-color: #1a1a1a");
                    break;
            }
        });
    }

    //Getters
    public ImageView getPalette(){
        return palette;
    }

    public ComboBox getColors(){ return colors;}

    public TextField getColorRGB() {
        return colorRGB;
    }

    public TextField getColorHxdcml() {
        return colorHxdcml;
    }

    public JFXButton getColorRGBButton() {
        colorRGBButton.setOnAction(event -> {
            System.out.println("PROBLEM -> metoda chooseRGBColor vracia objekt Color, ale ja tu potrebujem hexadecimal cislo... ako to mam vyriesit?");
            //layout.setStyle("-fx-background-color: " + TColor.chooseRGBColor(colorRGB.getText()));
        });
        return colorRGBButton;
    }

    public JFXButton getColorHxdcmlButton() {
        colorHxdcmlButton.setOnAction(event -> {
            System.out.println("PROBLEM -> metoda chooseHexColor vracia objekt Color, ale ja tu potrebujem hexadecimal cislo... ako to mam vyriesit?");
           // layout.setStyle("-fx-background-color: " + TColor.chooseHexColor(colorHxdcml.getText()));

        });
        return colorHxdcmlButton;
    }
    //Setters
}
