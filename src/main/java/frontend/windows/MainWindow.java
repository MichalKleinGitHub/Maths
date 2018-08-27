package main.java.frontend.windows;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.frontend.ResizeAllComponents;
import main.java.frontend.windowComponents.mainWindowComponents.MainMenu;

import java.awt.*;

/**
 * @author klein
 * @since 25.8.2018
 *
 * This class represents main stage, which is opened as first, after callig launchProgram() method in Maths class
 */
public class MainWindow extends Application {

    /**
     * These private final Objects and primitives are used to resizing our layout on the base of height and width of monitor
     * used to display an application
     */
    private final Toolkit tool = Toolkit.getDefaultToolkit();
    private final Dimension src = tool.getScreenSize();
    private final double INITIAL_WINDOW_HEIGHT = src.getHeight();
    private final double INITIAL_WINDOW_WIDTH = src.getWidth();
    ///////////////////////////////////////////////////////////
    private String layoutStyle = "-fx-background-color: #f2ebde"; // <- v buducnosti budeme farby tiez nacitat z configu

    private MainMenu mainMenu;

    /**
     *
     * @param primaryStage
     * This method is setting all main components for displaying an application successfuly (Stage, Scene, pane, MainMenu (for now)
     */
    @Override
    public void start(Stage primaryStage){
        AnchorPane layout = new AnchorPane();
        layout.setStyle(layoutStyle);
        Scene scene = new Scene(layout, 1366 - 200, 768 - 200);
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
     * @param primaryStage
     * This method will be calling resizeWidth() method stored in ResizeAllComponents class, but for now the resizing system is broken
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
     * This method is calling start() method
     */
    public void launchProgram(){
        launch();
    }
}
