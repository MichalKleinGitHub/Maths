package main.java.frontend;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 * THIS CLASS IS NOT WORKING, it is supposed to resize ALL components in porject after any width or height change
 *
 * @author klein
 * @since 25.8.2018
 */

public class ResizeAllComponents {

    public static void resizeWidth(double actualWidth, Rectangle menuBar, JFXButton myAccount, Rectangle myAccountBar, ImageView loginImage, ImageView languageImage, ImageView settingsImage, Group loginBarNodes, Group languageBarNodes) {
        menuBar.setWidth(actualWidth);
        //My Account
        //myAccount.setLayoutX(actualWidth/100);
        myAccountBar.setWidth(actualWidth);
        myAccountBar.setWidth(actualWidth);
        loginImage.setLayoutX(400);
        loginImage.setFitWidth(actualWidth/20.5);
        languageImage.setLayoutX(600);
        languageImage.setFitWidth(actualWidth/20.5);
        settingsImage.setLayoutX(500);
        settingsImage.setFitWidth(actualWidth/20.5);

        //loginBarNodes
        loginBarNodes.getChildren().get(0).setLayoutX(loginImage.getLayoutX());
        loginBarNodes.getChildren().get(1).setLayoutX(loginImage.getLayoutX() - 20);
        loginBarNodes.getChildren().get(2).setLayoutX(loginImage.getLayoutX());
        loginBarNodes.getChildren().get(3).setLayoutX(loginImage.getLayoutX());
        loginBarNodes.getChildren().get(4).setLayoutX(loginImage.getLayoutX());

        //languageBarNodes
        languageBarNodes.getChildren().get(0).setLayoutX(languageImage.getLayoutX());
        languageBarNodes.getChildren().get(1).setLayoutX(languageImage.getLayoutX() - 20);
        languageBarNodes.getChildren().get(2).setLayoutX(languageImage.getLayoutX());
        languageBarNodes.getChildren().get(3).setLayoutX(languageImage.getLayoutX());
        languageBarNodes.getChildren().get(4).setLayoutX(languageImage.getLayoutX());
    }

    public static void resizeHeight(double actualHeight, Rectangle menuBar, JFXButton myAccount, Rectangle myAccountBar, ImageView loginImage, ImageView languageImage, ImageView settingsImage, Group loginBarNodes, Group languageBarNodes){
        menuBar.setHeight(actualHeight/100*5);
        //My Account
        //myAccount.setLayoutY((menuBar.getHeight()/2) - 12.5);
        myAccountBar.setHeight(actualHeight/11);
        myAccountBar.setTranslateY(menuBar.getHeight());
        loginImage.setLayoutY(menuBar.getHeight());
        loginImage.setFitHeight(myAccountBar.getHeight());
        languageImage.setLayoutY(menuBar.getHeight());
        languageImage.setFitHeight(myAccountBar.getHeight());
        settingsImage.setLayoutY(menuBar.getHeight());
        settingsImage.setFitHeight(myAccountBar.getHeight());

        //loginBarNodes
        loginBarNodes.getChildren().get(0).setLayoutY(actualHeight/6);
        loginBarNodes.getChildren().get(2).setLayoutY(actualHeight/6);
        loginBarNodes.getChildren().get(3).setLayoutY((actualHeight/6) + 25);
        loginBarNodes.getChildren().get(4).setLayoutY((actualHeight/6) + 50);

        //languageBarNodes

        languageBarNodes.getChildren().get(0).setLayoutY(actualHeight/6);
        languageBarNodes.getChildren().get(2).setLayoutY(actualHeight/6);
        languageBarNodes.getChildren().get(3).setLayoutY((actualHeight/6) + 25);
        languageBarNodes.getChildren().get(4).setLayoutY((actualHeight/6) + 50);
    }
}























