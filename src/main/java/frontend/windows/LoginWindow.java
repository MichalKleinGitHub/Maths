package main.java.frontend.windows;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import main.java.backEnd.settings.Languages;
import main.java.frontend.FXLabeledList;

public class LoginWindow {
    private TextField name = new TextField();
    private PasswordField password = new PasswordField();
    private JFXButton login = new JFXButton();

    private Text nameT = new Text();
    private Text passwordT = new Text();

    private boolean loginWindowIsOpened;
    private Languages languages = new Languages();

    public LoginWindow(){
        setComponents();
    }

    private void setComponents() {
        name.setId("NameLogin");
        password.setId("PasswordLogin");
        login.setId("LoginLogin");

        //FXLabeledList.addFXNodes(name, password, login);

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

        login.setTextFill(Color.rgb(242, 235, 222));
        login.setStyle("-fx-background-color: #54504F");
        name.setStyle("-fx-alignment: center");
        password.setStyle("-fx-alignment: center");
    }

    public TextField getName() {
        return name;
    }

    public PasswordField getPassword() {
        return password;
    }

    public JFXButton getLogin() {
        return login;
    }

    public Text getNameT() {
        return nameT;
    }

    public Text getPasswordT() {
        return passwordT;
    }

    public boolean isLoginWindowIsOpened() {
        return loginWindowIsOpened;
    }

    public void setLoginWindowIsOpened(boolean value){
        loginWindowIsOpened = value;
    }
}
