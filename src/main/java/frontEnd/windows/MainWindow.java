package main.java.frontEnd.windows;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.java.frontEnd.ResizeAllComponents;
import main.java.frontEnd.windowComponents.mainWindowComponents.MainMenu;

import java.awt.*;

public class MainWindow extends Application {

    private final Toolkit tool = Toolkit.getDefaultToolkit();
    private final Dimension src = tool.getScreenSize();
    private final double INITIAL_WINDOW_HEIGHT = src.getHeight();
    private final double INITIAL_WINDOW_WIDTH = src.getWidth();
    private String layoutStyle = "-fx-background-color: #f2ebde";

    @Override
    public void start(Stage primaryStage){
        AnchorPane layout = new AnchorPane();
        layout.setStyle(layoutStyle);
        Scene scene = new Scene(layout, INITIAL_WINDOW_WIDTH - 200, INITIAL_WINDOW_HEIGHT - 200);
        primaryStage.setScene(scene);
        primaryStage.show();

        MainMenu mainMenu = new MainMenu(layout);

        primaryStage.widthProperty().addListener((obs, oldVal, newVal) -> {
            ResizeAllComponents.resizeWidth(primaryStage.getWidth(), mainMenu.getMenuBar(), mainMenu.getMyAccount(), mainMenu.getMyAccountBar(), mainMenu.getLogin(), mainMenu.getLoginImage(), mainMenu.getSettings(), mainMenu.getSettingsBar(), mainMenu.getLanguageImage(), mainMenu.isMyAccountBarIsOpened(), mainMenu.isSettingsBarIsOpened(), mainMenu.getSettingsImage());
        });

        primaryStage.heightProperty().addListener((obs, oldVal, newVal)-> {
            ResizeAllComponents.resizeHeight(primaryStage.getHeight(), mainMenu.getMenuBar(), mainMenu.getMyAccount(), mainMenu.getMyAccountBar(), mainMenu.getLogin(), mainMenu.getLoginImage(), mainMenu.getSettings(), mainMenu.getSettingsBar(), mainMenu.getLanguageImage(), mainMenu.isMyAccountBarIsOpened(), mainMenu.isSettingsBarIsOpened(), mainMenu.getSettingsImage());
        });
    }

    public void start(){
        launch();
    }
}
