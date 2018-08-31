package main.java;

import main.java.frontend.windows.MainWindow;

/**
 * This class is the launcher of the project
 * Actual version of the project is saved in the VERSION variable. VERSION contains 3 numbers:
 * <li>1.st number = version (version now release when we deal)</li>
 * <li>2.nd number = task that we have scheduled in List_of_Stories</li>
 * <li>3.rd number = current commit</li>
 *
 * @author klein
 * @since 24.8.2018
 */
public class Maths {

    public static final String VERSION = "1.0.5";

    /**
     * Create new instance of MainWindow class
     * //TODO mainWindow by mohl být singleton a hlavně by se mohl kontorlovat, aby se spustila vždy jen jedna instance
     *
     * @param args
     */
    public static void main(String[] args) {
        new MainWindow().launchProgram();
    }
}

