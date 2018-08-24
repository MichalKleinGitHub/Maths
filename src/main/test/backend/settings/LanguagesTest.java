package main.test.backend.settings;

import javax.swing.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import main.java.backEnd.settings.Languages;
import main.java.frontend.FXLabeledList;
import org.junit.Before;
import org.junit.Test;

/**
 * @author lpesek6862hc
 * @since 22.08.2018
 */
public class LanguagesTest extends Application {

    private Stage stage;

    @Before
    public void setUp() throws Exception {
        launch();
    }

    @Test
    public void testLanguages() {

    }

    @Override
    public void start(final Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.setGridLinesVisible(true);
        Languages languages = new Languages();
        for (int i = 0; i < 20; i++) {
            Button button = new Button();
            button.setPrefSize(125, 50);
            button.setId("BUTTON");
            gridPane.add(button, i, 0);
            FXLabeledList.addFXNodes(button);
            if (i == 2) {
                button.setId(null);
                button.setStyle("-fx-background-color: yellow");
                button.setText("EN");
                button.setOnAction(evt -> languages.setLanguageFromConfigFile("EN"));
            }
            if (i == 1) {
                button.setId(null);
                button.setStyle("-fx-background-color: blue");
                button.setText("SK");
                button.setOnAction(evt -> languages.setLanguageFromConfigFile("SK"));
            }
            if (i == 0) {
                button.setId(null);
                button.setStyle("-fx-background-color: red");
                button.setText("CZ");
                button.setOnAction(evt -> languages.setLanguageFromConfigFile("CZ"));
            }
            if (i > 11) {
                button.setId("BUTTON2");
            }
        }
        Scene scene = new Scene(gridPane, 1000, 50);
        stage = primaryStage;
        stage.setScene(scene);
        stage.show();
    }
}
