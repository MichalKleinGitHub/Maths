package main.java.frontend.windowComponents.mainWindowComponents.mainMenuComponents;

import com.jfoenix.controls.JFXButton;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class LanguageBar {
    //Body of LanguageBar
    private Rectangle languageBarRectangle = new Rectangle();
    private Polygon languageBarTriangle = new Polygon();
    //Buttons
    private JFXButton english = new JFXButton("English");
    private JFXButton czech = new JFXButton("Česky");
    private JFXButton slovak = new JFXButton("Slovensky");

    private Group nodes = new Group(languageBarRectangle, languageBarTriangle,english, czech, slovak);

    public LanguageBar(){
        languageBarRectangle.setWidth(70);
        languageBarRectangle.setHeight(75);
        languageBarTriangle.getPoints().addAll(new Double[]{
                50.0, 85.0,
                40.0, 95.0,
                60.0, 95.0
        });


        english.setTextFill(Color.rgb(242,235,222));
        english.setPrefWidth(70);
        czech.setTextFill(Color.rgb(242,235,222));
        czech.setPrefWidth(70);
        slovak.setTextFill(Color.rgb(242,235,222));
        slovak.setPrefWidth(70);
        languageBarRectangle.setFill(Color.rgb(84, 80, 79));
        languageBarTriangle.setFill(Color.rgb(84, 80, 79));
    }


    public Group getNodes(){
        return nodes;
    }

    public JFXButton getEnglish() {
        return english;
    }

    public JFXButton getCzech() {
        return czech;
    }

    public JFXButton getSlovak() {
        return slovak;
    }
}
