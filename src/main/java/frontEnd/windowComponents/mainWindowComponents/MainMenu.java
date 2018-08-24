package main.java.frontEnd.windowComponents.mainWindowComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.java.frontEnd.ResizeAllComponents;
import main.java.frontEnd.windowComponents.mainWindowComponents.mainMenuComponents.LoginSystemBar;

public class MainMenu {
    private final AnchorPane layout;

    //Main Menu
    private Rectangle menuBar = new Rectangle();
    private JFXButton myAccount = new JFXButton();
    private JFXButton settings = new JFXButton();

    //MyAccount Sub-menu
    private Rectangle myAccountBar = new Rectangle();
    private JFXButton login = new JFXButton();
    private ImageView loginImage = new ImageView("main/resources/images/Male_User_50px.png");
    private ImageView settingsImage = new ImageView("main/resources/images/Services_50px.png");
    private boolean myAccountBarIsOpened;
    private boolean isLoginSystemBarOpened;

    //Settings Sub-menu
    private Rectangle settingsBar = new Rectangle();
    private boolean settingsBarIsOpened;
    private ImageView languageImage = new ImageView("main/resources/images/Language_50px.png");

    //Dočasné načítanie zo Stringov
    private String myAccountText = "Môj účet";
    private String settingsText = "Nastavenia";
    private String loginText = "Prihlásiť sa";

    public MainMenu(AnchorPane layout) {
        this.layout = layout;

        setAllComponents();
        //settingsListener(); Zatial neviem, ci takto rozvrhneme menu
        myAccountListener();
        //loginSystemListener(); Nie je hotovy Resize system

        ResizeAllComponents.resizeWidth(layout.getWidth(), menuBar, myAccount, myAccountBar, login, loginImage, settings, settingsBar, languageImage, myAccountBarIsOpened, settingsBarIsOpened, settingsImage);
        ResizeAllComponents.resizeHeight(layout.getHeight(), menuBar, myAccount, myAccountBar, login, loginImage, settings, settingsBar, languageImage, myAccountBarIsOpened, settingsBarIsOpened, settingsImage);

        layout.getChildren().addAll(menuBar, myAccount, settings);
    }
/*
    private void loginSystemListener() {
        LoginSystemBar loginSystemBar = new LoginSystemBar(layout.getWidth(), layout.getHeight());
        loginImage.setOnMousePressed(event -> {
            if (!isLoginSystemBarOpened){
                layout.getChildren().add(loginSystemBar.getLoginSystemBarRectangle());
                isLoginSystemBarOpened = true;
            } else {
                layout.getChildren().remove(loginSystemBar.getLoginSystemBarRectangle());
                isLoginSystemBarOpened = false;
            }
        });
    }


        private void settingsListener() {
            settings.setOnAction(event -> {
                if (!settingsBarIsOpened){
                    layout.getChildren().addAll(settingsBar, languageImage);
                    settingsBarIsOpened = true;
                    if (myAccountBarIsOpened){
                        myAccountBarIsOpened = false;
                        layout.getChildren().removeAll(myAccountBar, loginImage);
                    }
                } else {
                    settingsBarIsOpened = false;
                    layout.getChildren().removeAll(settingsBar, languageImage);
                }
            });
        }
    */
    private void myAccountListener() {
        myAccount.setOnAction(event -> {
            if (!myAccountBarIsOpened){
                layout.getChildren().addAll(myAccountBar, loginImage, languageImage, settingsImage);
                myAccountBarIsOpened = true;
                if (settingsBarIsOpened){
                    layout.getChildren().removeAll(settingsBar, languageImage);
                    settingsBarIsOpened = false;
                }
            } else {
                myAccountBarIsOpened = false;
                layout.getChildren().removeAll(myAccountBar, loginImage, languageImage, settingsImage);
            }
        });
    }

    private void setAllComponents(){
        menuBar.setFill(Color.rgb(84, 80, 79));
        menuBar.setStroke(null);

        //on menuBar
        myAccount.setTextFill(Color.WHITE);
        myAccount.setText(myAccountText);

        settings.setTextFill(Color.WHITE);
        settings.setText(settingsText);

        //on myAccount
        myAccountBar.setFill(Color.rgb(84, 80, 79, 0.3));
        login.setText(loginText);
        login.setTextFill(Color.WHITE);

        //on settings
        settingsBar.setFill(Color.rgb(84, 80, 79, 0.3));
    }

    public Rectangle getMenuBar() {
        return menuBar;
    }

    public JFXButton getMyAccount() {
        return myAccount;
    }

    public JFXButton getSettings() {
        return settings;
    }

    public Rectangle getMyAccountBar() {
        return myAccountBar;
    }

    public boolean isMyAccountBarIsOpened() {
        return myAccountBarIsOpened;
    }

    public JFXButton getLogin() {
        return login;
    }

    public ImageView getLoginImage() {
        return loginImage;
    }

    public ImageView getSettingsImage() {
        return settingsImage;
    }

    public Rectangle getSettingsBar() {
        return settingsBar;
    }

    public boolean isSettingsBarIsOpened() {
        return settingsBarIsOpened;
    }

    public ImageView getLanguageImage() {
        return languageImage;
    }
}
