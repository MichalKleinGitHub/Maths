package main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class LoginBar {
    //Body of LoginBar
    private Rectangle loginSystemBarRectangle = new Rectangle();
    private Polygon loginSystemBarTriangle = new Polygon();
    //Buttons
    private JFXButton login = new JFXButton("Login");
    private JFXButton register = new JFXButton("Register");
    private JFXButton logout = new JFXButton("Logout");

    private Group nodes = new Group(loginSystemBarRectangle, loginSystemBarTriangle, login, register, logout);

    public LoginBar(){

        loginSystemBarRectangle.setWidth(70);
        loginSystemBarRectangle.setHeight(75);
        loginSystemBarTriangle.getPoints().addAll(new Double[]{
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
        loginSystemBarRectangle.setFill(Color.rgb(84, 80, 79));
        loginSystemBarTriangle.setFill(Color.rgb(84, 80, 79));
    }

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
