package main.java.frontend.windows;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import main.java.backEnd.db.Login;

/**
 * LoginWindow will open, when user wants to login into his personal
 * account by clicking on "Login" button.
 *
 * @author klein
 * @since 28.8.2018
 */
public class LoginWindow {
    private TextField name = new TextField();
    private PasswordField password = new PasswordField();
    private JFXButton login = new JFXButton();

    private boolean loginWindowIsOpened;

    /**
     * Constructor of LoginWindow.
     */
    public LoginWindow(){
        setComponents();
    }

    /**
     * Method sets an ID names for purpose of easier language changing. Also sets Styles of components
     */
    private void setComponents() {
        name.setId("NameLogin");
        password.setId("PasswordLogin");
        login.setId("LoginLogin");

        //Toto tu nebude////////////
        //Rozvrhnutia budu v ResizeAllComponents triede
        name.setLayoutY(230);
        password.setLayoutY(280);
        login.setLayoutY(330);

        name.setPrefWidth(200);
        password.setPrefWidth(200);
        login.setPrefWidth(200);

        name.setLayoutX(1200/2-name.getPrefWidth()/2);
        password.setLayoutX(1200/2-password.getPrefWidth()/2);
        login.setLayoutX(1200/2-login.getPrefWidth()/2);

        name.setPromptText("meno");
        password.setPromptText("heslo");
        login.setText("prihlásiť");
///////////////////////////////////////////////////////////////////////////////


        login.setTextFill(Color.rgb(242, 235, 222));
        login.setStyle("-fx-background-color: #54504F");
        name.setStyle("-fx-alignment: center");
        password.setStyle("-fx-alignment: center");

        login.setOnAction(event -> {
            Login.checkUser(name.getText(), password.getText());
            System.out.println("čeklo sa");
        });
    }


    //Getters
    public TextField getName() {
        return name;
    }

    public PasswordField getPassword() {
        return password;
    }

    public JFXButton getLogin() {
        return login;
    }

    public boolean isLoginWindowIsOpened() {
        return loginWindowIsOpened;
    }

    //Setters
    public void setLoginWindowIsOpened(boolean value){
        loginWindowIsOpened = value;
    }
}
