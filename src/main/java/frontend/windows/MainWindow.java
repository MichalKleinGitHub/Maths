package main.java.frontend.windows;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.frontend.ResizeAllComponents;
import main.java.frontend.windowComponents.mainWindowComponents.MainMenu;

import java.awt.*;

/**
 * This class represents main stage, which is opened as first, after calling launchProgram() method in Maths class
 *
 * @author klein
 * @since 25.8.2018
 */
public class MainWindow extends Application {
    //Following constants are used to get current resolution of screen
    private final Toolkit tool = Toolkit.getDefaultToolkit();
    private final Dimension src = tool.getScreenSize();
    private final double initialWindowHeight = src.getHeight();
    private final double initialWindowWidth = src.getWidth();
    // na toto bych udělal v toolech třídu, která by měla možnost výběru barev
    private String layoutStyle = "-fx-background-color: #f2ebde";

    private MainMenu mainMenu;

    /**
     * This method sets all main components to display an application successfully (Stage, Scene, Layout, MainMenu)
     *
     * @param primaryStage This parameter isn't inserted by user
     */
    @Override
    public void start(Stage primaryStage){
        AnchorPane layout = new AnchorPane();
        layout.setStyle(layoutStyle);
        Scene scene = new Scene(layout, initialWindowWidth - 200, initialWindowHeight - 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Maths");
        primaryStage.show();

        mainMenu = new MainMenu(layout);

        //Resizovanie je momentálne celé rozbité :(
        //primaryStageWidthListener(primaryStage);
        //primaryStageHeightListener(primaryStage);
    }

    /**
     *
     * This method will be calling resizeWidth() method stored in ResizeAllComponents class, but for now the resizing system is broken
     *
     * @param primaryStage
     * @see ResizeAllComponents
     */
    private void primaryStageWidthListener(Stage primaryStage){
        if (!mainMenu.equals(null)){
            primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
                ResizeAllComponents.resizeWidth(primaryStage.getWidth(), mainMenu.getMenuBar(), mainMenu.getMyAccount(), mainMenu.getSpecifiedBar(), mainMenu.getLoginImage(), mainMenu.getLanguageImage(), mainMenu.getSettingsImage(), mainMenu.getLoginNodes(), mainMenu.getLanguageNodes());
            });
        }
    }


    /**
     *
     * @param primaryStage
     * This method will be calling resizeHeight() method stored in ResizeAllComponents class, but for now the resizing system is broken
     * @see ResizeAllComponents
     */

    private void primaryStageHeightListener(Stage primaryStage){
        if (!mainMenu.equals(null)) {
            primaryStage.heightProperty().addListener((obs, oldVal, newVal)-> {
                ResizeAllComponents.resizeHeight(primaryStage.getHeight(), mainMenu.getMenuBar(), mainMenu.getMyAccount(), mainMenu.getSpecifiedBar(),  mainMenu.getLoginImage(), mainMenu.getLanguageImage(),  mainMenu.getSettingsImage(), mainMenu.getLoginNodes(), mainMenu.getLanguageNodes());
            });
        }
    }

    /**
     * Thanks this method we are able to run application from another class
     * This is JavaFX syntax so launch redirect to start(Stage) method
     */
    public void launchProgram(){
        launch();
    }
}
