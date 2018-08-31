package main.java.frontend.windows;

import com.jfoenix.controls.JFXButton;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * RegisterWindow will open, when user wants to register his personal
 * account by clicking on "Register" button.
 *
 * @author klein
 * @since 28.8.2018
 */
public class RegisterWindow {
    private TextField name = new TextField();
    private TextField emailAddress = new TextField();
    private PasswordField password = new PasswordField();
    private TextField age = new TextField();
    private TextField gender = new TextField();
    private JFXButton register = new JFXButton();

    private boolean registerWindowIsOpened;

    /**
     * Constructor of RegisterWindow
     */
    public RegisterWindow(){
        setComponents();
    }


    /**
     * Method sets an ID names for purpose of easier language changing. Also sets Styles of components
     */
    private void setComponents() {
        name.setId("NameRegister");
        emailAddress.setId("EmailAddressRegister");
        password.setId("PasswordRegister");
        age.setId("AgeRegister");
        gender.setId("GenderRegister");
        register.setId("RegisterRegister");

//////////////////////////////////////////////////////////////////
        //Toto tu nebude////////////
        //Rozvrhnutia budu v ResizeAllComponents triede
        name.setLayoutY(200);
        emailAddress.setLayoutY(250);
        password.setLayoutY(300);
        gender.setLayoutY(350);
        age.setLayoutY(350);
        register.setLayoutY(400);

        name.setPrefWidth(200);
        emailAddress.setPrefWidth(200);
        password.setPrefWidth(200);
        age.setPrefWidth(80);
        gender.setPrefWidth(80);
        register.setPrefWidth(200);

        name.setLayoutX(1200/2-name.getPrefWidth()/2);
        emailAddress.setLayoutX(1200/2-name.getPrefWidth()/2);
        password.setLayoutX(1200/2-password.getPrefWidth()/2);
        age.setLayoutX(1200/2-name.getPrefWidth()/2);
        gender.setLayoutX(1200/2-name.getPrefWidth()/2 + 120);
        register.setLayoutX(1200/2- register.getPrefWidth()/2);

        name.setPromptText("meno");
        emailAddress.setPromptText("email");
        password.setPromptText("heslo");
        age.setPromptText("vek");
        gender.setPromptText("pohlavie");
        register.setText("registrovať");
///////////////////////////////////////////////////////////////////////


        name.setStyle("-fx-alignment: center");
        emailAddress.setStyle("-fx-alignment: center");
        password.setStyle("-fx-alignment: center");
        age.setStyle("-fx-alignment: center");
        gender.setStyle("-fx-alignment: center");
        register.setStyle("-fx-background-color: #54504F");
        register.setTextFill(Color.rgb(242, 235, 222));
    }

    //Getters
    public TextField getName() {
        return name;
    }

    public TextField getEmailAddress() {
        return emailAddress;
    }

    public PasswordField getPassword() {
        return password;
    }

    public TextField getAge() {
        return age;
    }

    public TextField getGender() {
        return gender;
    }

    public JFXButton getRegister() {
        return register;
    }

    public boolean isRegisterWindowIsOpened() {
        return registerWindowIsOpened;
    }

    //Setters
    public void setRegisterWindowIsOpened(boolean registerWindowIsOpened) {
        this.registerWindowIsOpened = registerWindowIsOpened;
    }
}

