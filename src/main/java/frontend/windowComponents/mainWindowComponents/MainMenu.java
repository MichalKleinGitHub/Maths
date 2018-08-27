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

/**
 * @author klein
 * @since 26.8.2018
 *
 * This class is used as MainMenu bar, which is placed on the MainWindow (from windows package).
 */
public class MainMenu {
    private final AnchorPane layout;

    /**
     * Main Menu body contains:
     * menuBar = background, on which are placed buttons
     * myAccount = button for operating with settings of my account
     *
     *  //////////////
     *  other buttons will be defined and initialised here (calculator, theoryRoom, tests, solvedProblems, scheduling, tables, etc...)
     *  //////////////
     */
    private Rectangle menuBar = new Rectangle();
    private JFXButton myAccount = new JFXButton();

    /**
     * After clicking on any button placed on menuBar will open this - specified bar on which will be specified every ability of checked button
     */
    private Rectangle specifiedBar = new Rectangle();

    /**
     * specifiedBar buttons (images are used as buttons, thanks to mouse listeners)
     */
    private ImageView loginImage = new ImageView("main/resources/images/Male_User_50px.png");
    private ImageView settingsImage = new ImageView("main/resources/images/Services_50px.png");
    private ImageView languageImage = new ImageView("main/resources/images/Language_50px.png");

    private boolean isSpecifiedBarOpened;
    private boolean isLoginBarOpened;
    private boolean isLanguageBarOpened;

    private Languages languages = new Languages();
    private LoginBar loginBar = new LoginBar();
    private LanguageBar languageBar = new LanguageBar();
    private LoginWindow loginWindow = new LoginWindow();
    private RegisterWindow registerWindow = new RegisterWindow();

    /**
     *
     * @param layout
     * This is the constructor of MainMenu class
     */
    public MainMenu(AnchorPane layout) {
        this.layout = layout;

        setComponents();

        myAccountListener();
        loginListener();
        languageListener();
        ResizeAllComponents.resizeWidth(layout.getWidth(), menuBar, myAccount, specifiedBar, loginImage, languageImage, settingsImage, loginBar.getNodes(), languageBar.getNodes());
        ResizeAllComponents.resizeHeight(layout.getHeight(), menuBar, myAccount, specifiedBar, loginImage, languageImage, settingsImage, loginBar.getNodes(), languageBar.getNodes());
        layout.getChildren().addAll(menuBar, myAccount);
    }

    /**
     * This method is setting colors, adding nodes to the FXLabeledList, defines default language
     */
    private void setComponents(){
        menuBar.setFill(Color.rgb(84, 80, 79));
        menuBar.setStroke(null);
        //on menuBar
        myAccount.setLayoutY(1);
        myAccount.setLayoutX(layout.getWidth()-75);
        myAccount.setTextFill(Color.WHITE);
        //on myAccount
        specifiedBar.setFill(Color.rgb(84, 80, 79, 0.3));


        //Set id
        myAccount.setId("MyAccount");
        languageBar.getEnglish().setId("English");
        languageBar.getCzech().setId("Czech");
        languageBar.getSlovak().setId("Slovak");
        loginBar.getLogin().setId("Login");
        loginBar.getRegister().setId("Register");
        loginBar.getLogout().setId("Logout");

        //add nodes from MainMenu class
        FXLabeledList.addFXNodes(myAccount);
        //add all nodes from LanguageBar to FXLabeledList
        FXLabeledList.addFXNodes(languageBar.getEnglish(), languageBar.getCzech(), languageBar.getSlovak());
        //add all nodes from LoginBar to FXLabeledList
        FXLabeledList.addFXNodes(loginBar.getLogin(), loginBar.getRegister(), loginBar.getLogout());


        //setting default language
        languages.setLanguageFromConfigFile("EN");
    }

    /**
     * Method
     * This method contains an action system of myAccount button
     */

    private void myAccountListener() {
        myAccount.setOnAction(event -> {
            if (!isSpecifiedBarOpened){
                layout.getChildren().addAll(specifiedBar, loginImage, languageImage, settingsImage);
                isSpecifiedBarOpened = true;

            } else {
                isSpecifiedBarOpened = false;
                layout.getChildren().removeAll(specifiedBar, loginImage, languageImage, settingsImage);
                layout.getChildren().removeAll(loginBar.getNodes(), languageBar.getNodes());
                isLoginBarOpened = false;
                isLanguageBarOpened = false;
            }
        });
    }


    /**
     * Method
     * This method contains all mouse listeners for working with loginImage (login button)
     */
    private void loginListener() {
        loginImage.setOnMousePressed(event -> {
            if (!isLoginBarOpened){
                layout.getChildren().addAll(loginBar.getNodes());
                isLoginBarOpened = true;


                    /**
                     * tu mame big problem, pretoze neviem ako spravne spojazdnit tento listener :(
                     * funguje az po druhom otvoreni loginImage
                     */
                    loginBar.getLogin().setOnMousePressed(event1 -> {
                        if (!loginWindow.isLoginWindowIsOpened()) {
                            if (registerWindow.isRegisterWindowIsOpened()){
                                layout.getChildren().removeAll(registerWindow.getName(), registerWindow.getEmailAddress(), registerWindow.getPassword(), registerWindow.getGender(), registerWindow.getAge(), registerWindow.getRegister());
                                registerWindow.setRegisterWindowIsOpened(false);
                            }
                            layout.getChildren().addAll(loginWindow.getLogin(),loginWindow.getName(), loginWindow.getPassword(), loginWindow.getNameT(), loginWindow.getPasswordT());
                            loginWindow.setLoginWindowIsOpened(true);
                            System.out.println("Login");
                        } else {
                            System.out.println("Okno Login uz je otvorene");
                        }
                    });

                    loginBar.getRegister().setOnMousePressed(event1 -> {
                        if (!registerWindow.isRegisterWindowIsOpened()) {
                            if (loginWindow.isLoginWindowIsOpened()){
                                layout.getChildren().removeAll(loginWindow.getLogin(),loginWindow.getName(), loginWindow.getPassword(), loginWindow.getNameT(), loginWindow.getPasswordT());
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
     * Method
     * This method contains all mouse listeners for working with languageImage (language button)
     */
    private void languageListener() {
        languageImage.setOnMousePressed(event1 -> {
            if (!isLanguageBarOpened){
                layout.getChildren().addAll(languageBar.getNodes());
                isLanguageBarOpened = true;


                /**
                 * tu mame big problem, pretoze neviem ako spravne spojazdnit tieto listeners :(
                 * funguje az po druhom otvoreni languageImage
                 */

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

    public JFXButton getMyAccount() {
        return myAccount;
    }

    public Rectangle getSpecifiedBar() {
        return specifiedBar;
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
