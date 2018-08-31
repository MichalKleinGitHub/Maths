package main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

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
    //Body of LoginBar
    private Rectangle loginBarRectangle = new Rectangle();
    private Polygon loginBarTriangle = new Polygon();
    //Buttons
    private JFXButton login = new JFXButton("Login");
    private JFXButton register = new JFXButton("Register");
    private JFXButton logout = new JFXButton("Logout");

    private Group nodes = new Group(loginBarRectangle, loginBarTriangle, login, register, logout);

    /**
     * Constructor of LoginBar
     */
    public LoginBar(){
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
        return login;
    }
    public JFXButton getRegister() {
        return register;
    }
    public JFXButton getLogout() {
        return logout;
    }
}
