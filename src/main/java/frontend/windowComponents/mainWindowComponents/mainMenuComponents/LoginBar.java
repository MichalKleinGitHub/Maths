package main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import main.java.frontend.windows.LoginWindow;
import main.java.frontend.windows.RegisterWindow;

/**
 * This class is used as menu for working with  which will open after clicking on loginImage (button)(in MainMenu class). Login bar body contains:
 * <li>Login = button for opening LoginWindow</li>
 * <li>Register = button for opening RegisterWindow</li>
 * <li>Logout = button for logout of users account</li>
 *
 * @author klein
 * @since 29.8.2018
 */
public class LoginBar {
    private AnchorPane layout;
    //Body of LoginBar
    private Rectangle loginBarRectangle = new Rectangle();
    private Polygon loginBarTriangle = new Polygon();
    //Buttons
    private JFXButton login = new JFXButton("Login");
    private JFXButton register = new JFXButton("Register");
    private JFXButton logout = new JFXButton("Logout");

    private Group nodes = new Group(loginBarRectangle, loginBarTriangle, login, register, logout);
    private LoginWindow loginWindow = new LoginWindow();
    private RegisterWindow registerWindow = new RegisterWindow();

    /**
     * Constructor of LoginBar
     */
    public LoginBar(AnchorPane layout){
        this.layout = layout;
        loginBarRectangle.setWidth(70);
        loginBarRectangle.setHeight(75);
        loginBarTriangle.getPoints().addAll(new Double[]{
                50.0, 85.0,
                40.0, 95.0,
                60.0, 95.0
        });

        login.setTextFill(Color.rgb(242,235,222));
        login.setPrefWidth(70);
        register.setTextFill(Color.rgb(242,235,222));
        register.setPrefWidth(70);
        logout.setTextFill(Color.rgb(242,235,222));
        logout.setPrefWidth(70);
        loginBarRectangle.setFill(Color.rgb(84, 80, 79));
        loginBarTriangle.setFill(Color.rgb(84, 80, 79));
    }


    //Getters
    public Group getNodes(){
            return nodes;
    }

    public JFXButton getLogin(){
        login.setOnAction(event1 -> {
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
        return login;
    }
    public JFXButton getRegister() {
        register.setOnAction(event1 -> {
            if (!registerWindow.isRegisterWindowIsOpened()) {
                //if login window is opened, it will be closed
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
        return register;
    }
    public JFXButton getLogout() {
        return logout;
    }
}
