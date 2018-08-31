package main.java.frontend.windowComponents.mainWindowComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import main.java.backEnd.settings.Languages;
import main.java.frontend.FXLabeledList;
import main.java.frontend.ResizeAllComponents;
import main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents.LanguageBar;
import main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents.LoginBar;
import main.java.frontend.windows.LoginWindow;
import main.java.frontend.windows.RegisterWindow;
import main.java.frontend.windows.SettingsWindow;

/**
 * This class is used as main menu, which is placed on the top of layout. Main menu body contains:
 * <li>menuBar = background, which buttons are placed on</li>
 * <li>myAccountButton = button for operating with settings of my account</li>
 *
 *  TODO other buttons will be defined and initialised here (calculator, theoryRoom, tests, solvedProblems, scheduling, tables, etc...)
 *
 * @author klein
 * @since 26.8.2018
 */
public class MainMenu {
    private final AnchorPane layout;

    private Rectangle menuBar = new Rectangle();
    private JFXButton myAccountButton = new JFXButton();
    private Rectangle subMenuBar = new Rectangle();

    //subMenuBar buttons (images are used as buttons)
    private ImageView loginImage = new ImageView("main/resources/images/Male_User_50px.png");
    private ImageView settingsImage = new ImageView("main/resources/images/Services_50px.png");
    private ImageView languageImage = new ImageView("main/resources/images/Language_50px.png");

    private boolean isSubMenuBarOpened;
    private boolean isLoginBarOpened;
    private boolean isLanguageBarOpened;
    private boolean isSettingsBarOpened;

    private Languages languages = new Languages();
    private LoginBar loginBar = new LoginBar();
    private LanguageBar languageBar = new LanguageBar();
    private LoginWindow loginWindow = new LoginWindow();
    private RegisterWindow registerWindow = new RegisterWindow();
    private SettingsWindow settingsWindow = new SettingsWindow();

    /**
     * This is the constructor of MainMenu class
     *
     * @param layout
     */
    public MainMenu(AnchorPane layout) {
        this.layout = layout;

        //sets components placed on main menu
        setComponents();

        //here are called all main menu listeners
        myAccountListener();
        loginListener();
        settingsListener();
        languageListener();

        //all components must be resized on the base of height and width of users monitor
        ResizeAllComponents.resizeWidth(layout.getWidth(), menuBar, myAccountButton, subMenuBar, loginImage, languageImage, settingsImage, loginBar.getNodes(), languageBar.getNodes());
        ResizeAllComponents.resizeHeight(layout.getHeight(), menuBar, myAccountButton, subMenuBar, loginImage, languageImage, settingsImage, loginBar.getNodes(), languageBar.getNodes());

        //all components are added on layout
        layout.getChildren().addAll(menuBar, myAccountButton);
    }

    /**
     * This method sets colors, adds nodes to the FXLabeledList and defines default language
     */
    private void setComponents(){
        menuBar.setFill(Color.rgb(84, 80, 79));
        menuBar.setStroke(null);
        //on menuBar
        myAccountButton.setLayoutY(1);
        myAccountButton.setLayoutX(layout.getWidth()-75);
        myAccountButton.setTextFill(Color.WHITE);
        //on myAccountButton
        subMenuBar.setFill(Color.rgb(84, 80, 79, 0.3));

        //Set id
        myAccountButton.setId("MyAccount");
        languageBar.getEnglish().setId("English");
        languageBar.getCzech().setId("Czech");
        languageBar.getSlovak().setId("Slovak");
        loginBar.getLogin().setId("Login");
        loginBar.getRegister().setId("Register");
        loginBar.getLogout().setId("Logout");

        //add nodes from MainMenu class
        FXLabeledList.addFXNodes(myAccountButton);
        //add all nodes from LanguageBar to FXLabeledList
        FXLabeledList.addFXNodes(languageBar.getEnglish(), languageBar.getCzech(), languageBar.getSlovak());
        //add all nodes from LoginBar to FXLabeledList
        FXLabeledList.addFXNodes(loginBar.getLogin(), loginBar.getRegister(), loginBar.getLogout());

        //setting default language
        languages.setLanguageFromConfigFile("EN");
    }

    /**
     * This method contains an action system of myAccountButton button
     */

