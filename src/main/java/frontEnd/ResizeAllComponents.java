package main.java.frontEnd;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class ResizeAllComponents {

    public static void resizeWidth(double actualWidth, Rectangle menuBar, JFXButton myAccount, Rectangle myAccountBar, JFXButton login, ImageView loginImage, JFXButton settings, Rectangle settingsBar, ImageView languageImage, boolean myAccountBarIsOpened, boolean settingsBarIsOpened, ImageView settingsImage) {
        menuBar.setWidth(actualWidth);
        //My Account
        myAccount.setLayoutX(actualWidth/100);
        myAccount.setPrefWidth(actualWidth/15);
        myAccountBar.setWidth(actualWidth);
        myAccountBar.setWidth(actualWidth);
        login.setLayoutX(actualWidth/100);
        login.setPrefWidth(actualWidth/15);
        loginImage.setLayoutX(actualWidth/50);
        loginImage.setFitWidth(actualWidth/20.5);

        //Settings
        settings.setLayoutX(actualWidth/100*10);
        settings.setPrefWidth(actualWidth/15);
        settingsBar.setWidth(menuBar.getWidth());
        settingsBar.setWidth(actualWidth);
        languageImage.setLayoutX(actualWidth/5.5);
        languageImage.setFitWidth(actualWidth/20.5);
        settingsImage.setLayoutX(actualWidth/10);
        settingsImage.setFitWidth(actualWidth/20.5);
    }

    public static void resizeHeight(double actualHeight, Rectangle menuBar, JFXButton myAccount, Rectangle myAccountBar, JFXButton login, ImageView loginImage, JFXButton settings, Rectangle settingsBar, ImageView languageImage, boolean myAccountBarIsOpened, boolean settingsBarIsOpened, ImageView settingsImage){
        menuBar.setHeight(actualHeight/100*5);
        //My Account
        myAccount.setLayoutY((menuBar.getHeight()/2) - 12.5);
        myAccountBar.setHeight(actualHeight/11);
        myAccountBar.setTranslateY(menuBar.getHeight());
        login.setLayoutY(menuBar.getHeight() + myAccountBar.getHeight() - 30);
        loginImage.setLayoutY(menuBar.getHeight());
        loginImage.setFitHeight(myAccountBar.getHeight());

        //Settings
        settings.setLayoutY((menuBar.getHeight()/2) - 12.5);
        settingsBar.setHeight(actualHeight/11);
        settingsBar.setTranslateY(menuBar.getHeight());
        languageImage.setLayoutY(menuBar.getHeight());
        languageImage.setFitHeight(settingsBar.getHeight());
        settingsImage.setLayoutY(menuBar.getHeight());
        settingsImage.setFitHeight(myAccountBar.getHeight());
    }
}























