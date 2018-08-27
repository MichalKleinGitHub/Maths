package main.java;

import main.java.frontend.windows.MainWindow;

/**
 * @author klein
 * @since 24.8.2018
 * @version 1.0
 *
 * This class is the launcher of project
 */
public class Maths{

    /**
     * This String represents actual version of project
     * The number standing before a decimal point has a meaning of current task that we have scheduled in List_of_Stories
     * The number standing behind a decimal point has a meaning of current commit
     * @see List_of_Stories (in Maths package)
     */
    public static final String VERSION = "1.0";

    /**
     *
     * @param args
     * Create new instance of MainWindow class and call its launchProgram() method
     */
    public static void main(String[] args) {
        new MainWindow().launchProgram();
    }
}