    private void myAccountListener() {
        myAccountButton.setOnAction(event -> {
            if (!isSubMenuBarOpened){
                layout.getChildren().addAll(subMenuBar, loginImage, languageImage, settingsImage);
                isSubMenuBarOpened = true;

            } else {
                isSubMenuBarOpened = false;
                layout.getChildren().removeAll(subMenuBar, loginImage, languageImage, settingsImage);
                layout.getChildren().removeAll(loginBar.getNodes(), languageBar.getNodes());
                isLoginBarOpened = false;
                isLanguageBarOpened = false;
            }
        });
    }


    /**
     * This method contains all mouse listeners for working with loginImage (login button)
     */
    private void loginListener() {
        loginImage.setOnMousePressed(event -> {
            if (!isLoginBarOpened){
                layout.getChildren().addAll(loginBar.getNodes());
                isLoginBarOpened = true;

                    loginBar.getLogin().setOnMousePressed(event1 -> {
                        if (!loginWindow.isLoginWindowIsOpened()) {
                            if (registerWindow.isRegisterWindowIsOpened()){
                                layout.getChildren().removeAll(registerWindow.getName(), registerWindow.getEmailAddress(), registerWindow.getPassword(), registerWindow.getGender(), registerWindow.getAge(), registerWindow.getRegister());
                                registerWindow.setRegisterWindowIsOpened(false);
                            }
                            layout.getChildren().addAll(loginWindow.getLogin(),loginWindow.getName(), loginWindow.getPassword());
                            loginWindow.setLoginWindowIsOpened(true);
                            System.out.println("Login");
                        } else {
                            System.out.println("Okno Login uz je otvorene");
                        }
                    });

                    loginBar.getRegister().setOnMousePressed(event1 -> {
                        if (!registerWindow.isRegisterWindowIsOpened()) {
                            if (loginWindow.isLoginWindowIsOpened()){
                                layout.getChildren().removeAll(loginWindow.getLogin(),loginWindow.getName(), loginWindow.getPassword());
                                loginWindow.setLoginWindowIsOpened(false);
                            }
                            layout.getChildren().addAll(registerWindow.getName(), registerWindow.getEmailAddress(), registerWindow.getPassword(), registerWindow.getGender(), registerWindow.getAge(), registerWindow.getRegister());
                            registerWindow.setRegisterWindowIsOpened(true);
                            System.out.println("Register");
                        } else {
                            System.out.println("Okno Register uz je otvorene");
                        }
                    });
            } else {
                layout.getChildren().removeAll(loginBar.getNodes());
                isLoginBarOpened = false;
            }
        });
    }

    /**
     * This method contains all mouse listeners for working with settingsImage (settings button)
     */
    private void settingsListener() {
        settingsImage.setOnMousePressed(event -> {
            if (!isSettingsBarOpened){
                layout.getChildren().addAll(settingsWindow.getPalette());
                System.out.println("OTVOR");
                isSettingsBarOpened = true;
            } else {
                layout.getChildren().removeAll(settingsWindow.getPalette());
                System.out.println("ZATVOR");
                isSettingsBarOpened = false;
            }
        });
    }

    /**
     * This method contains all mouse listeners for working with languageImage (language button)
     */
    private void languageListener() {
        languageImage.setOnMousePressed(event1 -> {
            if (!isLanguageBarOpened){
                layout.getChildren().addAll(languageBar.getNodes());
                isLanguageBarOpened = true;


                  //tu mame big problem, pretoze neviem ako spravne spojazdnit tieto listeners :(
                  //funguje az po druhom otvoreni languageImage

                languageBar.getEnglish().setOnMousePressed(event2 -> {
                        languages.setLanguageFromConfigFile("EN");
                });

                languageBar.getCzech().setOnMousePressed(event2 -> {
                        languages.setLanguageFromConfigFile("CZ");
                });

                languageBar.getSlovak().setOnMousePressed(event2 -> {
                        languages.setLanguageFromConfigFile("SK");
                });
            } else {
                layout.getChildren().removeAll(languageBar.getNodes());
                isLanguageBarOpened = false;
            }
        });
    }


    // Getters
    ///////////////////////////////

    public Rectangle getMenuBar() {
        return menuBar;
    }

    public JFXButton getMyAccountButton() {
        return myAccountButton;
    }

    public Rectangle getSubMenuBar() {
        return subMenuBar;
    }

    public ImageView getLoginImage() {
        return loginImage;
    }

    public ImageView getSettingsImage() {
        return settingsImage;
    }

    public ImageView getLanguageImage() {
        return languageImage;
    }

    public Group getLoginNodes(){
        return loginBar.getNodes();
    }
    public Group getLanguageNodes(){
        return languageBar.getNodes();
    }
}
